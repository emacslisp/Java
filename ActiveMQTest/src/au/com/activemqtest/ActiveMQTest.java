package au.com.activemqtest;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.ActiveMQXAConnectionFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.jms.*;

public class ActiveMQTest implements MessageListener {

	private static int ackMode;
    private static String messageQueueName;
    private static String messageBrokerUrl;

    private Session session;
    private boolean transacted = false;
    private MessageProducer replyProducer;
    private MessageProtocol messageProtocol;
    
    public enum MESSAGE_HEADER {
		VOCUS_REQ_NAME,
		VOCUS_REPLY_TO,
		VOCUS_CORRELATION_ID
	}
	
	public enum EXCHANGE_HEADER {
		INTEGRATION_API,
		DEV,
		TEST,
		UAT,
		NO_REPLY,
		ORG_MSG,
		ORG_REQ,
		ASSIGNMENT_GROUP,
		ASSIGNED_TO,
		TICKET_MSG
	}

    static {
        messageBrokerUrl = "failover:(tcp://175.45.91.163:61616)?timeout=3000";
        messageQueueName = "WEBNMS_IN";
        ackMode = Session.AUTO_ACKNOWLEDGE;
    }

    public ActiveMQTest() {
        try {
            //This message broker is embedded
            BrokerService broker = new BrokerService();
            broker.setPersistent(false);
            broker.setUseJmx(false);
            broker.addConnector(messageBrokerUrl);
            broker.start();
        } catch (Exception e) {
            //Handle the exception appropriately
        }

        //Delegating the handling of messages to another class, instantiate it before setting up JMS so it
        //is ready to handle messages
        this.messageProtocol = new MessageProtocol();
        this.setupMessageQueueConsumer();
    }

    private void setupMessageQueueConsumer() {
        ActiveMQXAConnectionFactory connectionFactory = new ActiveMQXAConnectionFactory(messageBrokerUrl);
        Connection connection;
        try {
        	connectionFactory.setUserName("msgUser");
        	connectionFactory.setPassword("msgPass");
            connection = connectionFactory.createConnection();
            connection.start();
            this.session = connection.createSession(this.transacted, ackMode);
            Destination adminQueue = this.session.createQueue(messageQueueName);

            //Setup a message producer to respond to messages from clients, we will get the destination
            //to send to from the JMSReplyTo header field from a Message
            this.replyProducer = this.session.createProducer(null);
            this.replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            //Set up a consumer to consume messages off of the admin queue
            MessageConsumer consumer = this.session.createConsumer(adminQueue);
            consumer.setMessageListener(this);
        } catch (JMSException e) {
            //Handle the exception appropriately
        	System.out.println(e);
        }
    }
    
    public String readFile(String path, Charset encoding) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public String loadJonsFile() {
    	String result="";
		try {
			result = readFile("/Users/di.wu/dev/test/1.json",Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }

    public void onMessage(Message message) {
        try {
            /*TextMessage response = this.session.createTextMessage();
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String messageText = txtMsg.getText();
                response.setText(this.messageProtocol.handleProtocolMessage(messageText));
            }
            
            // message.

            //Set the correlation ID from the received message to be the correlation id of the response message
            //this lets the client identify which message this is a response to if it has more than
            //one outstanding message to the server
            response.setJMSCorrelationID(message.getJMSCorrelationID());
             */
        	String json = loadJonsFile();
            TextMessage responseMsg = this.session.createTextMessage();
            responseMsg.setText(json);
            
            if(message.propertyExists("reply-to")) {
            	Queue q = session.createQueue(message.getStringProperty("reply-to"));
            	message.setJMSReplyTo(q);
            }
            
        	if(message.propertyExists(MESSAGE_HEADER.VOCUS_REPLY_TO.toString())) {
        		Topic q = session.createTopic(message.getStringProperty(MESSAGE_HEADER.VOCUS_REPLY_TO.toString()));
				message.setJMSReplyTo(q);
        	}
            //Send the response to the Destination specified by the JMSReplyTo field of the received message,
            //this is presumably a temporary queue created by the client
            this.replyProducer.send(message.getJMSReplyTo(), responseMsg);
        } catch (JMSException e) {
            //Handle the exception appropriately
        }
    }

    public static void main(String[] args) {
        new ActiveMQTest();
    }

}

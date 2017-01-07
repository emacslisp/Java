package SpringMain.SpringMain;

public class HelloWorld {
	private String message;
	
	private int id;
	
	public HelloWorld()
	{
		
	}
	
	public HelloWorld(String message)
	{
		this.message = message;
	}

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

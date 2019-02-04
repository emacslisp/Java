package com.dw.mq;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ApacheCamelTest {
	public static void main(String[] args) {
		try {
			CamelContext context = new DefaultCamelContext();
			boolean loop = true;
			context.addRoutes(new RouteBuilder() {
				public void configure() {
					// from("file:d:/temp/inbox?noop=true").to("file:d:/temp/outbox");
					from("file:///Users/di.wu/test?fileName=1.json").to("file:///tmp?fileName=1.json");
					System.out.println("copy file successfully!!!");
				}
			});
			context.start();
			
			while (loop) {
				Thread.sleep(25000);
			}
			context.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

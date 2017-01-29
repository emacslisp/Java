package com.dw.designpattern.command;

//https://www.tutorialspoint.com/design_pattern/command_pattern.htm
//@example: Java Design Pattern - Command Pattern
public class CommandPattern {
	   public static void main(String[] args) {
		      Stock abcStock = new Stock();

		      BuyStock buyStockOrder = new BuyStock(abcStock);
		      SellStock sellStockOrder = new SellStock(abcStock);

		      Broker broker = new Broker();
		      broker.takeOrder(buyStockOrder);
		      broker.takeOrder(sellStockOrder);

		      broker.placeOrders();
		   }
}

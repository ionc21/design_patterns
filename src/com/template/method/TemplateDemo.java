package com.template.method;

public class TemplateDemo {

	public static void main(final String[] args) {
		System.out.println("Web Order:");

		OrderTemplate webOrder = new WebOrder();
		webOrder.processOrder();

		System.out.println("\nStore Order:");

		OrderTemplate storeOrder = new StoreOrder();
		storeOrder.processOrder();
	}
}

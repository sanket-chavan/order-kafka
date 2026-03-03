package com.webapp.orderKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.orderKafka.model.Order;
import com.webapp.orderKafka.producer.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderProducer orderProducer;
	
	@GetMapping
	public String getOrderController() {
		return "Ping from orderController!! ";
	}
	
	@PostMapping
	public String sendOrder(@RequestBody Order order) throws InterruptedException {
		orderProducer.sendOrder(order);
		
		//bulk orders
		 for (int i = 1; i <= 2; i++) {
		        Order order1 = new Order(i+"", "Product-" + i, 1000 * i);
		        Thread.sleep(100); //adding slightly delay
		        orderProducer.sendOrder(order1);
		    }
		
		return "Order sent successfully!";
	}
	
}

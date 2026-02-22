package com.webapp.orderKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.webapp.orderKafka.model.Order;

@Component
public class OrderConsumer {

	@KafkaListener(topics = "orders-topic", groupId="order-group")
	public void consume(Order order) {
		System.out.println("Received Order: " + order);
	}
}

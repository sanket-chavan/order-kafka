package com.webapp.orderKafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.webapp.orderKafka.model.Order;

@Component
public class OrderConsumer {


	
	
	
	@KafkaListener(topics = "orders-topic", groupId = "order-group")
	public void consume(Order order, ConsumerRecord<String, Order> record) {
		System.out.println("Consumer 1 | Partition: " 
		        + record.partition() + " -> " + order);
	}
	
	@KafkaListener(topics = "orders-topic", groupId="order-group")
	public void consume2(Order order, ConsumerRecord<String, Order> record) {
		System.out.println("Consumer 2 | Partition: " 
		        + record.partition() + " -> " + order);
	}
	
	
//	@KafkaListener(topics = "orders-topic", groupId="order-group")
//	public void consume1(Order order) {
//		System.out.println("Consumer 2 ->" + order);
//	}
	
}

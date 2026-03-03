package com.webapp.orderKafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.webapp.orderKafka.model.Order;

@Component
public class OrderConsumer {


	private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
	
	
	@KafkaListener(topics = "orders-topic", groupId = "order-group")
	public void consume(Order order, ConsumerRecord<String, Order> record) {
		
//		System.out.println("Consumer 1 | Partition: " 
//		        + record.partition() + " -> " + order);
		logger.info("group=order-group partition={} offset={} orderId={}",
		        record.partition(),
		        record.offset(),
		        order.getOrderId());
	}
	
	@KafkaListener(topics = "orders-topic", groupId="order-group")
	public void consume2(Order order, ConsumerRecord<String, Order> record) {
//		System.out.println("Consumer 2 | Partition: " 
//		        + record.partition() + " -> " + order);
		logger.info("group=order-group partition={} offset={} orderId={}",
		        record.partition(),
		        record.offset(),
		        order.getOrderId());
	}
	
	
//	@KafkaListener(topics = "orders-topic", groupId="order-group")
//	public void consume1(Order order) {
//		System.out.println("Consumer 2 ->" + order);
//	}
	
}

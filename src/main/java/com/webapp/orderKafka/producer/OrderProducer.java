package com.webapp.orderKafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.webapp.orderKafka.model.Order;

@Service
public class OrderProducer {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	public  void sendOrder(Order order) {
//		kafkaTemplate.send("orders-topic", order);
		kafkaTemplate.send("orders-topic", order.getOrderId(), order);
	}
}

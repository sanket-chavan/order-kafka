package com.webapp.orderKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.webapp.orderKafka.model.Order;

@Component
public class AnalyticsConsumer {

	@KafkaListener(topics = "orders-topic", groupId = "analytics-group")
	public void analyze(Order order) {
		System.out.println("Analytics Service -> " + order);
	}
}

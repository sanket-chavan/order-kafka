package com.webapp.orderKafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.webapp.orderKafka.model.Order;

@Component
public class AnalyticsConsumer {
	
	public static final Logger logger = LoggerFactory.getLogger(AnalyticsConsumer.class);

	@KafkaListener(topics = "orders-topic", groupId = "analytics-group")
	public void analyze(Order order, ConsumerRecord<String, Order> record) {
		//System.out.println("Analytics Service -> " + order)
		
		logger.info("group=order-group partition={} offset={} orderId={}",
		        record.partition(),
		        record.offset(),
		        order.getOrderId());
	}
}

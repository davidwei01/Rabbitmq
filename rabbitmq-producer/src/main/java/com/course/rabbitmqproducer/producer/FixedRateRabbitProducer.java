package com.course.rabbitmqproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateRabbitProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private Logger logger = LoggerFactory.getLogger(FixedRateRabbitProducer.class);
	
	int i = 0;
	
	@Scheduled(fixedRate = 500)
	public void sendMessage() {
		
		i++;
	//	logger.info("producing " + i);
		rabbitTemplate.convertAndSend("course.fixedrate", "fixed rate is " + i);
	}

}

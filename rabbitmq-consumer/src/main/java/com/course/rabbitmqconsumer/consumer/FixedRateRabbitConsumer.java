package com.course.rabbitmqconsumer.consumer;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateRabbitConsumer {
	
	private Logger log = LoggerFactory.getLogger(FixedRateRabbitConsumer.class);
	
	@RabbitListener(queues = "course.fixedrate", concurrency = "3")
	private void listen(String message) {
		log.info("Consuming {}", message + "  " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

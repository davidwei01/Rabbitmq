package com.course.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class AccountingConsumer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private static final Logger logger = LoggerFactory.getLogger(AccountingConsumer.class);
	
	@RabbitListener(queues = "q.hr.marketing")
	public void listerner(String message ) {
		Employee emp;
		try {
			emp = objectMapper.readValue(message, Employee.class);
			logger.info("On Marketing, employee: {}", emp);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

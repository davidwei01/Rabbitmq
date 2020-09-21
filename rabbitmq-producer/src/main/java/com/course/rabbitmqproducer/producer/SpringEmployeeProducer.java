package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class SpringEmployeeProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	private ObjectMapper om = new ObjectMapper();
	
	public void sendMessage(Employee emp) throws JsonProcessingException {
		var json = om.writeValueAsString(emp);
		rabbitTemplate.convertAndSend("x.spring2.work", "", json);
		
	}

}

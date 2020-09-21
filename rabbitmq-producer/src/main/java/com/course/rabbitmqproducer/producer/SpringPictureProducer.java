package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class SpringPictureProducer {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper om = new ObjectMapper();
	
	public void sendMessage(Picture p) throws JsonProcessingException {
		var json = om.writeValueAsString(p);
		rabbitTemplate.convertAndSend("x.spring.work", p.getType(), json);
	}

}

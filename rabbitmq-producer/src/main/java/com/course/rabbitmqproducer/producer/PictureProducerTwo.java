package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class PictureProducerTwo {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ObjectMapper om = new ObjectMapper();
	
	public void sendMessage(Picture p) throws JsonProcessingException {
		StringBuilder sb = new StringBuilder();
		sb.append(p.getSource());
		sb.append(".");
		sb.append(p.getSize() > 5000? "large" : "small");
		sb.append(".");
		sb.append(p.getType());
		
		String routingKey = sb.toString();
		
		String json = om.writeValueAsString(p);
		rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
	}
}

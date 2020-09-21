package com.course.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class SpringPictureConsumer {
	private Logger log = LoggerFactory.getLogger(SpringPictureConsumer.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RabbitListener(queues = "q.spring.image.work")
	public void listenImage(String message) throws JsonParseException, JsonMappingException, IOException {
		var p = mapper.readValue(message, Picture.class);
		log.info(" Consuming image {}", p.getName());
		if (p.getSize() > 9000) {
			throw new IllegalArgumentException("Image picture " + p.getName() + "'s size is too large.");
		}
		log.info(" Successfully processed image {}", p.getName());
	}
	
	@RabbitListener(queues = "q.spring.vector.work")
	public void listenVector(String message) throws JsonParseException, JsonMappingException, IOException {
		var p = mapper.readValue(message, Picture.class);
		log.info(" Consuming vector {}", p.getName());
		log.info(" Successfully processed vector {}", p.getName());
	}

}

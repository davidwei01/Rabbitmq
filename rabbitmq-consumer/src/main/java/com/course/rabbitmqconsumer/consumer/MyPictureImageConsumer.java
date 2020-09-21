package com.course.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

//@Service
public class MyPictureImageConsumer {

	private ObjectMapper om = new ObjectMapper();
	private Logger log = LoggerFactory.getLogger(MyPictureImageConsumer.class);
	
	@RabbitListener(queues = "q.mypicture.image")
//	public void listen(String message) throws JsonParseException, JsonMappingException, IOException {
	public void listen(Message message, Channel channel) throws JsonParseException, JsonMappingException, IOException {
		Picture p = om.readValue(message.getBody(), Picture.class);
		if (p.getSize() > 9000) {
//			throw new AmqpRejectAndDontRequeueException("Picture size is too large:" + p);
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
		}
		log.info("on image, {}", p);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
	}
}

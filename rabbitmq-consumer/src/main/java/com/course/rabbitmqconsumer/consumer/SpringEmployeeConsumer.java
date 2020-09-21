package com.course.rabbitmqconsumer.consumer;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class SpringEmployeeConsumer {
	private Logger log = LoggerFactory.getLogger(SpringEmployeeConsumer.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RabbitListener(queues = "q.spring2.accounting.work")
	public void listenAccounting(String message) throws JsonParseException, JsonMappingException, IOException {
		Employee emp = mapper.readValue(message, Employee.class);
		if (StringUtils.isEmpty(emp.getEmployeeName())) {
			log.error(" on accounting, name is null: " + emp.getEmployeeName());
			throw new IllegalArgumentException(" on accounting, name is null: " + emp.getEmployeeName());
		}
		log.info(" on Accounting, consume {}", emp);
	}
	
	@RabbitListener(queues = "q.spring2.marketing.work")
	public void listenMarketing(String message) throws JsonParseException, JsonMappingException, IOException {
		Employee emp = mapper.readValue(message, Employee.class);
		log.info(" on Marketing, consume {}", emp);
	}
	
	

}

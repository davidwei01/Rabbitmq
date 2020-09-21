package com.course.rabbitmqproducer.utility;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class RabbitmqScheduler {
	private Logger log = LoggerFactory.getLogger(RabbitmqScheduler.class);
	
	@Autowired
	RabbitmqProxyService proxyService;
	
	@Scheduled(fixedDelay = 90000)
	public void sweepDirtyQueues( ) {
		try {
			var dirtyQueues = proxyService.getAllQueues().stream().filter(q -> q.isDirty()).collect(Collectors.toList());
			dirtyQueues.forEach(q -> log.info("Queue {} has {} unprocessed messages", q.getName(), q.getMessages()));
		} catch (Exception e) {
			log.error("Couldn't sweep dirty queues: {}", e.getMessage());
		}
	}

}

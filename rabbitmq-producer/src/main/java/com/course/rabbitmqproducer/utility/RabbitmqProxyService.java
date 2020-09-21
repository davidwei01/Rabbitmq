package com.course.rabbitmqproducer.utility;

import java.time.Duration;
import java.util.Base64;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//@Service
public class RabbitmqProxyService {
	
	public List<RabbitmqQueue> getAllQueues() {
		var webClient = WebClient.create("http://localhost:15672/api/queues");
		return webClient.get().header("Authorization", createBasicAuthHeader()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<RabbitmqQueue>>(){ })
						.block(Duration.ofSeconds(10));
	}

	private String createBasicAuthHeader() {
		var auth = "guest:guest";
		return "Basic "+ Base64.getEncoder().encodeToString(auth.getBytes());
	}
}

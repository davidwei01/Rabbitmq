package com.course.rabbitmqproducer;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.course.rabbitmqproducer.producer.FixedRateRabbitProducer;
import com.course.rabbitmqproducer.producer.HelloRabbitProducer;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import com.course.rabbitmqproducer.producer.PictureProducer;
import com.course.rabbitmqproducer.producer.MyPictureProducer;
import com.course.rabbitmqproducer.producer.PictureProducerTwo;
import com.course.rabbitmqproducer.producer.RetryEmployeeProducer;
import com.course.rabbitmqproducer.producer.RetryPictureProducer;
import com.course.rabbitmqproducer.producer.SpringEmployeeProducer;
import com.course.rabbitmqproducer.producer.SpringPictureProducer;

@SpringBootApplication
//@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {
	
//	@Autowired
//	HelloRabbitProducer helloRabbitProducer;
	
//	@Autowired
//	FixedRateRabbitProducer fixedRateRabbitProducer;
	
//	@Autowired
//	EmployeeJsonProducer employeeJsonProducer;
	
//	@Autowired
//	HumanResourceProducer humanResourceJsonProducer;
	
//	@Autowired
//	PictureProducer pictureProducer;
	
//	@Autowired
//	PictureProducerTwo pictureProducerTwo;
	
//	@Autowired
//	MyPictureProducer myPictureProducer; 
	
//	@Autowired
//	RetryPictureProducer retryPictureProducer;
	
//	@Autowired
//	RetryEmployeeProducer employeeProducer;
	
//	@Autowired
//	SpringPictureProducer pictureProducer;
	
	@Autowired
	SpringEmployeeProducer employeeProducer;
	
//	private static final List<String> SOURCES = List.of("web", "mobile");
//	private static final List<String> TYPES = List.of("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		helloRabbitProducer.sendHello("Dave Wei" + Math.random());
		for (int i=0; i < 2; i++) {
//			var employee = new Employee("id" + i, "name" + i, LocalDate.now());
			var employee = new Employee("id" + i, null, LocalDate.now());
			//employeeJsonProducer.sendMessage(employee);
//			humanResourceJsonProducer.sendMessage(employee);
			employeeProducer.sendMessage(employee);
		}

//		for (int i=0; i<1; i++) {
//			var p = new Picture();
//			p.setName("Picture"+i);
////			p.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
//			p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
//			p.setSource(SOURCES.get(i % SOURCES.size()));
//			p.setType(TYPES.get(i % TYPES.size()));
//			//pictureProducer.sendMessage(p);
////			pictureProducerTwo.sendMessage(p);
////			myPictureProducer.sendMessage(p);
//			pictureProducer.sendMessage(p);
//		}
//		for (int i=0; i<10; i++) {
//			var employee = new Employee("id" + i, null, LocalDate.now());
//			employeeProducer.sendMessage(employee);
//		}
		
	}

}

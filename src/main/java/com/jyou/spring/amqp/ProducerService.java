package com.jyou.spring.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
	@Autowired 
	private AmqpTemplate amqpTemplate;
	
	public void sendMsg(){
		amqpTemplate.convertAndSend("messages", "Hello World");
		logger.info("Sent: Hello World");
	}

}

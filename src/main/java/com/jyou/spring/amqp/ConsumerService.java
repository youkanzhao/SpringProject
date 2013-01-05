package com.jyou.spring.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	@Autowired 
	private AmqpTemplate amqpTemplate;
	
	
	
	public void reverveMsg(){
		logger.info("Received: " + amqpTemplate.receiveAndConvert("messages"));
	}

}

package com.jyou.spring.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyJob {
	private static final Logger logger = LoggerFactory.getLogger(MyJob.class);
	@Autowired private ApplicationContext context;
	@Scheduled(fixedDelay = 100000)
	public void work() {
		if (logger.isDebugEnabled()) {
			logger.debug("work() - start"); //$NON-NLS-1$  
		}
		logger.info("Spring Quartz");
		if (logger.isDebugEnabled()) {
			logger.debug("work() - end"); //$NON-NLS-1$  
		}
	}
}

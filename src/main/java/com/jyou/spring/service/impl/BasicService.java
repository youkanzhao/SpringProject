package com.jyou.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jyou.spring.dao.MessageDao;
import com.jyou.spring.service.IBasicService;

@Service("baseService")
public class BasicService implements IBasicService {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicService.class);
	
	@Autowired
	private MessageDao messageDao;
	
	public String getMessage() {
		// TODO Auto-generated method stub
		return messageDao.getMessage("55");
	}

	public String getMessage(String msg) {
		// TODO Auto-generated method stub
		return "message with param";
	}

}

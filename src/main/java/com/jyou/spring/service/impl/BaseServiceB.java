package com.jyou.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jyou.spring.service.IBasicService;

@Scope("session")
@Service("baseServiceB")
public class BaseServiceB implements IBasicService {

	private static final Logger logger = LoggerFactory.getLogger(BaseServiceB.class);

	public String getMessage() {
		// TODO Auto-generated method stub
		return "from BaseServiceB";
	}

	public String getMessage(String msg) {
		// TODO Auto-generated method stub
		return "from BaseServiceB : " + msg;
	}

}

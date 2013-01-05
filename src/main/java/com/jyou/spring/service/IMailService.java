package com.jyou.spring.service;

import com.jyou.spring.exception.SPException;

public interface IMailService {
	public void sendTextMail(String from, String to, String subject, String content) throws SPException;
}

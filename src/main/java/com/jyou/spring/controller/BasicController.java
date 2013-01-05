package com.jyou.spring.controller;

import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


public class BasicController {
	@Autowired 
	private HttpServletRequest request;
	
	@Autowired 
	private ApplicationContext context;
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public Object getBean(String name){
		return this.context.getBean(name);
	}

	public JSONObject getParamData(){
		String data = this.request.getParameter("data");
		if(data == null){
			data = "{}";
		}
		return JSONObject.fromObject(data);
	}
}

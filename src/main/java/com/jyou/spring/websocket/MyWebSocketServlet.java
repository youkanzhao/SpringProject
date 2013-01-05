package com.jyou.spring.websocket;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

public class MyWebSocketServlet extends WebSocketServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		System.out.println("##########");  
        return new MyMessageInbound();
	}

	protected StreamInbound createWebSocketInbound(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("##########");  
        return new MyMessageInbound();
	}

}

package com.jyou.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyou.spring.amqp.ConsumerService;
import com.jyou.spring.amqp.ProducerService;
import com.jyou.spring.exception.SPException;
import com.jyou.spring.gemfire.HelloWorld;
import com.jyou.spring.model.User;
import com.jyou.spring.service.IBasicService;
import com.jyou.spring.service.IUserService;
import com.jyou.spring.service.impl.MailService;

/**
 * Handles requests for the application home page.
 */
@Scope("prototype") /*singleton \ prototype \ session \ request \ global session */
@Controller
public class HomeController extends BasicController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("baseServiceB")
	private IBasicService service;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private HelloWorld hw;
	
	@Autowired
	private ProducerService  producerService;
	
	@Autowired
	private ConsumerService  consumerService;
	
	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		JSONObject jo = this.getParamData();
		logger.info(jo.toString());
		String serviceMsg = service.getMessage();
		serviceMsg = service.getMessage("sssss");
		logger.info(serviceMsg);
		List<User> users = userService.getAllUsers();
//		sendMail();
		serviceMsg= getDbInfo();
//		serviceMsg = service.hashCode() + "";
		testAMQP();
		hw.greetWorld(1, 2);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("serviceMsg", serviceMsg);
		model.addAttribute("users", users);
		return "home";
	}
	
	public void testAMQP(){
		producerService.sendMsg();
		consumerService.reverveMsg();
	}
	
	public String getDbInfo(){
		String systemInfo = java.lang.System.getenv("VCAP_SERVICES");
		logger.info(systemInfo);
		return systemInfo;
	}
	
	public void sendMail(){
		try{
			mailService.sendTextMail("springproject2012@gmail.com", "youkanzhao@gmail.com", "spring-subject", "spring-content");
		}
		catch(SPException e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/insert.html", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject doInsertData(Locale locale, Model model){
		JSONObject result = new JSONObject();
		List<User> users = new ArrayList<User>();
		for(int i = 1000; i < 2000; i++){
			User user = new User();
			user.setUname("name_" + i);
			user.setUpwd("pwd_" + i);
			users.add(user);
		}
		userService.addUsers(users);
		result.put("code", "0");
		return result;
	}
	
	@RequestMapping(value = "/ajax.html", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject doAjax(Locale locale, Model model) {
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		logger.info("Welcome home! the client locale is "+ locale.toString());
		JSONObject jo = this.getParamData();
		logger.info(jo.toString());
		modelMap.put("key", "json");
		modelMap.put("value", "json");
		Object[] objs = new Object[] { "javacrazyer", "2012-11-16"};
		String message = this.getContext().getMessage("youkanzhao", objs, locale);
		logger.info(message);
		return jo;
	}
	
}

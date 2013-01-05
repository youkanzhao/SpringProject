package com.jyou.init;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

public class InitCloudFoundry {
	
	private static String getDbInf(){
		String result= "";
		Resource res = new ClassPathResource("mysqlInfo.txt");
		EncodedResource encRes = new EncodedResource(res, "UTF-8");  
		try {
			result = FileCopyUtils.copyToString(encRes.getReader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void setDataSourceOptions(Element el){
		
		String systemInfo = getDbInf();
		
		JSONObject systemJson = JSONObject.fromObject(systemInfo);
		
		JSONObject mysqlParam = systemJson.getJSONArray("mysql-5.1").getJSONObject(0).getJSONObject("credentials");
		String url = "jdbc:mysql://" + mysqlParam.getString("host") + ":" + mysqlParam.getInt("port")
				+ "/" + mysqlParam.getString("name");
		
		String user = mysqlParam.getString("user");

		String password = mysqlParam.getString("password");
		
//		List<Element> eles = el.elements();
//		for(Element temp : eles){
//			String name = temp.attributeValue("name");
//			if("url".equals(name)){
//				temp.addAttribute("value", url);
//			}
//			else if("username".equals(name)){
//				temp.addAttribute("value", user);
//			}
//			else if("password".equals(name)){
//				temp.addAttribute("value", password);
//			}
//		}
		
	}
	
	public static void  init(){
//		String filePath = System.getProperty("user.dir") + "\\src\\main\\webapp\\springConfig\\hibernate.xml";
//		Resource res = new FileSystemResource(filePath);
//		try {
//			String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile()));
//			Document doc = (Document) DocumentHelper.parseText(fileStr).clone();
//			List<Element> eles = doc.getRootElement().elements();
//			for(Element el : eles){
//				String id = el.attribute("id").getValue();
//				if("dataSource".equals(id)){
//					setDataSourceOptions(el);
//				}
//			}
//			
//			FileCopyUtils.copy(doc.asXML(), new FileWriter(filePath));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
	}

}

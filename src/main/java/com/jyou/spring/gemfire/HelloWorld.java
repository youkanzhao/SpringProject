/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jyou.spring.gemfire;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.gemstone.gemfire.cache.Region;

/**
 * Main bean for interacting with the cache from the console. 
 * 
 * @author Costin Leau
 */
@Component
public class HelloWorld {

	private static final Log log = LogFactory.getLog(HelloWorld.class);

	// inject the region
	@Resource(name = "myRegion")
	private Region<String, String> region;

//	@TestAnnotation(name="test2")
	public int greetWorld(int a, int b) {
		try {
			String temp = region.get("_G_C");
			System.out.println("from greetWorld");
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i< 20; i++){
				sb.append("from gemfire");
			}
			region.put("_G_C", sb.toString());
		} catch (Exception ex) {
			throw new IllegalStateException("Cannot greet world", ex);
		}
		log.info("greetWorld");
		return a + b;
	}
}
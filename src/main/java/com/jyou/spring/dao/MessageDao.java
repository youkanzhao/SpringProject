package com.jyou.spring.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao {

	/*
	 * @CacheEvict支持如下几个参数：
	 * 
	 * value：缓存位置名称，不能为空，同上
	 * 
	 * key：缓存的key，默认为空，同上
	 * 
	 * condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
	 * 
	 * allEntries：true表示清除value中的全部缓存，默认为false 
	 * 
	 * value的名字必须跟配置文件里保持一致
	 */
	@CacheEvict(value = "data", condition = "#num == '56'")
	@Cacheable(value = "data", condition = "#num == '55'")
	public String getMessage(String num) {
		// TODO Auto-generated method stub
		return "from service MessageDao" + num;
	}

}

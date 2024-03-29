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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

/**
 * Listener that logs entry operations to the configured logger.
 * 
 * @author Costin Leau
 */
public class CacheLogger extends CacheListenerAdapter<Object, Object> {

	private static final Log log = LogFactory.getLog(CacheLogger.class);

	@Override
	public void afterCreate(EntryEvent<Object, Object> event) {
		log.info("Added " + messageLog(event) + " to the cache");
	}

	@Override
	public void afterDestroy(EntryEvent<Object, Object> event) {
		log.info("Removed " + messageLog(event) + " from the cache");
	}

	@Override
	public void afterUpdate(EntryEvent<Object, Object> event) {
		log.info("Updated " + messageLog(event) + " in the cache");
	}

	private String messageLog(EntryEvent<Object, Object> event) {
		Object key = event.getKey();
		Object value = event.getNewValue();

		if (event.getOperation().isUpdate()) {
			return "[" + key + "] from [" + event.getOldValue() + "] to [" + event.getNewValue() + "]";
		}
		return "[" + key + "=" + value + "]";
	}
}

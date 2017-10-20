/*
 * Copyright 2015-2017 the original author or authors.
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

package org.springframework.cloud.stream.app.twitterstream.source;

/**
 * Twitter stream types.
 *
 * @author Ilayaperumal Gopinathan
 * @author Gary Russell
 * @author Nicolas Byl
 */
public enum TwitterStreamType {

	//TODO: Support more stream types such as `filter`, `search` that TwitterTemplate implementation supports.
	SAMPLE("sample.json"),

	FIREHOSE("firehose.json"),

	FILTER("filter.json");

	private final String path;

	private TwitterStreamType(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}

}

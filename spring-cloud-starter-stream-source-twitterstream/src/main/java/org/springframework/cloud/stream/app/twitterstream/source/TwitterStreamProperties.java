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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for TwitterStream source.
 *
 * @author Ilayaperumal Gopinathan
 * @author Gary Russell
 * @author Nicolas Byl
 */
@ConfigurationProperties("twitter.stream")
public class TwitterStreamProperties {

	/**
	 * Twitter stream type (such as sample, firehose). Default is sample.
	 */
	private TwitterStreamType streamType = TwitterStreamType.SAMPLE;

	/**
	 * The language of the tweet text.
	 */
	private String language;

	/**
	 * A comma separated list of user IDs, indicating the users to return statuses for in the stream.
	 */
	private String follow;

	/**
	 * Keywords to track.
	 */
	private String track;

	/**
	 * A set of bounding boxes to track.
	 */
	private String locations;

	public TwitterStreamType getStreamType() {
		return this.streamType;
	}

	public void setStreamType(TwitterStreamType streamType) {
		this.streamType = streamType;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFollow() {
		return this.follow;
	}

	public void setFollow(String follow) {
		this.follow = follow;
	}

	public String getTrack() {
		return this.track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getLocations() {
		return this.locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

}

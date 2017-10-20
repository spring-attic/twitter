/*
 * Copyright 2017 the original author or authors.
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

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * @author Nicolas Byl
 */
public class TwitterStreamMessageProducerTests {

	@Test
	public void sampleBuildsCorrectUri() throws URISyntaxException {
		TwitterStreamProperties properties = new TwitterStreamProperties();
		properties.setStreamType(TwitterStreamType.SAMPLE);
		properties.setLanguage("english");

		TwitterStreamMessageProducer producer = new TwitterStreamMessageProducer(new TwitterTemplate(""), properties);
		assertEquals(new URI("https://stream.twitter.com/1.1/statuses/sample.json?language=english"), producer.buildUri());
	}

	@Test
	public void languageIsIgnoredOnFilter() throws URISyntaxException {
		TwitterStreamProperties properties = new TwitterStreamProperties();
		properties.setStreamType(TwitterStreamType.FILTER);
		properties.setLanguage("english");

		TwitterStreamMessageProducer producer = new TwitterStreamMessageProducer(new TwitterTemplate(""), properties);
		assertEquals(new URI("https://stream.twitter.com/1.1/statuses/filter.json"), producer.buildUri());
	}

	@Test
	public void filterStreamTypeSetsParameters() throws URISyntaxException {
		TwitterStreamProperties properties = new TwitterStreamProperties();
		properties.setStreamType(TwitterStreamType.FILTER);
		properties.setFollow("@springframework");
		properties.setTrack("#springone");
		properties.setLocations("dummy");

		TwitterStreamMessageProducer producer = new TwitterStreamMessageProducer(new TwitterTemplate(""), properties);
		assertEquals(new URI("https://stream.twitter.com/1.1/statuses/filter.json?follow=%40springframework&track=%23springone&locations=dummy"),
				producer.buildUri());
	}

}

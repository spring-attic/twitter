package org.springframework.cloud.stream.app.twitterstream.source;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class TwitterStreamMessageProducerTest {

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
        assertEquals(new URI("https://stream.twitter.com/1.1/statuses/filter.json?follow=%40springframework&track=%23springone&locations=dummy"), producer.buildUri());
    }
}
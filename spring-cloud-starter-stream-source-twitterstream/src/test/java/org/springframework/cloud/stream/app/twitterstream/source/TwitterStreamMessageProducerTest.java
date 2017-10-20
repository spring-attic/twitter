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
}
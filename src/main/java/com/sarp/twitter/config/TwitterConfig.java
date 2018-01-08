package com.sarp.twitter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {

    @Value("${spring.social.twitter.app-id}")
    private String appId;

    @Value("${spring.social.twitter.app-secret}")
    private String appSecret;

    @Value("${spring.social.twitter.access-token}")
    private String accessToken;

    @Value("${spring.social.twitter.access-token-secret}")
    private String accessTokenSecret;

    @Bean
    public TwitterTemplate twitterTemplate() {
        return new TwitterTemplate(appId, appSecret, accessToken, accessTokenSecret);
    }

}

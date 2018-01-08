package com.sarp.twitter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.social.twitter.api.Tweet;

import java.util.List;

@Data
@AllArgsConstructor
public final class Tweets {

    //we can modify response fields
    private List<Tweet> tweetList;

}

package com.sarp.twitter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TwitterServiceImpl implements TwitterService {

    private final TwitterTemplate twitterTemplate;

    @Override
    public List<Tweet> searchTweets(final String username, final String searchText) {

        List<Tweet> tweets = this.twitterTemplate.timelineOperations().getUserTimeline(username)
                .parallelStream()
                .filter(tweet -> tweet.getText().contains(searchText))
                .collect(Collectors.toList());

        return tweets;
    }

    @Override
    public List<TwitterProfile> searchFriends(final String username, final String searchText) {

        List<TwitterProfile> profiles = this.twitterTemplate.friendOperations().getFollowers(username)
                .parallelStream()
                .filter(twitterProfile -> twitterProfile.getScreenName().contains(searchText))
                .collect(Collectors.toList());

        return profiles;
    }
}

package com.sarp.twitter.controller;

import com.sarp.twitter.response.Profiles;
import com.sarp.twitter.response.Tweets;
import com.sarp.twitter.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("twitter/")
@RequiredArgsConstructor
public class TwitterController {

    private final TwitterService twitterService;

    @GetMapping(value = "tweets/{username}/{searchText}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Tweets> searchTweetsOfUser(@PathVariable final String username, @PathVariable final String searchText) {

        Assert.hasText(username, "username must be not null or empty");
        Assert.hasText(searchText, "search text must be not null or empty");

        List<Tweet> tweetList = this.twitterService.searchTweets(username, searchText);
        return new ResponseEntity<>(new Tweets(tweetList), HttpStatus.OK);
    }

    @GetMapping(value = "friends/{username}/{searchText}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Profiles> searchFriendsOfUser(@PathVariable final String username, @PathVariable final String searchText) {

        Assert.hasText(username, "username must not be null or empty");
        Assert.hasText(searchText, "searchText must not be null or empty");

        List<TwitterProfile> twitterProfileList = this.twitterService.searchFriends(username, searchText);
        return new ResponseEntity<>(new Profiles(twitterProfileList), HttpStatus.OK);
    }


}

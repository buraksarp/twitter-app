package com.sarp.twitter.service;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;

import java.util.List;

public interface TwitterService {

   List<Tweet> searchTweets(String username, String searchText);

   List<TwitterProfile> searchFriends(String username, String searchText);

}

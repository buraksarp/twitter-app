package com.sarp.twitter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.social.twitter.api.TwitterProfile;

import java.util.List;

@Data
@AllArgsConstructor
public final class Profiles {

    //we can modify response fields
    private List<TwitterProfile> profileList;

}

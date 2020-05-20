package edu.practice.authservice.service.usr;



import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.model.domain.UsrProfile;
import edu.practice.authservice.model.dto.UsrProfileDTO;

import java.util.List;

public interface UsrProfileService {
    List<UsrProfile> getAllProfiles();

    UsrProfile getProfileById(String id);

    UsrProfile saveProfile(UsrProfileDTO usrProfile);

    void deleteProfileById(String profileId);

    UsrProfile editProfileById(String profileId, UsrProfile profile);
}

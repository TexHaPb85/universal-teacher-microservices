package edu.practice.authservice.service.usr;


import edu.practice.authservice.exceptions.ProfileNotFoundException;
import edu.practice.authservice.model.domain.User;
import edu.practice.authservice.model.domain.UsrProfile;
import edu.practice.authservice.model.dto.UsrProfileDTO;
import edu.practice.authservice.repo.UserRepository;
import edu.practice.authservice.repo.UsrProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsrProfileServiceImpl implements UsrProfileService {

    private final UsrProfileRepository usrProfileRepository;
    private final UserRepository userRepository;


    @Autowired
    public UsrProfileServiceImpl(UsrProfileRepository usrProfileRepository, UserRepository userRepository) {
        this.usrProfileRepository = usrProfileRepository;
        this.userRepository = userRepository;

    }

    @Override
    public List<UsrProfile> getAllProfiles() {
        return usrProfileRepository.findAll();
    }

    @Override
    public UsrProfile getProfileById(String id) {
        return usrProfileRepository
                .findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    @Override
    public UsrProfile saveProfile(UsrProfileDTO profileDTO) {
        UsrProfile profile = new UsrProfile(profileDTO);
        User user = userRepository
                .findById(profileDTO.getUserId())
                .orElse(null);
        profile.setUser(user);

        return usrProfileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(String profileId) {
        usrProfileRepository.deleteById(profileId);
    }

    @Override
    public UsrProfile editProfileById(String profileId, UsrProfile newProfileValues) {//??????????
        UsrProfile editedProfile = usrProfileRepository
                .findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));
        BeanUtils.copyProperties(newProfileValues,editedProfile,"id");

        return usrProfileRepository.save(editedProfile);
    }
}

package com.estsoft.for1person.service;

import com.estsoft.for1person.dto.AddUserRequest;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder encoder; // 암호화

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public User save(AddUserRequest dto){
        return userRepository.save(
                User.builder()
                        .userId(dto.getUserId())
                        .password(encoder.encode(dto.getPassword()))
                        .nickname(dto.getNickname())
                        .author(dto.getAuthor())
                        .status(dto.getStatus())
                        .build()
        );
    }

    public void deleteById(String userId){
        userRepository.deleteById(userId);
    }

    public boolean existsByUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    public boolean existsByNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    public void updateProfile(String userId, String changePassword){
        Optional<User> userOptional = userRepository.findByUserId(userId);
        User user = userOptional.get();
        user.setPassword(changePassword);
        userRepository.save(user);
    }

    public void updateAuthor(String userId, Integer changeAuthor){
        Optional<User> userOptional = userRepository.findByUserId(userId);
        User user = userOptional.get();
        user.setAuthor(changeAuthor);
        userRepository.save(user);
    }

    public long countAllUsers(){
        return userRepository.countAllUsers();
    }
}

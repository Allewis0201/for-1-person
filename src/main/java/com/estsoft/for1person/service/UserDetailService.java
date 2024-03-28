package com.estsoft.for1person.service;

import com.estsoft.for1person.domain.User;
import com.estsoft.for1person.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + userId));
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), user.getAuthorities());
    }

    public boolean login(String userId, String password){
        UserDetails userDetails = loadUserByUsername(userId);
        return encoder.matches(password, userDetails.getPassword());
    }
}

package com.example.Springbootblog.service;

import com.example.Springbootblog.domain.User;
import com.example.Springbootblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}

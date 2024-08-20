package com.study.SpringSecurity.service;

import com.study.SpringSecurity.domain.Entity.User;
import com.study.SpringSecurity.dto.request.ReqSignUpDto;
import com.study.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    public User signup(ReqSignUpDto reqSignUpDto) {
        return userRepository.save(reqSignUpDto.toEntity());
    }
}

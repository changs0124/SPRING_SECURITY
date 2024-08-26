package com.study.SpringSecurity.service;

import com.study.SpringSecurity.aspect.annotation.TimeAop;
import com.study.SpringSecurity.domain.entity.Role;
import com.study.SpringSecurity.domain.entity.User;
import com.study.SpringSecurity.dto.request.ReqSignUpDto;
import com.study.SpringSecurity.repository.RoleRepository;
import com.study.SpringSecurity.repository.UserRepository;
import com.study.SpringSecurity.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @TimeAop
    @Transactional(rollbackFor = Exception.class)
    public User signup(ReqSignUpDto reqSignUpDto) {
        User user = reqSignUpDto.toEntity(passwordEncoder);
        Role role = roleRepository.findByName("ROLE_USER").orElseGet(
                () -> roleRepository.save(Role.builder().name("ROLE_USER").build())
        );
        user.setRoles(Set.of(role));
        user = userRepository.save(user);

//        UserRole userRole = UserRole.builder()
//                .user(user)
//                .role(role)
//                .build();
//        userRole = userRoleRepository.save(userRole);
        return user;
    }

    public boolean isDuplicatedUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
}

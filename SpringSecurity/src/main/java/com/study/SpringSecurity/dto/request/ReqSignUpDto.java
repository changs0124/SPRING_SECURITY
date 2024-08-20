package com.study.SpringSecurity.dto.request;

import com.study.SpringSecurity.domain.Entity.User;
import lombok.Data;

@Data
public class ReqSignUpDto {
    private String username;
    private String password;
    private String checkPassword;
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .name(name)
                .build();
    }
}

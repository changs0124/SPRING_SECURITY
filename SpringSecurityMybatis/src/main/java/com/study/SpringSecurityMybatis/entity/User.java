package com.study.SpringSecurityMybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Set<UserRoles> userRoles;
}

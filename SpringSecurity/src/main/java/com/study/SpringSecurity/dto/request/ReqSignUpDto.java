package com.study.SpringSecurity.dto.request;

import com.study.SpringSecurity.domain.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class ReqSignUpDto {

    @Pattern(regexp = "^[a-z0-9]{6,}$", message = "사용자이름은 6자이상의 영소문, 숫자 조합이여야합니다.")
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~!@#$%^&*?])[a-zA-Z\\d~!@#$%^&*?]{8,16}$",
            message = "비밀번호는 8자이상 16자이하의 영대소문, 숫자, 특수문자(~!@#$%^&*?)를 포함하여야합니다.")
    private String password;
    private String checkPassword;

    @Pattern(regexp = "^[가-힣]+$", message = "이름은 한글이어야합니다.")
    @Email(message = "")
    private String name;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .build();
    }
}

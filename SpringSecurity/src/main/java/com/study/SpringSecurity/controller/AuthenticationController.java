package com.study.SpringSecurity.controller;

import com.study.SpringSecurity.aspect.annotation.ParamsAop;
import com.study.SpringSecurity.aspect.annotation.ValidAop;
import com.study.SpringSecurity.dto.request.ReqSignInDto;
import com.study.SpringSecurity.dto.request.ReqSignUpDto;
import com.study.SpringSecurity.service.SigninService;
import com.study.SpringSecurity.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private SignupService signupService;

    @Autowired
    private SigninService signinService;

    @ValidAop
    @ParamsAop
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody ReqSignUpDto reqSignUpDto, BindingResult bindingResult) {
        log.info("{}", reqSignUpDto);
        return ResponseEntity.created(null).body(signupService.signup(reqSignUpDto));
    };

    @ValidAop
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody ReqSignInDto reqSignInDto, BindingResult bindingResult) {
        log.info("{}", reqSignInDto);
        return ResponseEntity.ok().body(signinService.signin(reqSignInDto));
    };


}

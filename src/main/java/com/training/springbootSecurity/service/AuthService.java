package com.training.springbootSecurity.service;

import com.training.springbootSecurity.model.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
package com.genius.webmvc.service.impl;

import com.genius.webmvc.exception.CustomException;
import com.genius.webmvc.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(String name, String passsword) throws CustomException {
        if (name.equalsIgnoreCase("admin") &&
            passsword.equalsIgnoreCase("admin")) {
            return true;
        } else {
            throw new CustomException("Invalid Name & Invalid Password!");
        }
    }
}

package com.genius.webmvc.service;

import com.genius.webmvc.exception.CustomException;

public interface LoginService {
    public boolean login(String name, String passsword) throws CustomException;
}

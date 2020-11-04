package com.thoughtworks.capacity.gtb.mvc.Exception;

public class loginException extends Error{
    @Override
    public String getMessage() {
        return "用户名或密码错误";
    }
}

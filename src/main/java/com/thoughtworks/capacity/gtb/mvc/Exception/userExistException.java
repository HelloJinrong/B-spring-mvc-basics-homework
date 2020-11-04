package com.thoughtworks.capacity.gtb.mvc.Exception;

import lombok.Data;

@Data
public class userExistException extends Error{
    @Override
    public String getMessage() {
        return "用户已存在";
    }
}

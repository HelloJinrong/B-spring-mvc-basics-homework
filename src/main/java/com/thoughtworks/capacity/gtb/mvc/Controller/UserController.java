package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    @Autowired
    Userservice userservice;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated User user)
    {
        userservice.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam @Pattern(regexp = "^//w{3,10}$",message = "用户名不合法")String username,
                                      @RequestParam @Size(min=5,max=12,message = "密码不合法") String password) throws Exception {
        User user = userservice.login(username,password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}

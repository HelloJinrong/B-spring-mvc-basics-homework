package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Dto.User;
import com.thoughtworks.capacity.gtb.mvc.Exception.userExistException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Userservice {
    List<User> users= new ArrayList<>();
    public void register(User user){
        if(users.stream().anyMatch(e->e.getUsername().equals(user.getUsername())))
        {
            throw new userExistException();
        }else users.add(user);
    }
    public User login(String username,String password) throws Exception{
        List<User> userList = users.stream().filter(
                user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password)
        ).collect(Collectors.toList());
        if(userList.size()==1)
        {
            return userList.get(0);
        }else
            throw new LoginException();
    }
}

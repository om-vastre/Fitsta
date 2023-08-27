package com.fitsta.fitsta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitsta.fitsta.Entity.User;
import com.fitsta.fitsta.Repository.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository;

    public String[] login(String username, String pass) {
        List<User> user = this.userRepository.findByUsernameAndPassword(username, pass);
        String[] data = new String[2];
        if (user != null && !user.isEmpty()) {
            data[0] = "" + user.get(0).getId();
            data[1] = "Success";
            return data;
        } else {
            data[0] = "";
            data[1] = "failed";
            return data;
        }
    }

}

package com.fitsta.fitsta.Component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitsta.fitsta.Entity.Logins;
import com.fitsta.fitsta.Repository.LoginsRepository;

@Component
public class Validation {
    
    @Autowired
    private LoginsRepository loginsRepository;

    public boolean isValidProduct(String token){
        if (token != null) {
            List<Logins> foundLogin = this.loginsRepository.findAllByToken(token);
            if(foundLogin.isEmpty()){
                System.out.println("\n Authentication Error : Empty login!");
                return false;
            }
            else{
                if(foundLogin.get(0).getType().equals("user") || foundLogin.get(0).getType().equals("admin")){
                    return true;
                }
                else{
                    System.out.println("\n Authentication Error : Invalid user login!");
                    return false;
                }
            }
        } else {
            System.out.println("\nAuthentication Error : Token not received!");
            return false;
        }
    }

    public boolean isValidTrainer(String token){
        if (token != null) {
            List<Logins> foundLogin = this.loginsRepository.findAllByToken(token);
            if(foundLogin.isEmpty()){
                System.out.println("\n Authentication Error : Empty login!");
                return false;
            }
            else{
                if(foundLogin.get(0).getType().equals("user") || foundLogin.get(0).getType().equals("admin") || foundLogin.get(0).getType().equals("trainer")){
                    return true;
                }
                else{
                    System.out.println("\n Authentication Error : Invalid user login!");
                    return false;
                }
            }
        } else {
            System.out.println("\nAuthentication Error : Token not received!");
            return false;
        }
    }

    public boolean isValidUser(String token){
        if (token != null) {
            List<Logins> foundLogin = this.loginsRepository.findAllByToken(token);
            if(foundLogin.isEmpty()){
                System.out.println("\n Authentication Error : Empty login!");
                return false;
            }
            else{
                if(foundLogin.get(0).getType().equals("user") || foundLogin.get(0).getType().equals("admin") || foundLogin.get(0).getType().equals("trainer")){
                    return true;
                }
                else{
                    System.out.println("\n Authentication Error : Invalid user login!");
                    return false;
                }
            }
        } else {
            System.out.println("\nAuthentication Error : Token not received!");
            return false;
        }
    }


}

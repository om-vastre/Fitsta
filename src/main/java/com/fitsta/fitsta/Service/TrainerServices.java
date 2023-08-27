package com.fitsta.fitsta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitsta.fitsta.Entity.Trainer;
import com.fitsta.fitsta.Repository.TrainerRepository;

@Service
public class TrainerServices {

    @Autowired
    private TrainerRepository trainerRepository;


    public String[] login(String username, String pass){
        List<Trainer> Trainer = this.trainerRepository.findByUsernameAndPassword(username, pass);
        String[] data = new String[2];
        if (Trainer != null && !Trainer.isEmpty()){
            
            data[0]=""+Trainer.get(0).getId();
            data[1]="Success";
            return data;
        }else{
            data[0]="";
            data[1]="failed";
            return data;
        }
    }

}

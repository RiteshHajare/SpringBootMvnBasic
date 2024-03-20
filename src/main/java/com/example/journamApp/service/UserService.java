package com.example.journamApp.service;

import com.example.journamApp.entity.JournalEntry;
import com.example.journamApp.entity.UserEntry;
import com.example.journamApp.repository.JournalEntryRepository;
import com.example.journamApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveNewEntry(UserEntry user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }catch(Exception e){
            log.error("Exception",e);
        }
    }
    public void saveEntry(UserEntry user){
        try {

            userRepository.save(user);
        }catch(Exception e){
            log.error("Exception",e);
        }
    }

    public List<UserEntry> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public boolean deleteById(ObjectId id){
        userRepository.deleteById(id);
        return true;
    }

    public UserEntry findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}

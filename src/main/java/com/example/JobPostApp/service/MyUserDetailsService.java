package com.example.JobPostApp.service;

import com.example.JobPostApp.model.User;
import com.example.JobPostApp.model.UserPrinciple;
import com.example.JobPostApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("404 User Not Found");
        }

        return new UserPrinciple(user);
    }
}

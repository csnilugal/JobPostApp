package com.example.JobPostApp.repo;

import com.example.JobPostApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}

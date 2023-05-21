package com.dhk.accmg.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dhk.accmg.domain.User;

@Repository
public interface UserRepository {
    
    public int write(User user);
    
    public User readIdAndPassword(User user);
}

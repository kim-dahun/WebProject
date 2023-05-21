package com.dhk.accmg.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dhk.accmg.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = {"file:src/main/webapp/WEB-INF/application-context.xml"}
        )

public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testwrite() {
        
        Assertions.assertNotNull(userRepository);
        log.info("userRepository = {}",userRepository);
        
        User user = User.builder().id("admin").password("admin").name("관리자").birthday(LocalDateTime.of(1994, 6, 2, 0, 0)).email("admin@sangsang.com").phone("010-1234-5678").companycode(80000).build();
        log.info(user.toString());
        
        int result = userRepository.write(user);
        Assertions.assertEquals(1, result);
        log.info("insert count = {}",result);
        
    }
    
    
}

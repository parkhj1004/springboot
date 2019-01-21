package com.jpa.demo;

import com.jpa.demo.config.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private com.mapper.testMapper testMapper;

    @Test
    @Transactional
    @Rollback(false)
    public void createUser() {

        User user = new User();
        user.setName("test");
        user.setEmail("test@gmail.com");
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void testCreateUser() {
        testMapper.insertUser();
    }
}


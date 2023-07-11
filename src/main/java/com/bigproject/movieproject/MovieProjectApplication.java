package com.bigproject.movieproject;

import com.bigproject.movieproject.Security.Module.User;
import com.bigproject.movieproject.Security.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class MovieProjectApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(MovieProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()){
            User user = User.builder()
                    .email("truonggiang@gmail.com")
                    .username("truonggiang")
                    .password(passwordEncoder.encode("giang123"))
                    .dob(LocalDate.of(2002,05,04))
                    .role("ADMIN")
                    .build();
            userRepository.save(user);

        }
    }
}

package com.bigproject.movieproject.Security.Repository;

import com.bigproject.movieproject.Security.Module.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}

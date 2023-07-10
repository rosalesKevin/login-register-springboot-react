package com.bootcamp.fullstackbackend.repositories;


import com.bootcamp.fullstackbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String encodedPassword);
}

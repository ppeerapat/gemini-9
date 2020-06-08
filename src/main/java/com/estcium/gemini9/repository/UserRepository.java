package com.estcium.gemini9.repository;

import com.estcium.gemini9.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    @Override
    Optional<User> findById(Integer integer);
}

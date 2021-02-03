package com.example.demo.ugc.repository;

import com.example.demo.ugc.data.User;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Component;

@Component("userRepository")
public interface UserRepository extends ReactiveNeo4jRepository<User, Long> {
}

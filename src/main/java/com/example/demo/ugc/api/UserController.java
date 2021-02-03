package com.example.demo.ugc.api;

import com.example.demo.ugc.data.User;
import com.example.demo.ugc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {
  @Autowired
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  Flux<User> getUsers() {
    return userRepository.findAll();
  }

  @GetMapping(path = "{id}")
  Mono<User> getUser(@PathVariable("id") Long id) {
    System.out.println("PRINT " + id);
    return userRepository.findById(id);
  }

  @DeleteMapping(path = "{id}")
  Mono<Void> deleteUser(@PathVariable("id") Long id) {
    return userRepository.deleteById(id);
  }

  @PutMapping
  Mono<User> upsert(@RequestBody User user) {
    return userRepository.save(user);
  }
}

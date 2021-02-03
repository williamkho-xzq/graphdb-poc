package com.example.demo.ugc.repository;

import com.example.demo.ugc.data.Review;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Component;

@Component("reviewRepository")
public interface ReviewRepository extends ReactiveNeo4jRepository<Review, Long> {
}

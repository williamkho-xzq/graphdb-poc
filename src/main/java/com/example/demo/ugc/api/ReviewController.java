package com.example.demo.ugc.api;

import com.example.demo.ugc.data.Review;
import com.example.demo.ugc.repository.ReviewRepository;
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
@RequestMapping("review")
public class ReviewController {
  @Autowired
  private final ReviewRepository reviewRepository;

  public ReviewController(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @GetMapping
  Flux<Review> getReviews() {
    return reviewRepository.findAll();
  }

  @GetMapping(path = "{id}")
  Mono<Review> getReview(@PathVariable("id") Long id) {
    System.out.println("PRINT " + id);
    return reviewRepository.findById(id);
  }

  @DeleteMapping(path = "{id}")
  Mono<Void> deleteReview(@PathVariable("id") Long id) {
    return reviewRepository.deleteById(id);
  }

  @PutMapping
  Mono<Review> upsert(@RequestBody Review Review) {
    return reviewRepository.save(Review);
  }
}

package com.example.demo.ugc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Node("User")
public class User {
  @Id
  private final long profileId;
  private final String name;

  //@Relationship(type = "LIKE")
  //private List<Review> likedReviews;

  public User(
      @JsonProperty("profileId") long profileId,
      @JsonProperty("name") String name) {
    this.profileId = profileId;
    this.name = name;
  }
}

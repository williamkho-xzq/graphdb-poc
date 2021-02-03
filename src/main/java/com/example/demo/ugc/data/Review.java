package com.example.demo.ugc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Getter
@Node("Review")
public class Review {
  @Id
  private final long id;
  private final String language;
  private final String text;

  @Relationship(type = "WRITE", direction = Relationship.Direction.INCOMING)
  private User reviewer;

  @Relationship(type = "FOR", direction = Relationship.Direction.OUTGOING)
  private Inventory inventory;

  @Relationship(type = "HAS")
  private List<Photo> photoList;

  public Review(
      @JsonProperty("id") long id,
      @JsonProperty("language") String language,
      @JsonProperty("text") String text) {
    this.id = id;
    this.language = language;
    this.text = text;
  }
}

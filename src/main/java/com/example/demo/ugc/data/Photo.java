package com.example.demo.ugc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Node("Photo")
public class Photo {
  @Id
  private final long id;
  private final String url;

  public Photo(
      @JsonProperty("id") long id,
      @JsonProperty("url") String url) {
    this.id = id;
    this.url = url;
  }
}

package com.example.demo.ugc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Node("Inventory")
public class Inventory {
  @Id
  private final long inventoryId;
  private final String name;
  private final String location;

  public Inventory(
      @JsonProperty("inventoryId") long inventoryId,
      @JsonProperty("name") String name,
      @JsonProperty("location") String location) {
    this.inventoryId = inventoryId;
    this.name = name;
    this.location = location;
  }
}

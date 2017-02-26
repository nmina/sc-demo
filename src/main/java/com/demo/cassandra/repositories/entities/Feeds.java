package com.demo.cassandra.repositories.entities;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by nikko on 2/25/17.
 */
@Table("feeds")
public class Feeds implements Serializable {

    @PrimaryKey
    private UUID id;

    private String title;

    @Column("some_value")
    private String someValue;


    public Feeds() {}

    public Feeds(String title, String someValue) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.someValue = someValue;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSomeValue() {
        return someValue;
    }
}

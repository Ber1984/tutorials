package com.erick.company.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String author;
    private Instant publishedOn;
    private Instant updatedOn;

    public Post(String title, String slug, String content, String author, Instant publishedOn) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.author = author;
        this.publishedOn = publishedOn;
    }
}

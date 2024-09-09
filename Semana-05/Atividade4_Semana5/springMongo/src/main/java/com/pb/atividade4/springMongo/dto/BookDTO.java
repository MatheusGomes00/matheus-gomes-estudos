package com.pb.atividade4.springMongo.dto;

import com.pb.atividade4.springMongo.domain.Book;

import java.io.Serial;
import java.io.Serializable;

public class BookDTO implements Serializable {

    private String id;
    private String title;
    private String author;
    private String pubYear;
    private String type;

    public BookDTO() {
    }

    public BookDTO(Book obj) {
        id = obj.getId();
        title = obj.getTitle();
        author = obj.getAuthor();
        pubYear = obj.getPubYear();
        type = obj.getType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

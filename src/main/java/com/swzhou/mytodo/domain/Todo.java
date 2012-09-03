package com.swzhou.mytodo.domain;

import javax.persistence.*;

@Entity
@Table(name="todos")
public class Todo {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="content")
    private String content;

    public Todo() {
        this.content = "";
    }

    public Todo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

package com.swzhou.mytodo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="todos")
public class Todo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="content")
    @NotNull(message = "content is required")
    @Size(min = 5, message = "At least 5 characters")
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

    public void setContent(String content) {
        this.content = content;
    }
}

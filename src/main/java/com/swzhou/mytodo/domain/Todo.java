package com.swzhou.mytodo.domain;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/25/12
 * Time: 7:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Todo {
    private String content;

    public Todo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

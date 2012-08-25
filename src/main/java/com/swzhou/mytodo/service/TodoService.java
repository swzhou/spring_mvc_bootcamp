package com.swzhou.mytodo.service;

import com.swzhou.mytodo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public List<Todo> getAll() {
        ArrayList<Todo> todos = new ArrayList<Todo>();
        todos.add(new Todo("buy a new book"));
        todos.add(new Todo("clear up the room"));
        return todos;
    }
}

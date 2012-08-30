package com.swzhou.mytodo.service;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/29/12
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryTodoRepository extends TodoRepository {

    private List<Todo> todos = new ArrayList<Todo>();

    public InMemoryTodoRepository(Todo... todos) {
        super(null);
        for(Todo todo: todos) {
            this.todos.add(todo);
        }
    }

    @Override
    public List<Todo> getAll() {
        return this.todos;
    }
}

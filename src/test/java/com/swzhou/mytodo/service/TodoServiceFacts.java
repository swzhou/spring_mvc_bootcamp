package com.swzhou.mytodo.service;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/29/12
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class TodoServiceFacts {

    @Test
    public void should_get_all_todos() {
        Todo expectedTodo = new Todo("todo1");
        TodoService todoService = givenTodoService(expectedTodo);

        List<Todo> todos = todoService.getAll();

        assertThat(todos.size(), is(1));
        assertThat(todos.get(0), is(expectedTodo));
    }

    private TodoService givenTodoService(Todo... todo) {
        TodoRepository todoRepository = new InMemoryTodoRepository(todo);
        return new TodoService(todoRepository);
    }
}

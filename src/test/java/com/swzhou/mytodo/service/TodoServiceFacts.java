package com.swzhou.mytodo.service;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

    @Test
    public void should_create_new_todo() {
        Todo todo = new Todo("todo");
        TodoRepository repository = mock(TodoRepository.class);
        TodoService service = new TodoService(repository);

        service.create(todo);

        verify(repository).create(todo);
    }

    private TodoService givenTodoService(Todo... todo) {
        TodoRepository todoRepository = new InMemoryTodoRepository(todo);
        return new TodoService(todoRepository);
    }

    private class InMemoryTodoRepository extends TodoRepository {

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
}

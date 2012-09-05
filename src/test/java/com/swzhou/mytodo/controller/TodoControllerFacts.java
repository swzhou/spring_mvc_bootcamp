package com.swzhou.mytodo.controller;

import com.swzhou.mytodo.controller.TodoController;
import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.service.TodoService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TodoControllerFacts {

    @Test
    public void should_use_todo_index_view_list_all_todos() {
        TodoController controller = givenTodoController();

        ModelAndView modelAndView = controller.index();

        assertThat(modelAndView.getViewName(), is("todo/index"));
    }

    @Test
    public void should_fetch_all_todos_when_list_all_todos() {
        Todo expectTodo = new Todo("todo1");
        TodoController controller = givenTodoController(expectTodo);

        ModelAndView modelAndView = controller.index();

        assertThat(modelAndView.getModel().containsKey("todos"), is(true));
        List<Todo> todos = (List<Todo>) modelAndView.getModel().get("todos");
        assertThat(todos.size(), is(1));
        assertThat(todos.get(0), equalTo(expectTodo));
    }

    @Test
    public void should_use_todo_new_view_to_show_new_todo_page() {
        TodoController todoController = givenTodoController();

        ModelAndView modelAndView = todoController.create();

        assertThat(modelAndView.getViewName(), is("todo/new"));
    }

    @Test
    public void should_use_new_todo_model_when_show_new_todo_page() {
        TodoController todoController = givenTodoController();

        ModelAndView modelAndView = todoController.create();
        Todo newTodo = (Todo) modelAndView.getModel().get("todo");

        assertThat(newTodo.getContent(), is(""));
    }

    @Test
    public void should_create_new_todo() {
        Todo todo = new Todo("todo");
        TodoService service = mock(TodoService.class);
        TodoController controller = new TodoController(service);

        controller.create(todo);

        verify(service).create(todo);
    }

    @Test
    public void should_redirect_to_index_after_creating_new_todo() {
        Todo todo = new Todo("todo");
        TodoController controller = givenTodoController();

        ModelAndView modelAndView = controller.create(todo);

        assertThat(modelAndView.getViewName(), is("todo/index"));
    }

    private TodoController givenTodoController(Todo... todos) {
        TodoService service = givenTodoService(todos);
        TodoController controller = new TodoController(service);
        return controller;
    }

    private TodoService givenTodoService(Todo... todos) {
        List<Todo> result = new ArrayList<Todo>();
        for(Todo todo: todos) {
            result.add(todo);
        }
        TodoService service = mock(TodoService.class);
        when(service.getAll()).thenReturn(result);
        return service;
    }
}

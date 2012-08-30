package com.swzhou.mytodo.service;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository repository;

    public TodoService() {

    }

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Todo> getAll() {
        return repository.getAll();
    }
}

package com.swzhou.mytodo.persistence;

import com.swzhou.mytodo.domain.Todo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public TodoRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Todo> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from com.swzhou.mytodo.domain.Todo").list();
    }
}

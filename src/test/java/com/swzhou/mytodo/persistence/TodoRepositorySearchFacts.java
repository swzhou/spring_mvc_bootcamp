package com.swzhou.mytodo.persistence;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.common.RepositoryContextConfiguration;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TodoRepositorySearchFacts.Config.class)
@TransactionConfiguration(transactionManager = "todoRepoTransactionManager", defaultRollback = false)
@Transactional
public class TodoRepositorySearchFacts {

    @Autowired
    private SessionFactory todoRepoSessionFactory;

    @Test
    public void should_get_all_todos() {
        TodoRepository todoRepository = new TodoRepository(todoRepoSessionFactory);

        List<Todo> todos = todoRepository.getAll();

        assertThat(todos.size(), is(1));
        assertThat(todos.get(0).getContent(), is("todo1"));
    }

    @Configuration
    static class Config extends RepositoryContextConfiguration {
        Config() {
            super("classpath:todos.sql");
        }
    }
}

package com.swzhou.mytodo.repository;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/29/12
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TodoRepositoryFacts {

//    @Test
//    public void should_get_all_todos() {
//        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:todos.sql").build();
//        SessionFactory sessionFactory = new LocalSessionFactoryBuilder(database)
//                .addAnnotatedClass(Todo.class).buildSessionFactory();
//        final TodoRepository todoRepository = new TodoRepository(sessionFactory);
//
//        List<Todo> todos = todoRepository.getAll();
//        assertThat(todos.size(), is(1));
//        assertThat(todos.get(0).getContent(), is("todo1"));
//    }
}

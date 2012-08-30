package com.swzhou.mytodo.repository;

import com.swzhou.mytodo.domain.Todo;
import com.swzhou.mytodo.persistence.TodoRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
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
@ContextConfiguration(classes = TodoRepositoryFacts.Config.class)
@TransactionConfiguration(transactionManager="todoRepoTransactionManager", defaultRollback=false)
@Transactional
public class TodoRepositoryFacts {

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
    static class Config {
        @Bean
        public DataSource todoRepoDataSource() {
            return new EmbeddedDatabaseBuilder()
                    .addScript("classpath:schema.sql")
                    .addScript("classpath:todos.sql").build();
        }

        @Bean
        public SessionFactory todoRepoSessionFactory() {
            return new LocalSessionFactoryBuilder(todoRepoDataSource())
                    .addAnnotatedClass(Todo.class).buildSessionFactory();
        }

        @Bean
        public HibernateTransactionManager todoRepoTransactionManager() {
            return new HibernateTransactionManager(todoRepoSessionFactory());
        }
    }
}

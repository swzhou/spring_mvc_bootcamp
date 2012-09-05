package com.swzhou.mytodo.persistence.common;

import com.swzhou.mytodo.domain.Todo;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/5/12
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class RepositoryContextConfiguration {

    private EmbeddedDatabaseBuilder builder;

    protected RepositoryContextConfiguration(String... sqls) {
        builder = new EmbeddedDatabaseBuilder()
                .setName(this.getClass().getName())
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql");
        for(String sql: sqls) {
            builder = builder.addScript(sql);
        }
    }

    @Bean
    public DataSource todoRepoDataSource() {
        return builder.build();
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

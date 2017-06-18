package ru.belitavitex;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dzianis on 13.06.2017.
 */
@Configuration
@ComponentScan(basePackages = {"ru.belitavitex"})
public class Config {

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}

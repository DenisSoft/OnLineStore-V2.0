package ru.belitavitex.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Dzianis on 13.06.2017.
 */


@Configuration
@ContextConfiguration(classes = Config.class)
@Import(value = {Config.class, AspectConfig.class})
@ComponentScan(basePackages = {"ru.belitavitex"})
public class ServiceConfig {
}

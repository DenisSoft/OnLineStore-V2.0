package ru.belitavitex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Dzianis on 22.06.2017.
 */
@Configuration
@ComponentScan(basePackages = "ru.belitavitex")
@EnableWebMvc
@Import(value = {InternationalizationConfig.class, ThymeleafConfig.class, MvcConfig.class})
public class WebConfig {
}

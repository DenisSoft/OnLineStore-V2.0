package ru.belitavitex.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.belitavitex.aspect.ServiceLogger;

/**
 * Created by Dzianis on 13.06.2017.
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
}

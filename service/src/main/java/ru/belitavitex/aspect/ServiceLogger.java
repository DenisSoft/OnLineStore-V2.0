package ru.belitavitex.aspect;


import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Dzianis on 15.07.2017.
 */

@Aspect
@Component
@Log4j
public class ServiceLogger {

    @Pointcut("within(ru.belitavitex.service..*)")
    public void serviceMethods(){}

    @Before(value = "serviceMethods()", argNames = "joinPoint")
    public void methodInvoke(JoinPoint joinPoint) {
        log.info("Method Name :"
                + joinPoint.getSignature().toShortString()
                + " Arguments: "
                + Arrays.asList(joinPoint.getArgs()));
    }
}

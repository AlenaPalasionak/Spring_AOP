package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAspect {
    @Before("execution(public void getBook())")//  в скопках pointcut - выражение обозн. когда должен быть вып. сквозной код
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");

    }
}

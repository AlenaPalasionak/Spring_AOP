package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAndSecurityAspect {//Security - значит проверим, может ли человек брать книгу в библиотеке

    @Pointcut("execution(* get*())")//шаблон для поинтката, чтобы иметь ссылку
    private void allGetMethods() {
    }

    @Before("allGetMethods()")//используем ссылку на метод
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить печатное издание");
    }

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение печатного издания");
    }

}

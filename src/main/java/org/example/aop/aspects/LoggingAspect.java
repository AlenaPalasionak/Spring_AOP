package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
@Order(1)
public class LoggingAspect {//Security - значит проверим, может ли человек брать книгу в библиотеке

    @Before("org.example.aop.aspects.MyPointCuts.allGetMethods()")//чтобы использовать поинткат, который создан не в моем
    //аспект-классе, мы должны прописать полный путь к поинткату
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetBookAdvice: логирование попытки получить печатное издание");
    }

}

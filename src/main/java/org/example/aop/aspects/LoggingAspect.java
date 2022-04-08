package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAspect {
    @Before("execution(public void getBook(org.example.aop.Book))")// .. - любой метод с любыми количеством параметров от нуля.
    // Чтобы указать класс, нужно указать его полное имя с пакетами
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить печатное издание");
    }

//    @Before("execution(public void return*())")//
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice: попытка вернуть печатное издание");
//    }
}

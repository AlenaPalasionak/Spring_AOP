package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAspect {
    @Before("execution(public void get*())")//  в скопках pointcut - выражение обозн. когда должен быть вып. сквозной код
    //* - звездочка обозн., что в этот шаблон подойдет любой метод начинающийся на get
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить печатное издание");
    }

    @Before("execution(public void return*())")//  в скопках pointcut - выражение обозн. когда должен быть вып. сквозной код
    //* - звездочка обозн., что в этот шаблон подойдет любой метод начинающийся на get
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка вернуть печатное издание");
    }
}

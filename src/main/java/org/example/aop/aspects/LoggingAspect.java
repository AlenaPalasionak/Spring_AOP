package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAspect {
    @Before("execution(* get*())")//

    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить печатное издание");
    }

}

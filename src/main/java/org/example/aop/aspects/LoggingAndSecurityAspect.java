package org.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* org.example.aop.UniLibrary.*(..))")      // любые методы
    private void allMethodsFromUniLibrary() {
    }

    @Pointcut("execution(public void org.example.aop.UniLibrary.returnMagazine())")     // один определенный метод
    private void returnMagazineFromUniLibrary() {
    }

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")      // из всех методов исключаем один
    private void allMethodsExceptReturnMagazineFromUniLibrary() {
    }
    @Before("allMethodsExceptReturnMagazineFromUniLibrary())")      // используем исключающий поинткат, чтобы только перед одним методом не печатался advice
    public void beforeAllMethodsExceptReturnMagazineAdvice() {
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #10");
    }
}
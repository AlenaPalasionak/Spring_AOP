package org.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {    //ProceedingJoinPoint - связь с таргет
        // методом, с помощью proceedingJoinPoint мы будем вручную запускать таргет метод изэтого аспектного метода. Таргет метод возвращает String,
        // вернем Object, т.к. proceedingJoinPoint.proceed() - вернет Object
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку ПЫТАЮТСЯ вернуть книгу");

        Long begin = System.currentTimeMillis();
        Object targetMethodResult = proceedingJoinPoint.proceed();
        targetMethodResult = "Преступление и наказание";//меняем возвращаемое значение таргет метода public String returnBook()
        Long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно ВЕРНУЛИ книгу");
        System.out.println("aroundReturnBookLoggingAdvice: метод выполнил работу за " + (end - begin) + " милисекунд(ы)");

        return targetMethodResult;
    }
}

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

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку ПЫТАЮТСЯ вернуть книгу");

        Object targetMethodResult = null;
        try{
             targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {   //обработка исключения внутри адвайса, метод мэйн не вкурсе исключения. Лучше так не делать
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение" + e);
            targetMethodResult = "Неизвестное название книги";
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно ВЕРНУЛИ книгу");
        return targetMethodResult;
    }
}

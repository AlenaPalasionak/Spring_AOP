package org.example.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aop.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect// класс будет осуществлять сквозную функциональность
@Order(1)
public class LoggingAspect {//Security - значит проверим, может ли человек брать книгу в библиотеке

    @Before("org.example.aop.aspects.MyPointCuts.allAddMethods()")
    public void beforeGetLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);

        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());

        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());

        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for(Object obj : arguments) {
                if(obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название книги - " + myBook.getName()
                            + " автор - " + myBook.getAuthor() + "год выпуска - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String) {
                    System.out.println("Книгу добавил: " + obj);
                }
            }
        }

        System.out.println("beforeGetBookAdvice: логирование попытки получить печатное издание");
        System.out.println("****************************************************************************************");
    }

}

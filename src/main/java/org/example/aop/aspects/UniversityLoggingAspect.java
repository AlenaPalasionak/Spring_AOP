package org.example.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.aop.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class UniversityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение " +
//                "списка студентов ПЕРЕД методом getStudents");
//    }
//
//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")//когда параметров несколько,
//    //нужно указывать их имена. returning = "students" - то, что вернет метод
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {// в параметы мы получим, что вернул
//        // метод getStudents()  и сможем внести изменения в это.
//        Student firstStudent = students.get(0);
//        String name = "Mr " + firstStudent.getNameSurname();
//        firstStudent.setNameSurname(name);
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение " +
//                "списка студентов ПОСЛЕ метода getStudents");
//    }
    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {

        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения" + exception);
    }

}

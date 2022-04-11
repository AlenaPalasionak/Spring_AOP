package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
       // Student student = context.getBean("student", Student.class)
        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> studentList = university.getStudents();
        System.out.println(studentList);

        context.close();

    }
}

package org.example.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> studentList = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Lena Palasionak", 5, 8);
        Student st2 = new Student("Kate P.", 3, 7);
        Student st3 = new Student("Olga N.", 4, 9);

        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
    }
    public List<Student> getStudents(){
        System.out.println("Information from method getStudents");
        System.out.println(studentList);
        return studentList;

    }
}

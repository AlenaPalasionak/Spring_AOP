package org.example.aop;

public class Student {
    private String nameSurname;
    private int course;
    private int avgDegree;

    public Student(String nameSurname, int course, int avgDegree) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avgDegree = avgDegree;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAvgDegree() {
        return avgDegree;
    }

    public void setAvgDegree(int avgDegree) {
        this.avgDegree = avgDegree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course='" + course + '\'' +
                ", avgDegree=" + avgDegree +
                '}';
    }
}

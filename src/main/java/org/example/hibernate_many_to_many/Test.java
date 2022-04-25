package org.example.hibernate_many_to_many;

import org.example.hibernate_many_to_many.entity.Child;
import org.example.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;

public class Test {
    public static void main(String[] args) {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Child.class)
            .addAnnotatedClass(Section.class)
            .buildSessionFactory();

    Session session = null;
    try{
//Добавление детей в секцию
//        session = factory.getCurrentSession();
//
//        Section section1 = new Section("Football");
//        Child child1 = new Child("Tom", 7);
//        Child child2 = new Child("Kate", 10);
//        Child child3 = new Child("Bob", 6);
//
//        section1.addChildToSection(child1);
//        section1.addChildToSection(child2);
//        section1.addChildToSection(child3);
//
//        session.beginTransaction();
//        session.save(section1);
//
//        session.getTransaction().commit();
//
//        System.out.println("Done");
        //********************************************************************************************************
//Добавление секций ребенку
//        session = factory.getCurrentSession();
//
//        Section section1 = new Section("Volleyball");
//        Section section2 = new Section("Chess");
//        Section section3 = new Section("Math");
//
//        Child child1 = new Child("Jim", 9);
//
//        child1.addSectionToChild(section1);
//        child1.addSectionToChild(section2);
//        child1.addSectionToChild(section3);
//
//
//        session.beginTransaction();
//        session.save(child1);
//
//        session.getTransaction().commit();
//
//        System.out.println("Done");
        //*****************************************************************************
//Получение инф. из таблиц БД
        session = factory.getCurrentSession();


        session.beginTransaction();

        Section section = session.get(Section.class, 1);
        System.out.println(section);
        System.out.println(section.getChildList());

        session.getTransaction().commit();

        System.out.println("Done");
    }
    finally {
        factory.close();
        session.close();
        }

}
}

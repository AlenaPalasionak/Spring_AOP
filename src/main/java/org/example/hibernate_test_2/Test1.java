package org.example.hibernate_test_2;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .buildSessionFactory();
try {
    Session session = factory.getCurrentSession();

    Employee employee = new Employee("Alexander", "Ivanov", "IT", 600);
    session.beginTransaction();
    session.save(employee);//занесли в базу
    session.getTransaction().commit();//закрыли транзакцию
}
finally {
    factory.close();
}

    }
}

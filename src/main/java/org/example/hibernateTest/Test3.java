package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee where firstname='Alexander' AND salary>650")
                    .getResultList();//красное не ошибка

            for(Employee e : employeeList) {
                System.out.println(e);
            }

            session.getTransaction().commit();//закрыли транзакцию

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }
}

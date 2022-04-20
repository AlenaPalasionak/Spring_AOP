package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee emp = session.get(Employee.class,3);
//            session.delete(emp);
            session.createQuery("delete Employee where firstname = 'Alexander'").executeUpdate();

            session.getTransaction().commit();//закрыли транзакцию

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }
}

package org.example.hibernateTest;

import org.example.hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Elena", "Petrova", "Sales", 800);
            session.beginTransaction();
            session.save(employee);//занесли в базу
            session.getTransaction().commit();//закрыли транзакцию

            int myId = employee.getId();
            //дальше будем получать объект из базы данных, для этого нужно открыть новую сессию
            session = factory.getCurrentSession();
            session.beginTransaction();//опять открываем транзакцию
            Employee employee1 = session.get(Employee.class, myId);// происходит преобразование строки из базы данных в объект
            session.getTransaction().commit();//закрыли транзакцию
            System.out.println(employee1);
        }
        finally {
            factory.close();
        }

    }
}
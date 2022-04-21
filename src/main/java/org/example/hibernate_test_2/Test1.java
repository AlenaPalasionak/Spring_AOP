package org.example.hibernate_test_2;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
try {
    Session session = factory.getCurrentSession();

    Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);

    Detail detail = new Detail("Moskow", 38472834, "olejka@tut.by");
    employee.setEmpDetail(detail);
    session.beginTransaction();

    session.save(employee);

    session.getTransaction().commit();//закрыли транзакцию
    System.out.println("Done");
}
finally {
    factory.close();
}

    }
}

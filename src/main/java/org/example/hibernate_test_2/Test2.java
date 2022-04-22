package org.example.hibernate_test_2;

import org.example.hibernate_test_2.entity.Detail;
import org.example.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = new Employee("Nikolaj", "Ivanov", "HR", 300);
            Detail detail = new Detail("Polotsk", 98748430, "Nick@tut.by");
//нужно сначала работнику назначить детали, а потом деталям работника, тогда в таблице не будет null
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);

            session.save(detail);

            session.getTransaction().commit();//закрыли транзакцию
            System.out.println("Done");

        } finally {
            session.close();//закрываем сессию тут, если вдруг будет исключение, то избежим connection leak
            factory.close();
        }
    }
}

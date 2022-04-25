package org.example.one_to_many_uni;

import org.example.one_to_many_uni.entity.Department;
import org.example.one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        //чтобы иметь связь с базой данных нужно получить сессию
        SessionFactory factory = new Configuration()//один раз создаем и можно переиспользовать
                .configure("hibernate.cfg.xml")// чтобы сессия прочитала файл конфигурации
                .addAnnotatedClass(Employee.class)//прописываем класс который имеет аннотации для работы с БД
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

           Department department = session.get(Department.class, 4);
            session.delete(department);//удалим депертимент

            session.getTransaction().commit();//закрыли транзакцию
            System.out.println("Done");

        } finally {
            session.close();//закрываем сессию тут, если вдруг будет исключение, то избежим connection leak
            factory.close();

        }

    }
}

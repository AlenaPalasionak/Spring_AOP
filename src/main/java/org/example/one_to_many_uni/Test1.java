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
            Department department = new Department("HR", 500, 1500);
            Employee emp1 = new Employee("Oleg", "Ivanov", 600);
            Employee emp2 = new Employee("Zaur", "Tregulov", 4500);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.beginTransaction();


            session.save(department);

            session.getTransaction().commit();//закрыли транзакцию
            System.out.println("Done");

        } finally {
            session.close();//закрываем сессию тут, если вдруг будет исключение, то избежим connection leak
            factory.close();

        }

    }
}

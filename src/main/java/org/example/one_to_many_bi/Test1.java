package org.example.one_to_many_bi;

import org.example.one_to_many_bi.entity.Department;
import org.example.one_to_many_bi.entity.Employee;
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
//            Department department = new Department("IT", 300, 5000);
//            Employee emp1 = new Employee("Lena", "Palasionak", 500);
//            Employee emp2 = new Employee("Zaur", "Tregulov", 4500);


            session.beginTransaction();
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.save(department);
            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);
            session.getTransaction().commit();//закрыли транзакцию
            System.out.println("Done");

        } finally {
            session.close();//закрываем сессию тут, если вдруг будет исключение, то избежим connection leak
            factory.close();

        }

    }
}

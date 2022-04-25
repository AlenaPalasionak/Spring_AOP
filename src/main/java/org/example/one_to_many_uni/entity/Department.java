package org.example.one_to_many_uni.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //будет иметь отображение в базе данных
@Table(name = "departments")// к какой таблице привязываемся
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String DepartmentName;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @OneToMany(cascade = CascadeType.ALL)// работники будут удаляться каскадно, если удалим департамент
    @JoinColumn(name = "department_id")
    private List<Employee> emps;

    public Department() {
    }

    public Department(String departmentName, int minSalary, int maxSalary) {
        DepartmentName = departmentName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(employee);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}

package kz.iitu.lab5.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    private double fixedSalary;
    private double hourRate;
    private int hoursWorked;
    private float commRate;

    @Enumerated(EnumType.STRING)
    private EmployeeType emplType;

    public Employee() {
    }
    public Employee(Long id, String name, double salary, double fixedSalary, int hoursWorked, EmployeeType emplType) {
        this.id = id;
        this.name=name;
        this.salary=salary;
        this.fixedSalary=fixedSalary;
        this.hoursWorked=hoursWorked;
        this.emplType=emplType;
    }

    public Employee(Long id, String name, double salary,double hourRate, EmployeeType emplType) {
        this.id = id;
        this.name=name;
        this.salary=salary;
        this.hourRate=hourRate;
        this.emplType=emplType;
    }

    public Employee(Long id, String name, double salary, float commRate, EmployeeType emplType) {
        this.id = id;
        this.name=name;
        this.salary=salary;
        this.commRate=commRate;
        this.emplType=emplType;
    }

    public Employee(Long id, String name, double salary, double fixedSalary, float commRate, EmployeeType emplType) {
        this.id = id;
        this.name=name;
        this.salary=salary;
        this.fixedSalary=fixedSalary;
        this.commRate=commRate;
        this.emplType=emplType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public float getCommRate() {
        return commRate;
    }

    public EmployeeType getEmplType() {
        return emplType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setCommRate(float commRate) {
        this.commRate = commRate;
    }

    public void setEmplType(EmployeeType emplType) {
        this.emplType = emplType;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, name='%s', emplType='%s']",
                id, name, emplType);
    }
}

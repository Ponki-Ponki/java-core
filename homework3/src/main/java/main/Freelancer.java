package main;

import java.util.ArrayList;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {
     private final Integer age;
    protected Freelancer(String surName, String name, double salary,Integer age) {
        super(surName, name, salary);
        this.age = age;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    public static Employee getInstance(){
        double newSal = random.nextInt(30000, 250000);
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                (newSal*20.8 * 8)/(30*12),
                random.nextInt(18,60));
    }
    public static ListEmployee<Employee> getEmployees(int count){
        ListEmployee<Employee> employees = new ListEmployee<>() {};
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Возраст: %d;  Среднемесячная заработная плата: %.2f (руб.)",
                surName, name, age, salary);
    }

    public Integer getAge() {
        return age;
    }
}

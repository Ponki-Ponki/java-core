package main;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {
    protected Freelancer(String surName, String name, double salary) {
        super(surName, name, salary);
    }

    @Override
    public double calculateSalary() {
        return (salary*20.8 * 8)/(30*12);
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000));
    }
    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата: %.2f (руб.)",
                surName, name, calculateSalary());
    }
}

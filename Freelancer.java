package root;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee {
    protected Freelancer(String surName, String name, double salary) {
        super(surName, name, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

package main;

import java.util.List;

public class Program {

    public static void main(String[] args) {

/*
        List<Employee> employees = Worker.getEmployees(15);

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        employees.sort(new EmployeeNameComparator());
        System.out.println();

        for (Employee employee: employees) {
            System.out.println(employee);
        }
*/

        ListEmployee<Employee> employees = Freelancer.getEmployees(15);

        employees.sort(new EmployeeSalaryComporator());

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        employees.sort(new EmployeeAgeComporator());

    }

}

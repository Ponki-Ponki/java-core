package main;

import java.util.Comparator;

public class EmployeeAgeComporator implements Comparator<Freelancer> {
    @Override
    public int compare(Employee o1, Employee o2) {

        return Integer.compare(Freelancer(o1.age),Freelancer(o2.age));
    }
}

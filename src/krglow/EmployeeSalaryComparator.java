package krglow;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Float.compare(o1.getSalary(), o2.getSalary());
    }
}

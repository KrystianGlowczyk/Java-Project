package krglow;

import java.util.Comparator;

public class EmployeeLastNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int compareResult = o1.getLastName().compareTo(o2.getLastName());
        if (compareResult == 0) {
            compareResult = o1.getName().compareToIgnoreCase(o2.getName());
        }
        return compareResult;
    }
}

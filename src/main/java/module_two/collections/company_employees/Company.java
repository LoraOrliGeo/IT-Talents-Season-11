package module_two.collections.company_employees;

import java.time.LocalDate;
import java.util.*;

public class Company {
    private String name;
    private Map<String, List<Employee>> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public void addEmployee(String dep, Employee e) {
        if (!this.employees.containsKey(dep)) {
            this.employees.put(dep, new ArrayList<>());
        }

        this.employees.get(dep).add(e);
    }

    public void printCompany() {
        for (Map.Entry<String, List<Employee>> entry : this.employees.entrySet()) {
            System.out.println(entry.getKey());
            for (Employee employee : entry.getValue()) {
                System.out.println(employee);
            }
        }
    }

    public void printEmployees(SortingCriteria criteria) {
        List<Employee> allEmployees = getAllEmployees(this.employees);
        Comparator<Employee> comparator = null;

        switch (criteria) {
            case NAME:
                comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
                break;
            case AGE:
                comparator = (e1, e2) -> e1.getAge() - e2.getAge();
                break;
            case SALARY:
                comparator = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
                break;
        }

        allEmployees.sort(comparator);

        for (Employee employee : allEmployees) {
            System.out.println(employee);
        }
    }

    public List<Employee> getAllEmployees(Map<String, List<Employee>> employees) {
        List<Employee> allEmployees = new ArrayList<>();

        for (List<Employee> depEmp : employees.values()) {
            allEmployees.addAll(depEmp);
        }

        return allEmployees;
    }

    public void removeDuplicateEmployees() {
        for (List<Employee> employees : this.employees.values()) {
            HashSet<Employee> set = new HashSet<>(employees);
            employees.clear();
            employees.addAll(set);
        }
    }


}

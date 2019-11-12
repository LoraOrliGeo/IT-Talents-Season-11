package module_two.collections.company_employees;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private int id;
    private static int employeeId = 1;
    private Map<LocalDate, Double> salaries;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.id = employeeId++;
        this.salaries = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee " +
                "name=" + name +
                ", age=" + age +
                ", salary=" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public void receiveSalary(LocalDate date) {
        salaries.put(date, salary);
    }

    public void printSalaryReport() {
        for (Map.Entry<LocalDate, Double> entry : this.salaries.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

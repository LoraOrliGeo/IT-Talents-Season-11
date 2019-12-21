package module_one.lesson5_arrays;

import java.util.Scanner;

public class Class_Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = new String[10];

        System.out.println("Enter 10 names of workers:");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }

        double[] salaries = new double[10];
        String workerWithMaxSalary = "";
        double maxSalary = Double.MIN_VALUE;
        String workerWithMinSalary = "";
        double minSalary = Double.MAX_VALUE;

        double sumSalaries = 0;

        System.out.println("Enter 10 numbers for workers' salaries");
        for (int i = 0; i < salaries.length; i++) {
            salaries[i] = sc.nextDouble();

            sumSalaries += salaries[i];

            if (salaries[i] > maxSalary) {
                workerWithMaxSalary = names[i];
                maxSalary = salaries[i];
            }

            if (salaries[i] < minSalary) {
                workerWithMinSalary = names[i];
                minSalary = salaries[i];
            }
        }

        System.out.println("Worker with max salary: " + workerWithMaxSalary + " -> " + maxSalary);
        System.out.println("Worker with min salary: " + workerWithMinSalary + " -> " + minSalary);
        System.out.println("Sum of all salaries: " + sumSalaries);
        System.out.println("The average salary is: " + (sumSalaries / 10));
    }
}

package module_two.lesson17_inheritance.Task1;

public class Employee extends Person {
    private static final double WORKING_HOURS_PER_DAY = 8;

    private double daySalary;

    public Employee(String name, int age, boolean isMale, double daySalary) {
        super(name, age, isMale);
        this.setDaySalary(daySalary);
    }

    private void setDaySalary(double daySalary) {
        if (daySalary > 0) {
            this.daySalary = daySalary;
        }
    }

    public double calculateOvertime(double hours) {
        if (this.getAge() < 18 || hours < 0) {
            return 0;
        }

        double salaryPerHour = this.daySalary / WORKING_HOURS_PER_DAY;
        return salaryPerHour * 1.5 * hours;
    }

    public void showEmployeeInfo() {
        super.showPersonInfo();
        System.out.println(String.format("Daily Salary: %.2f", this.daySalary));
    }
}

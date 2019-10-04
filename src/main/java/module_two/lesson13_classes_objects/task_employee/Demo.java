package module_two.lesson13_classes_objects.task_employee;

public class Demo {
    public static void main(String[] args) {

        Employee employee = new Employee("Haralampi");
        employee.setHoursLeft(4);

        Task task = new Task("top secret classified", 7);
        employee.setCurrentTask(task);
        employee.work();

        employee.showReport();
    }
}

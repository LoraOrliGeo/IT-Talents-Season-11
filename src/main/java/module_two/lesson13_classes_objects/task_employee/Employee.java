package module_two.lesson13_classes_objects.task_employee;

public class Employee {
    private static final int WORKING_HOURS = 8;
    private static final String DEFAULT_NAME = "default_name";

    private String name;
    private Task currentTask;
    private int hoursLeft; // how many working hours the employee has until the end of the day

    public Employee(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    public void setCurrentTask(Task task) {
        if (task != null) {
            this.currentTask = task;
        }
    }

    public void setHoursLeft(int hoursLeft) {
        if (hoursLeft >= 0 && hoursLeft <= Employee.WORKING_HOURS) {
            this.hoursLeft = hoursLeft;
        }
    }

    public void work() {
        if (this.currentTask != null) {
            int taskHours = this.currentTask.getWorkingHours();
            int employeeHours = this.hoursLeft;
            if (employeeHours >= taskHours) {
                this.setHoursLeft(employeeHours - taskHours);
                this.currentTask.setWorkingHours(0);
            } else {
                this.currentTask.setWorkingHours(taskHours - employeeHours);
                this.setHoursLeft(0);
            }
            this.showReport();
        } else {
            System.out.println("There is no assigned task!");
        }
    }

    public void showReport() {
        System.out.println(String.format("Worker's name: %s%n" +
                        "Task's name: %s%n" +
                        "Worker's hours left: %d%n" +
                        "Task's hours to be completed: %d",
                this.name,
                this.currentTask != null ? this.currentTask.getName() : "no current task",
                this.hoursLeft,
                this.currentTask != null ? this.currentTask.getWorkingHours() : -1));
    }
}

package module_two.abstraction.task_employee;

public class Employee {
    private static final int WORKING_HOURS = 8;
    private static final String DEFAULT_NAME = "default_name";

    private String name;
    private Task currentTask;
    private int hoursLeft; // how many working hours the employee has until the end of the day
    private static AllWork allWork;

    public Employee(String name) {
        this.setName(name);
    }

    public void startWorkingDay() {
        this.hoursLeft = WORKING_HOURS;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    public Task getCurrentTask() {
        return this.currentTask;
    }

    public void setCurrentTask(Task task) {
        if (task != null) {
            System.out.println(String.format("%s's current task set to %s",
                    this.getName(), task.getName()));
        } else {
            System.out.println(String.format("%s's current task set to null", this.getName()));
        }
        this.currentTask = task;
    }

    public int getHoursLeft() {
        return this.hoursLeft;
    }

    public void setHoursLeft(int hoursLeft) {
        if (hoursLeft >= 0 && hoursLeft <= Employee.WORKING_HOURS) {
            this.hoursLeft = hoursLeft;
        } else {
            System.out.println(String.format("Invalid hours! %s's hours left are not changed!", this.getName()));
        }
    }

    public static AllWork getAllWork() {
        return Employee.allWork;
    }

    public static void setAllWork(AllWork allWork) {
        if (allWork != null) {
            Employee.allWork = allWork;
        } else {
            System.out.println("The list of tasks is not created!");
        }
    }

    public void work() {
        workOnCurrentTask();
        while (this.hoursLeft > 0) {
            setCurrentTask(Employee.allWork.getNextTask());
            if (this.currentTask == null) {
                System.out.println(String.format("There are no more tasks! I have %d hours left, but I'm going home!",
                        this.getHoursLeft()));
                break;
            }
            workOnCurrentTask();
        }
    }

    private void workOnCurrentTask() {
        if (this.currentTask == null) {
            return;
        }

        int taskWorkingHours = this.currentTask.getWorkingHours();
        int employeeHoursLeft = this.getHoursLeft();

        if (taskWorkingHours <= employeeHoursLeft) {
            this.currentTask.setWorkingHours(0);
            this.setHoursLeft(employeeHoursLeft - taskWorkingHours);
            System.out.println(String.format("%s have completed %s task. I have %d more hours",
                    this.getName(), this.getCurrentTask().getName(), this.getHoursLeft()));
            this.currentTask = null;
        } else {
            this.currentTask.setWorkingHours(taskWorkingHours - employeeHoursLeft);
            this.setHoursLeft(0);
            System.out.println(String.format("%s have not completed %s task. I have 0 hours left.",
                    this.getName(), this.getCurrentTask().getName()));
        }
    }
}
package module_two.abstraction.task_employee;

public class Task {
    private static final String DEFAULT_NAME = "default_name";

    private String name;
    private int workingHours; // how many hours left to finish the task

    public Task(String name, int workingHours) {
        this.setName(name);
        this.setWorkingHours(workingHours);
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

    public int getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(int workingHours) {
        if (workingHours >= 0) {
            this.workingHours = workingHours;
        }
    }

    public void print() {
        System.out.println(String.format("Task name: %s, Working hours: %d", this.getName(), this.getWorkingHours()));
    }
}

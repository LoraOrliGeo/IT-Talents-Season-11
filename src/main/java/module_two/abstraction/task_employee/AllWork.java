package module_two.abstraction.task_employee;

public class AllWork {
    public static final int NUMBER_OF_TASKS = 10;

    private Task[] tasks;
    private int freePlacesForTasks;
    private int currentUnassignedTask;

    public AllWork() {
        tasks = new Task[NUMBER_OF_TASKS];
        this.freePlacesForTasks = NUMBER_OF_TASKS;
        this.currentUnassignedTask = -1;
    }

    public void addTask(Task task) {
        if (this.freePlacesForTasks == 0) {
            System.out.println("There is no more space for tasks!");
            return;
        }

        if (task == null) {
            System.out.println("Not a valid task! Can not be added!");
            return;
        }

        tasks[NUMBER_OF_TASKS - freePlacesForTasks] = task;

        if (this.currentUnassignedTask == -1) {
            this.currentUnassignedTask = NUMBER_OF_TASKS - freePlacesForTasks;
        }

        this.freePlacesForTasks--;
    }

    public Task getNextTask() {
        if (currentUnassignedTask == -1) {
            System.out.println("There is not unassigned task!");
            return null;
        }

        Task t = tasks[currentUnassignedTask];

        if (currentUnassignedTask == NUMBER_OF_TASKS - 1 || tasks[currentUnassignedTask + 1] == null) {
            currentUnassignedTask = -1;
        } else {
            currentUnassignedTask++;
        }

        return t;
    }

    public boolean isAllWorkDone() {
        for (int i = 0; i < NUMBER_OF_TASKS - freePlacesForTasks; i++) {
            if (tasks[i].getWorkingHours() > 0) {
                return false;
            }
        }
        return true;
    }

    public void showTasks(){
        for (int i = 0; i < NUMBER_OF_TASKS - freePlacesForTasks; i++) {
            tasks[i].print();
        }
    }
}
package module_two.abstraction.task_employee;

public class Demo {
    public static void main(String[] args) {

        AllWork allWork = new AllWork();
        allWork.addTask(new Task("Task1", 8));
        allWork.addTask(new Task("Task2", 10));
        allWork.addTask(new Task("Task3", 12));
        allWork.addTask(new Task("Task4", 3));
        allWork.addTask(new Task("Task5", 5));
        allWork.addTask(new Task("Task6", 15));
        allWork.addTask(new Task("Task7", 9));
        allWork.addTask(new Task("Task8", 7));
        allWork.addTask(new Task("Task9", 1));
        allWork.addTask(new Task("Task10", 6));
        allWork.addTask(new Task("Task11", 11));

        Employee.setAllWork(allWork);

        Employee[] employees = new Employee[]{
                new Employee("Gosho"),
                new Employee("Pesho"),
                new Employee("Mimi")
        };

        int day = 1;
        while (!allWork.isAllWorkDone()) {
            System.out.println("DAY " + day++);
            startWorkingDay(employees);
            work(employees);
            System.out.println();
        }

        allWork.showTasks();
    }

    private static void startWorkingDay(Employee[] employees) {
        for (Employee employee : employees) {
            employee.startWorkingDay();
        }
    }

    private static void work(Employee[] employees) {
        for (Employee employee : employees) {
            employee.work();
        }
    }
}

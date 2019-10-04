package module_two.lesson13_classes_objects.task1;

public class ComputerDemo {
    public static void main(String[] args) {

        //Lecture 13, Task 1
//        Computer comp1 = new Computer();
//        Computer comp2 = new Computer();
//        comp1.year = 2016;
//        comp1.price = 850;
//        comp1.hardDiskMemory = 8;
//        comp1.freeMemory = 5;
//        comp1.operationSystem = "Linux";
//        comp2.year = 2018;
//        comp2.price = 1250.99;
//        comp2.hardDiskMemory = 500;
//        comp2.freeMemory = 250;
//        comp2.operationSystem = "Windows";
//        comp2.isNotebook = true;
//        comp1.changeOperationSystem("Ubuntu");
//        comp2.useMemory(100);
//        System.out.println(comp1.toString());
//        System.out.println(comp2.toString());

        //Lecture 14, Task 1

        Computer c1 = new Computer();
        Computer c2 = new Computer(2016, 999.99, 550.50, 165.35);
        Computer c3 = new Computer(2018, 1359.87, true,
                555.55, 444.03, "Windows 10");
        if (c2.comparePrice(c3) > 0){
            System.out.println("c2 has higher price");
        } else if (c2.comparePrice(c3) < 0){
            System.out.println("c3 has higher price");
        } else {
            System.out.println("The computers have same price");
        }
    }
}

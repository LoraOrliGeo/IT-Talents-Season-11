package module_three.test_three_exercise.kinder_garden;

public class Demo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            BiggerChild bigger = new BiggerChild("Gosheto " +(i + 1), Group.GroupName.FROGS);
            BiggerChild anotherBigger = new BiggerChild("Mimi " + (i + 1), Group.GroupName.LADYBUGS);
            Toddler toddler = new Toddler("Pesho " + (i + 1), Group.GroupName.DUCKS);
            Toddler anotherToddler = new Toddler("Lili " + (i + 1), Group.GroupName.PENGUINS);

            new Thread(bigger).start();
            new Thread(anotherBigger).start();
            new Thread(toddler).start();
            new Thread(anotherToddler).start();
        }
    }
}

package module_three.threads.lecture_two;

public class Demo {
    public static void main(String[] args) {

        Pot pot = new Pot();
        Grandmother baba = new Grandmother(pot);
        Grandchild vnuche = new Grandchild(pot);

        baba.start();
        vnuche.start();
    }
}

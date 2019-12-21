package module_three.design_patterns.singleton;

public class Demo {
    public static void main(String[] args) {
        
        ElvisPresley elvisTheKing = ElvisPresley.getInstance();
        ElvisPresley fakeElvis = ElvisPresley.getInstance();
        System.out.println(elvisTheKing);
        System.out.println(fakeElvis);
        // same addresses in the memory -> one object! ^^
    }
}

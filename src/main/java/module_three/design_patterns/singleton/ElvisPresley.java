package module_three.design_patterns.singleton;

public class ElvisPresley {
    // lazy initialization
//    private static ElvisPresley elvis;
//    private ElvisPresley(){}
//    public static ElvisPresley getInstance(){
//        if (elvis == null){
//            elvis = new ElvisPresley();
//        }
//        return elvis;
//    }

    //eager initialization
    private static ElvisPresley elvis = new ElvisPresley();
    private ElvisPresley() {}
    public static ElvisPresley getInstance() {return elvis;}
}

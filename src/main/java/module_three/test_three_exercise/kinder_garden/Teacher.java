package module_three.test_three_exercise.kinder_garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teacher extends Thread {
    private Group.GroupName groupName;
    private List<Figure> readyFigures;

    public Teacher(String name, Group.GroupName groupName) {
        super(name);
        this.groupName = groupName;
        this.readyFigures = new ArrayList<>();
    }

    public void takeChild(Child child) {
        KinderGarden.getInstance().addChildToGroup(child);
    }

    public Group.GroupName getGroupName() {
        return groupName;
    }

    public void addReadyFigure(Figure figure) {
        this.readyFigures.add(figure);
    }

    @Override
    public void run() {
        // while(true) takeChildren ?
        makeStatistics();
    }

    private void makeStatistics() {
        //create DB manager and FigureDAO to save the Figure in DB :)
        System.out.println("I'm making statistics...");
    }

    public Group.GroupActivity getActivity() {
        // 50 % type of activity
        if (new Random().nextBoolean()) {
            return Group.GroupActivity.SINGING;
        } else {
            if (new Random().nextBoolean()) {
                return Group.GroupActivity.DRAWING;
            }
            return Group.GroupActivity.COLORING;
        }
    }
}

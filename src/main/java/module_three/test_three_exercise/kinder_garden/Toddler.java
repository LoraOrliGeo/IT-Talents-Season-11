package module_three.test_three_exercise.kinder_garden;

import java.time.LocalDate;
import java.util.Random;

public class Toddler extends Child implements Runnable {
    public Toddler(String name, Group.GroupName groupName) {
        super(name, groupName);
    }

    @Override
    public void setGroupName(Group.GroupName groupName) {
        if (groupName.equals(Group.GroupName.DUCKS) || groupName.equals(Group.GroupName.PENGUINS)) {
            this.groupName = groupName;
        }
    }

    @Override
    void makeActivity() {
        // singing or coloring (children from penguins and ducks)
        switch (KinderGarden.getInstance().getGroupByName(this.groupName).getActivity()) {
            case SINGING:
                try {
                    Thread.sleep(200); // 10 children - each of them is singing -> 2 seconds
                    System.out.println(this.getName() + " is singing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case COLORING:
                // take draw figure and color it
                Figure figure = KinderGarden.getInstance().getTable().getDrawnFigure();
                if (figure != null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int milliseconds = KinderGarden.getInstance().getTable().colorFigure(figure);
                    figure.setColorist(this);
                    figure.setCreateDate(LocalDate.now());
                    figure.setTimeToColor(milliseconds);

                    KinderGarden.getInstance().getTeacherByGroupName(this.getGroupName()).addReadyFigure(figure);

                    notifyAll();
                }

                break;
        }
    }

    public void run() {
        try {
            int milliseconds = new Random().nextInt(2001) + 1000;
            Thread.sleep(milliseconds);
            Teacher teacher = KinderGarden.getInstance().getRandomTeacher();
            teacher.takeChild(this);
            System.out.println(teacher.getName() + " took " + this.getName() + " to " + groupName);
            //color
            // sleep
            makeActivity();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package module_three.test_three_exercise.kinder_garden;

import java.util.Random;

public class BiggerChild extends Child implements Runnable {

    public BiggerChild(String name, Group.GroupName groupName) {
        super(name, groupName);
    }

    @Override
    public void setGroupName(Group.GroupName groupName) {
        if (groupName.equals(Group.GroupName.LADYBUGS) || groupName.equals(Group.GroupName.FROGS)) {
            this.groupName = groupName;
        }
    }

    @Override
    void makeActivity() {
        // singing or drawing (children from Frogs and Ladybugs)
        switch (KinderGarden.getInstance().getGroupByName(this.groupName).getActivity()) {
            case SINGING:
                try {
                    Thread.sleep(200); // 10 children - each of them is singing -> 2 seconds
                    System.out.println(this.getName() + " is singing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case DRAWING:
                // drawing is processing for no more than 60 seconds
                int milliseconds = 0;
                while (milliseconds < 60000) {
                    int randomIdx = new Random().nextInt(Figure.FigureType.values().length);
                    Figure.FigureType type = Figure.FigureType.values()[randomIdx];
                    Figure figure = new Figure(type);
                    milliseconds += KinderGarden.getInstance().getTable().drawFigure(figure);
                    figure.setDrawer(this);
                    figure.setTimeToDraw(milliseconds);
                    figure.setGroupName(this.getGroupName());
                }
                break;
        }
    }

    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2001) + 1000);
            Teacher teacher = KinderGarden.getInstance().getRandomTeacher();
            teacher.takeChild(this);
            System.out.println(teacher.getName() + " took " + getName() + " to " + groupName);
            //draw
            Thread.sleep(new Random().nextInt(2001) + 1000);
            makeActivity();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

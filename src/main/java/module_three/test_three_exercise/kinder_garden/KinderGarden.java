package module_three.test_three_exercise.kinder_garden;

import java.util.*;

public class KinderGarden {
    private static KinderGarden instance = new KinderGarden();

    public class Table {
        private List<Figure> drawFigures; // should it be volatile?
        private List<Figure> colorFigures;

        Table() {
            this.drawFigures = new ArrayList<>();
            this.colorFigures = new ArrayList<>();
        }

        public synchronized int drawFigure(Figure figure) {
            // invoke by BiggerChild
            int milliseconds = new Random().nextInt(2001) + 1000;
            try {
                Thread.sleep(milliseconds);
                this.drawFigures.add(figure);
                System.out.println("Bigger child DRAW " + figure.getType());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // wait() ?
            notifyAll();
            return milliseconds;
        }

        public synchronized int colorFigure(Figure figure) {
            // invoke by Toddler
            int milliseconds = new Random().nextInt(2001) + 1000;
            try {
                Thread.sleep(milliseconds);
                this.colorFigures.add(figure);
                System.out.println("Toddler COLOR " + figure.getType());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return milliseconds;
        }

        public List<Figure> getDrawFigures() {
            return Collections.unmodifiableList(drawFigures);
        }

        public Figure getDrawnFigure() {
            if (!this.drawFigures.isEmpty()) {
                return this.drawFigures.remove(0);
            }
            return null;
        }

        public List<Figure> getColorFigures() {
            return Collections.unmodifiableList(colorFigures);
        }
    }

    private Map<Group.GroupName, Group> groups;
    private List<Teacher> teachers;
    private Table table;

    private KinderGarden() {
        initGroup();
        initTeachers();
        this.table = new Table();
    }

    private void initGroup() {
        this.groups = new HashMap<>();
        this.groups.put(Group.GroupName.DUCKS, new Group(Group.GroupName.DUCKS,
                new Teacher("Ivanova", Group.GroupName.DUCKS)));
        this.groups.put(Group.GroupName.LADYBUGS, new Group(Group.GroupName.LADYBUGS,
                new Teacher("Todorova", Group.GroupName.LADYBUGS)));
        this.groups.put(Group.GroupName.FROGS, new Group(Group.GroupName.FROGS,
                new Teacher("Georgieva", Group.GroupName.FROGS)));
        this.groups.put(Group.GroupName.PENGUINS, new Group(Group.GroupName.PENGUINS,
                new Teacher("Nikolova", Group.GroupName.PENGUINS)));
    }

    private void initTeachers() {
        this.teachers = new ArrayList<>();
        this.teachers.add(new Teacher("Teacher 1", Group.GroupName.DUCKS));
        this.teachers.add(new Teacher("Teacher 2", Group.GroupName.PENGUINS));
        this.teachers.add(new Teacher("Teacher 3", Group.GroupName.FROGS));
        this.teachers.add(new Teacher("Teacher 4", Group.GroupName.LADYBUGS));
    }

    public static KinderGarden getInstance() {
        return instance;
    }

    public Teacher getRandomTeacher() {
        return this.teachers.get(new Random().nextInt(this.teachers.size()));
    }

    public synchronized void addChildToGroup(Child child) {
        Group group = this.groups.get(child.getGroupName());
        group.addChild(child);
        System.out.println(child.getName() + " arrived in the garden");

        synchronized (this.groups.get(child.getGroupName())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (group.getChildrenCount() >= 10) {
                Teacher teacher = getTeacherByGroupName(child.getGroupName());
                // set activity to the group
                this.getGroupByName(child.getGroupName()).setActivity(teacher.getActivity());

                for (Child c : group.getChildren()) {
                    c.makeActivity();
                }

                notifyAll();
            }
        }
    }

    public Group getGroupByName(Group.GroupName groupName) {
        return this.groups.get(groupName);
    }

    public Teacher getTeacherByGroupName(Group.GroupName groupName) {
        Teacher teacher = null;
        for (Teacher t : this.teachers) {
            if (t.getGroupName().equals(groupName)) {
                teacher = t;
                break;
            }
        }
        return teacher;
    }

    public Table getTable() {
        return this.table;
    }
}

package module_three.test_three_exercise.kinder_garden;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private GroupName groupName;
    private List<Child> children;
    private GroupActivity activity;

    enum GroupName {
        DUCKS, PENGUINS, FROGS, LADYBUGS
    }

    enum GroupActivity {
        SINGING, DRAWING, COLORING
    }

    public Group(GroupName groupName, Teacher teacher) {
        this.groupName = groupName;
        this.children = new ArrayList<>();
        teacher.setDaemon(true);
        teacher.start();
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }

    public int getChildrenCount() {
        return this.children.size();
    }

    public void setActivity(GroupActivity activity) {
        this.activity = activity;
    }

    public GroupActivity getActivity() {
        return activity;
    }
}

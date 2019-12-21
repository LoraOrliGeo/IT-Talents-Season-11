package module_three.test_three_exercise.kinder_garden;

import java.util.Objects;

public abstract class Child extends Thread{
    protected Group.GroupName groupName;

    protected Child(String name, Group.GroupName groupName) {
        super(name);
        setGroupName(groupName);
    }

    public Group.GroupName getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return groupName == child.groupName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    public abstract void setGroupName(Group.GroupName groupName);

    abstract void makeActivity();
}

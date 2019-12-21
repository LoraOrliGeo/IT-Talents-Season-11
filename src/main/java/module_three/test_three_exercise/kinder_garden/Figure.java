package module_three.test_three_exercise.kinder_garden;

import java.time.LocalDate;

public class Figure {

    enum FigureType {
        CIRCLE, SQUARE, TRIANGLE, STAR
    }

    private FigureType type;
    private BiggerChild drawer;
    private Toddler colorist;
    private int timeToDraw; // seconds
    private int timeToColor; // seconds
    private LocalDate createDate;
    private Group.GroupName groupName;

    public Figure(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public BiggerChild getDrawer() {
        return drawer;
    }

    public void setDrawer(BiggerChild drawer) {
        this.drawer = drawer;
    }

    public Toddler getColorist() {
        return colorist;
    }

    public void setColorist(Toddler colorist) {
        this.colorist = colorist;
    }

    public int getTimeToDraw() {
        return timeToDraw;
    }

    public void setTimeToDraw(int timeToDraw) {
        this.timeToDraw = timeToDraw / 1000;
    }

    public int getTimeToColor() {
        return timeToColor;
    }

    public void setTimeToColor(int timeToColor) {
        this.timeToColor = timeToColor / 1000;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Group.GroupName getGroupName() {
        return groupName;
    }

    public void setGroupName(Group.GroupName groupName) {
        this.groupName = groupName;
    }
}

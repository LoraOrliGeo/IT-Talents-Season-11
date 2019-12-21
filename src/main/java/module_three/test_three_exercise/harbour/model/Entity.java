package module_three.test_three_exercise.harbour.model;

import java.time.LocalDateTime;

public class Entity {
    public static int uniqueId = 1;
    private int entityId;
    private int packageId;
    private int dockId;
    private String shipName;
    private String craneName;
    private LocalDateTime unloadDate;

    public Entity() {
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getDockId() {
        return dockId;
    }

    public void setDockId(int dockId) {
        this.dockId = dockId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getCraneName() {
        return craneName;
    }

    public void setCraneName(String craneName) {
        this.craneName = craneName;
    }

    public LocalDateTime getUnloadDate() {
        return unloadDate;
    }

    public void setUnloadDate(LocalDateTime unloadDate) {
        this.unloadDate = unloadDate;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return String.format("Package %d, ship \"%s\", %s, %s",
                this.packageId, this.shipName, this.craneName, this.unloadDate);
    }
}

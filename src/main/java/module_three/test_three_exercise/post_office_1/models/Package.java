package module_three.test_three_exercise.post_office_1.models;

import java.time.LocalDate;

public abstract class Package {
    private Citizen sender;
    private Citizen receiver;
    protected double tax;
    private LocalDate receivingDate;

    public Package(Citizen sender, Citizen receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public abstract int getTimeToDeliver();

    public abstract boolean isLetter();

    @Override
    public String toString() {
        String e = String.format("type: %s%n\tSender name: %s%n\tReceiver name: %s%n",
                this.isLetter() ? "letter" : "parcel",
                this.sender.getFirstName() + " " + this.sender.getLastName(),
                this.receiver.getFirstName() + " " + this.receiver.getLastName());

        if (!this.isLetter()) {
            if (this instanceof Parcel) {
                e += ((Parcel) this).isOversize() ? "oversize: true" : "oversize : false";
                e += "\n";
                e += ((Parcel) this).isFragile() ? "fragile : true" : "fragile : false";
                e += "\n";
            }
        }

        return e;
    }

    public LocalDate getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDate receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getType() {
        if (this.isLetter()) {
            return "letter";
        }
        return "parcel";
    }

    public String getSenderName() {
        return this.sender.getFirstName() + " " + sender.getLastName();
    }

    public String getReceiverName() {
        return this.receiver.getFirstName() + " " + receiver.getLastName();
    }

    public boolean isFragile() {
        return false;
    }

    public boolean isOversize() {
        return false;
    }
}

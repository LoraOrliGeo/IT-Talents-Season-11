package module_two.polymorphism;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
    private boolean isTurnOn;

    public ElectronicSecuredNotepad(int pages, String password) {
        super(pages, password);
        isTurnOn = false;
    }

    @Override
    public void start() {
        this.isTurnOn = true;
    }

    @Override
    public void stop() {
        this.isTurnOn = false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    //to modify the pages: 1. correct password; 2. the device should be turned on -> override methods?
}

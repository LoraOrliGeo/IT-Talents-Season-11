package module_three.test_three_exercise.post_office;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PostOffice {

    private static final int NUMBER_OF_POSTBOXES = 25;
    private static final int MIN_NUMBER_OF_PACKAGES = 50;
    private static final int NUMBER_OF_MAILMEN = 10;
    private static final int NUMBER_OF_GATHERERS = 10;

    private static PostOffice instance = new PostOffice();

    private List<PostBox> postBoxes;
    private LinkedList<Package> repository;
    private Map<LocalDate, TreeMap<LocalTime, Package>> archive;
    private List<Mailman> mailmen;

    private PostOffice() {
        initPostBoxes();
        this.repository = new LinkedList<>();
        this.archive = new TreeMap<>();
        initMailmen();
        initGatherers();
    }

    public static PostOffice getInstance() {
        return instance;
    }

    private void initPostBoxes() {
        this.postBoxes = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_POSTBOXES; i++) {
            this.postBoxes.add(new PostBox());
        }
    }

    private void initMailmen() {
        this.mailmen = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_MAILMEN; i++) {
            Mailman mailman = new Mailman("Mailman " + (i + 1), "Ivanov", i + 25);
            this.mailmen.add(mailman);
            new Thread(mailman).start();
        }
    }

    private void initGatherers() {
        for (int i = 0; i < NUMBER_OF_GATHERERS; i++) {
            Gatherer gatherer = new Gatherer("Gatherer " + (i + 1), "Petrov", i + 2);
            new Thread(gatherer).start();
        }
    }

    public PostBox getRandomPostBox() {
        Collections.shuffle(this.postBoxes);
        return this.postBoxes.get(0);
    }

    private void addToRepository(List<Package> packages) {
        for (Package p : packages) {
            this.addPackage(p);
        }
    }

    public synchronized void addPackage(Package p) {
        this.repository.add(p);

        LocalDate now = LocalDate.now();
        this.archive.putIfAbsent(now, new TreeMap<>());
        this.archive.get(now).put(LocalTime.now(), p);
    }

    public synchronized void takeLettersFromBoxes() {
        try {
            while (this.repository.size() >= MIN_NUMBER_OF_PACKAGES) {
                wait();
            }

            Thread.sleep(2000); // 2 hours
            for (PostBox postBox : this.postBoxes) {
                this.addToRepository(postBox.empty());
            }
            System.out.println("Gatherers filled the post office and emptied all boxes. Repository now has " + repository.size());
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void empty(Mailman mailman) {
        try {
            while (this.repository.size() < MIN_NUMBER_OF_PACKAGES) {
                wait();
            }

            mailman.setBusy(true);
            int freeMailmen = takeFreeMailmen();
            int packagesPerMailman = this.mailmen.size() / freeMailmen;
            List<Package> packagesToDeliver = new ArrayList<>();
            for (int i = 0; i < packagesPerMailman; i++) {
                packagesToDeliver.add(this.repository.removeFirst()); // that's why the repository linked list
            }
            for (Package p : packagesToDeliver) {
                if (p.getPackageType() == Package.PackageType.LETTER) {
                    Thread.sleep(1000); // 10 minutes per letter
                    System.out.println("Mailman finished to deliver letters");
                } else if (p.getPackageType() == Package.PackageType.PARCEL){
                    Thread.sleep(1500); // 15 minutes per parcel
                    System.out.println("Mailman finished to deliver parcels");
                }
                mailman.increaseDeliverPackagesCount();
            }
            mailman.setBusy(false);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int takeFreeMailmen() {
        int count = 0;
        for (Mailman mailman : this.mailmen) {
            if (!mailman.isBusy()) {
                count++;
            }
        }
        return count;
    }
}

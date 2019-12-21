package module_three.test_three_exercise.post_office_1.models;

import module_three.test_three_exercise.post_office_1.db.DbDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PostOffice {
    private static PostOffice INSTANCE = new PostOffice();
    private List<PostBox> boxes;
    private Map<LocalDate, Map<LocalDateTime, List<Package>>> archive;
    private List<Package> repository;
    private List<Mailman> mailmen;
    private Archiver archiver;

    public enum BackupType {
        FILE, DATABASE
    }

    public class Archiver extends Thread {
        private BackupType backupType = BackupType.FILE;

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(2400); // 24 hours
                    makeArchive();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public BackupType getBackupType() {
            return backupType;
        }

        public void setBackupType(BackupType backupType) {
            this.backupType = backupType;
        }

        private void makeArchive() throws IOException, SQLException {
            switch (this.backupType) {
                case FILE:
                    File file = new File("C:\\Users\\Lori\\Desktop\\postOfficeStats.txt");

                    try (PrintWriter pw = new PrintWriter(new FileOutputStream(file))) {
                        for (Map.Entry<LocalDate, Map<LocalDateTime, List<Package>>> entry : PostOffice.getInstance().archive.entrySet()) {
                            pw.println(entry.getKey());
                            for (List<Package> packages : entry.getValue().values()) {
                                for (Package p : packages) {
                                    pw.println(p.toString());
                                }
                            }
                        }
                        pw.println();
                    }
                    break;
                case DATABASE:
                    this.backupType = BackupType.DATABASE;

                    for (Map<LocalDateTime, List<Package>> value : PostOffice.getInstance().archive.values()) {
                        for (List<Package> packages : value.values()) {
                            for (Package p : packages) {
                                DbDao.getInstance().addEntity(p);
                            }
                        }
                    }
                    break;
            }
        }
    }

    private PostOffice() {
        this.boxes = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            boxes.add(new PostBox());
        }
        this.archive = new TreeMap<>();
        this.repository = new ArrayList<>();
        this.mailmen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Mailman mailman = new Mailman("Pesho" + (i + 1), "Petrov", i + 10);
            this.mailmen.add(mailman);
            mailman.start();

            Gatherer gatherer = new Gatherer("Stamat" + (i + 1), "Stoev", i + 2);
            gatherer.start();
        }

        this.archiver = new Archiver();
        archiver.setBackupType(BackupType.DATABASE);
        this.archiver.setDaemon(true);
        this.archiver.start();
    }

    public Archiver getArchiver() {
        return archiver;
    }

    public synchronized static PostOffice getInstance() {
        return INSTANCE;
    }

    public synchronized void addLetterToBox(Letter letter) {
        PostBox box = this.boxes.get(new Random().nextInt(this.boxes.size()));
        box.addLetter(letter);
    }

    public synchronized void addToRepository(Package p) {
        this.repository.add(p);
        LocalDate now = LocalDate.now();
        p.setReceivingDate(now);
        if (this.archive.containsKey(now)) {
            this.archive.put(now, new TreeMap<>());
        }
        LocalDateTime time = LocalDateTime.now();
        this.archive.get(now).put(time, new ArrayList<>());
        this.archive.get(now).get(time).add(p);
    }

    public synchronized void gatherLettersFromBoxes() {
        while (this.repository.size() > 50) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (PostBox box : this.boxes) {
                List<Letter> letters = box.emptyBox();
                this.repository.addAll(letters);
                for (Letter letter : letters) {
                    addToRepository(letter);
                }
            }

            notifyAll();
        }
    }

    public synchronized void carryPackages() throws InterruptedException {
        while (this.repository.size() <= 50) {
            wait();
        }

        int packagesToDeliver = this.repository.size() / this.mailmen.size();
        for (Mailman mailman : this.mailmen) {
            int timeToSleep = 0;
            List<Package> packages = this.repository.subList(0, packagesToDeliver);
            for (Package p : packages) {
                timeToSleep += p.getTimeToDeliver();
            }
            Thread.sleep(timeToSleep * 100);
            mailman.increaseNumberOfDeliveredPackages(packagesToDeliver);
            this.repository.subList(0, packagesToDeliver).clear();
        }

        notifyAll();
    }

    // references:
    public Map<LocalDate, List<Package>> getPackagesByDate(LocalDate date) {
        Map<LocalDate, List<Package>> map = new TreeMap<>();

        return map;
    }

    public double getPercentLetters(LocalDate date) {
        int totalPackagesCountForDate = this.archive.get(date).values().size();
        int letterCount = 0;
        for (List<Package> packages : this.archive.get(date).values()) {
            for (Package p : packages) {
                if (p.isLetter()) {
                    letterCount++;
                }
            }
        }

        return letterCount * 1.0 / totalPackagesCountForDate * 100;
    }

    public double getPercentFragileParcels() {
        int totalParcels = 0;
        int fragileParcels = 0;

        for (Map.Entry<LocalDate, Map<LocalDateTime, List<Package>>> entry : this.archive.entrySet()) {
            for (List<Package> packages : entry.getValue().values()) {
                for (Package p : packages) {
                    if (!p.isLetter()) {
                        totalParcels++;

                        if (p instanceof Parcel) {
                            if (((Parcel) p).isFragile()) {
                                fragileParcels++;
                            }
                        }
                    }
                }
            }
        }

        return fragileParcels * 1.0 / totalParcels * 100;
    }

    public List<Map.Entry<Mailman, Integer>> getNumberDeliveredPackagesPerMailman() {
        HashMap<Mailman, Integer> map = new HashMap<>();

        for (Mailman mailman : this.mailmen) {
            map.put(mailman, mailman.getDeliveredPackagesCount());
        }
        List<Map.Entry<Mailman, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((m1, m2) -> m2.getValue() - m1.getValue());
        return list;
    }
}

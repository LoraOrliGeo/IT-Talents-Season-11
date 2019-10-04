package module_two.lesson13_classes_objects.task2_students;

public class Student {
    private static final int YEARS_OF_EDUCATION = 4;
    private static final int MAX_YEARS_SCHOLARSHIP = 30;
    private static final int MIN_GRADE = 2;
    private static final int MAX_GRADE = 6;

    private String name;
    private String subject;
    private double grade;
    private int yearInCollege;
    private int age;
    private boolean isDegree;
    private double money;

    private Student() {
        this.grade = 4.0;
        this.yearInCollege = 1;
        this.isDegree = false;
        this.money = 0;
    }

    public Student(String name, String subject, int age) {
        this();
        this.setName(name);
        this.setSubject(subject);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getSubject() {
        return this.subject;
    }

    private void setSubject(String subject) {
        if (subject != null && !subject.isEmpty()) {
            this.subject = subject;
        }
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        if (MIN_GRADE <= grade && grade <= MAX_GRADE) {
            this.grade = grade;
        }
    }

    private void setAge(int age) {
        if (age > 5) {
            this.age = age;
        }
    }

    public void upYear() {
        if (!this.isDegree) {
            this.yearInCollege++;
            if (this.yearInCollege == YEARS_OF_EDUCATION) {
                isDegree = true;
            }
        } else {
            System.out.println(String.format("Congratulations! You got a degree in %s!", this.getSubject()));
        }
    }

    public double receiveScholarship(double min, double amount) {
        if (this.grade >= min && this.age < MAX_YEARS_SCHOLARSHIP) {
            this.money += amount;
        }
        return this.money;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                        "Grade: %.2f%n" +
                        "Age: %d%n" +
                        "Year in college: %d%n" +
                        "Degree: %s%n" +
                        "Money: %.2f",
                this.getName(),
                this.getGrade(),
                this.age,
                this.yearInCollege,
                this.isDegree ? "yes" : "no",
                this.money);
    }
}

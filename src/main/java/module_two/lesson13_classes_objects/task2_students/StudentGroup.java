package module_two.lesson13_classes_objects.task2_students;

public class StudentGroup {
    private static final int STUDENTS_IN_GROUP = 5;
    private static final String DEFAULT_SUBJECT = "default_subject";

    private String groupSubject;
    private Student[] students;
    private int freeSpaces;

    public StudentGroup() {
        this.emptyGroup();
    }

    public StudentGroup(String subject) {
        this();
        this.setGroupSubject(subject);
    }

    private void setGroupSubject(String subject) {
        if (subject != null && !subject.isEmpty()) {
            this.groupSubject = subject;
        } else {
            this.groupSubject = DEFAULT_SUBJECT;
        }
    }

    public void addStudent(Student s) {
        if (s != null) {
            boolean hasSameSubject = this.groupSubject.equals(s.getSubject());
            boolean haveFreeSpaces = this.freeSpaces > 0;
            if (hasSameSubject && haveFreeSpaces) {
                this.students[STUDENTS_IN_GROUP - freeSpaces] = s;
                this.freeSpaces--;
            } else {
                if (!hasSameSubject) {
                    System.out.println("Sorry, you can not join to group - you have different subject!");
                }
                if (!haveFreeSpaces) {
                    System.out.println("Sorry, there are no more free spaces in the group!");
                }
            }
        }
    }

    public void emptyGroup() {
        this.students = new Student[STUDENTS_IN_GROUP];
        this.freeSpaces = STUDENTS_IN_GROUP;
        this.groupSubject = DEFAULT_SUBJECT;
    }

    public String theBestStudent() {
        Student bestStudent = null;
        double bestGrade = -1;

        for (int i = 0; i < STUDENTS_IN_GROUP - this.freeSpaces; i++) {
            double currentGrade = students[i].getGrade();
            if (currentGrade > bestGrade) {
                bestGrade = currentGrade;
                bestStudent = students[i];
            }
        }

        if (bestStudent != null) {
            return bestStudent.getName();
        } else {
            return "There aren't any students!";
        }
    }

    public void printStudentsInGroup() {
        System.out.println("Group subject: " + this.groupSubject);
        for (Student student : this.students) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }
}

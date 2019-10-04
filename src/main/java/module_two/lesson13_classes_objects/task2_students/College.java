package module_two.lesson13_classes_objects.task2_students;

public class College {
    public static void main(String[] args) {

        StudentGroup st = new StudentGroup(null);


        Student pesho = new Student("Petur Petrov", "mathematics", 18);

        st.addStudent(pesho);

        pesho.upYear();
        pesho.setGrade(4.86);
        Student lori = new Student("Lora Georgieva", "chemistry", 20);
        lori.setGrade(6.00);
        System.out.println(lori.receiveScholarship(5.00, 500));
        lori.upYear();
        Student martin = new Student("Martin Georgiev", "archeology", 20);
        Student gosho = new Student("Georgi Gorgev", "mathematics", 21);
        gosho.setGrade(5.59);
        gosho.upYear();
        gosho.upYear();
        gosho.upYear();
        gosho.upYear();

        StudentGroup group = new StudentGroup("mathematics");
        group.addStudent(null);
        group.addStudent(lori);
        group.addStudent(pesho);
        group.addStudent(martin);
        group.addStudent(gosho);
        System.out.println(group.theBestStudent());
        group.printStudentsInGroup();

        group.emptyGroup();

    }
}

package module_two.lesson17_inheritance.Task1;

public class Demo {
    public static void main(String[] args) {

        Person[] people = new Person[10];
        int idx = 0;

        Person p1 = new Person("Monica", 34, false);
        Person p2 = new Person("Josh", 31, true);
        people[idx++] = p1;
        people[idx++] = p2;

        Student s1 = new Student("Gosho", 14, true, 5.49);
        Student s2 = new Student("Mimi", 12, false, 4.99);
        people[idx++] = s1;
        people[idx++] = s2;

        Employee e1 = new Employee("Stavri", 42, true, 250);
        Employee e2 = new Employee("Ginka", 17, false, 275);
        people[idx++] = e1;
        people[idx] = e2;

        for (int i = 0; i <= idx; i++) {
            String type = people[i].getClass().getSimpleName();

            switch (type) {
                case "Student":
                    ((Student) people[i]).showStudentInfo();
                    break;
                case "Employee":
                    ((Employee) people[i]).showEmployeeInfo();
                    break;
                default:
                    people[i].showPersonInfo();
                    break;
            }
        }

        for (int i = 0; i <= idx; i++) {
            if (people[i] instanceof Employee) {
                System.out.println(String.format("Name: %s%n" +
                                "Overtime 2 hours: %.2f%n",
                        people[i].getName(),
                        ((Employee) people[i]).calculateOvertime(2)));
            }
        }

        /*
        Какво ще стане, ако се дефинира конструктор без параметри Student() в класа Student?
        Възможно ли е и ако не, защо?
        Как може да се оправи това?

        Не е възможно създаването на default-ен, празен конструктор Student(), защото класът Student
        наследява класа Person, който има дефиниран конструктор с параметри и за да се създаде обект
        от тип Student, то имплицитно първо трябва да се създаде обект от тип Person по съществуващият
        конструктор (не-default-ен).
        За да може да се дефинира Student(), е необходимо parent-класа също да има default-ен конструктор,
        който пък е наследен от Object класа. Друг вариант е в тялото на Student() да се извиква super()
        с нужния брой параметри (в този случай 3).
         */
    }
}

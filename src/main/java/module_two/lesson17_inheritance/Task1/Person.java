package module_two.lesson17_inheritance.Task1;

public class Person {
    private static final String DEFAULT_NAME = "default_name";

    private String name;
    private int age;
    private boolean isMale;

    public Person(String name, int age, boolean isMale) {
        setName(name);
        setAge(age);
        this.isMale = isMale;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public void showPersonInfo() {
        System.out.println(String.format("Name: %s%n" +
                        "Age: %d%n" +
                        "Gender: %s",
                this.name.equals(DEFAULT_NAME) ? "-" : this.name,
                this.age,
                this.isMale ? "Male" : "Female"));
    }
}

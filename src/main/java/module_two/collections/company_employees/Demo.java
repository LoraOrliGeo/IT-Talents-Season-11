package module_two.collections.company_employees;

public class Demo {
    public static void main(String[] args) {

        Company company = new Company("ASD Group");
        Employee lori = new Employee("Lora", 24, 1500);
        Employee grigorche = new Employee("Grigor", 24, 1750);
        Employee nancy = new Employee("Nancy", 22, 1600);
        Employee krasi = new Employee("Krasi", 26, 1800);

        company.addEmployee("IT-Brains", grigorche);
        company.addEmployee("IT-Talents", lori);
        company.addEmployee("IT-Talents", nancy);
        company.addEmployee("IT-Brains", krasi);
        company.addEmployee("IT-Talents", krasi);

        company.printCompany();
        System.out.println("-----------------------------------");
        company.printEmployees(SortingCriteria.AGE);
        System.out.println("-----------------------------------");
        company.printEmployees(SortingCriteria.SALARY);
        System.out.println("-----------------------------------");
        company.printEmployees(SortingCriteria.NAME);
        company.removeDuplicateEmployees();
    }
}

package test_two_exercise.real_estates.clients;

import test_two_exercise.real_estates.agency.Agency;

public class AgencyPerson {
    private String name;
    private String phone;
    protected double money;
    public static Agency agency;

    public AgencyPerson(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    private void setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
        }
    }

    public void receiveMoney(double money) {
        if (money > 0) {
            this.money += money;
        }
    }

    public void spendMoney(double money){
        if (money <= this.money){
            this.money -= money;
        }
    }

    public double getMoney() {
        return this.money;
    }
}

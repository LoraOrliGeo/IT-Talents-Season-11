package test_two_exercise.real_estates.clients;

import test_two_exercise.real_estates.agency.Agency;

public abstract class Client extends AgencyPerson {
    public static final double COMMISSION_PERCENTAGE = 0.03;

    public Client(String name, String phone) {
        super(name, phone);
    }
}
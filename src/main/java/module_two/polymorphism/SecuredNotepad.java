package module_two.polymorphism;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad {
    private String password;

    public SecuredNotepad(int pages, String password) {
        super(pages);

        if (!isStrongPassword(password)) {
            throw new IllegalArgumentException("Weak password!");
        }

        setPassword(password);
    }

    private void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
        }
    }

    @Override
    public void addTextToGivenPage(String text, int page) {
        String pass = this.readPassword();
        if (this.password.equals(pass)) {
            super.addTextToGivenPage(text, page);
        } else {
            printErrorMessage();
        }
    }

    @Override
    public void overrideTextToGivenPage(String text, int page) {
        String pass = this.readPassword();
        if (this.password.equals(pass)) {
            super.overrideTextToGivenPage(text, page);
        } else {
            printErrorMessage();
        }
    }

    @Override
    public void deleteTextFromGivenPage(int page) {
        String pass = this.readPassword();
        if (this.password.equals(pass)) {
            super.deleteTextFromGivenPage(page);
        } else {
            printErrorMessage();
        }
    }

    @Override
    public void viewNotepad() {
        String pass = this.readPassword();
        if (this.password.equals(pass)) {
            super.viewNotepad();
        } else {
            System.out.println("Access Denied! You can not view the content!");
        }
    }

    private boolean isStrongPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        if (password.length() < 5) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (Character.isUpperCase(symbol)) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(symbol)) {
                hasLowercase = true;
            }
            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit;
    }

    private String readPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password:");
        return sc.nextLine();
    }

    private void printErrorMessage() {
        System.out.println("Incorrect password!");
    }
}

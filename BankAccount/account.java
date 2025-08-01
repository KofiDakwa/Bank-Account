import java.util.Scanner;

public class account {
    double balance;
    String owner;
    String securityKey;
    boolean loginStatus;

    Scanner scanner = new Scanner(System.in);

    public account(double balance, String owner, String securityKey) {
        this.balance = balance;
        this.owner = owner;
        this.securityKey = securityKey;
        this.loginStatus = false;
    }

    public void login() {
        int remainingAttempts = 5;
        boolean loggedIn = false;

        while(remainingAttempts > 0 && !loggedIn) {
            System.out.println("\nPlease enter your Security Key: ");
            String input = scanner.nextLine();

            if (input.equals(this.securityKey)) {
                System.out.println("You have succesfully logged in.");
                loggedIn = true;
                this.loginStatus = true;
            }

            else{
                remainingAttempts -= 1;
                System.out.print("Incorrect Secuty Key. You have " + remainingAttempts + " attempts left.");
            }
        }
        if(remainingAttempts == 0) {
            System.out.println("You have ran out of attemps and are locked out of this account");
        }
    }

    public boolean returnLoginStatus() {
        return loginStatus;
    }

    public void display() {
        System.out.println("\nWelcome to your account, " + this.owner + "!");
        System.out.println("You have $" + this.balance + " dollars.");
        System.out.println("Please select one of the following options: ");
        System.out.println("withdraw, deposit, wire, change owners, change security key, log out");
    }

    public void withdraw() {
        System.out.println("\nHow much money would you like to withdraw?:");
        double amount = scanner.nextDouble();

        if (this.balance > amount) {
            this.balance -= amount;
            System.out.println("Withdraw Succesful");
        }

        else{
            System.out.println("Not enough cash to withdraw");
        }
    }

    public void deposit () {
        System.out.println("\nHow much money would you like to deposit?:");
        double amount = scanner.nextDouble();
        this.balance += amount;
        System.out.println("Deposit Successful");
    }

    public void changeOwner () {
        System.out.println("\nPlease input the name of the new owner:");
        this.owner = scanner.nextLine();
        System.out.println("You have successfully trasnferred ownership of this account to" + this.owner);
    }

    public void changeSecurityKey () {
        System.out.println("\nPlease input the new Security Key:");
        this.securityKey = scanner.nextLine();
        System.out.println("You have changed the Security Key to " + this.owner);
    }
}

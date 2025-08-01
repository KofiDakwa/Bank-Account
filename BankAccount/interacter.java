import java.util.Scanner;

public class interacter {
    Scanner scanner = new Scanner(System.in);
    account user = new account(0, "undefined", "undefined");
    boolean active = true;

    int state = 0;
    int home = 0;
    int depositing = 1;
    int withdrawing = 2;
    int changingOwner = 3;
    int changingSecurityKey = 4;


    public void createAccount() {
        System.out.println("Please enter your name below:");
        String name = scanner.nextLine();
        System.out.println("Please enter your security key below:");
        String securityKey = scanner.nextLine();

        user.balance = 0;
        user.owner = name;
        user.securityKey = securityKey;
    }

    public void interact() {
        if (user.returnLoginStatus()) {
            while(active) {
                switch(state) {

                    case 0:
                        System.out.println("Potato");
                        user.display();
                        System.out.println("Potato");
                        String request = scanner.nextLine();

                        switch(request) {
                            case "withdraw":
                                state = withdrawing;
                                break;
                            case "deposit":
                                state = depositing;
                                break;
                            case "change owners":
                                state = changingOwner;
                                break;
                            case "change security key":
                                state = changingSecurityKey;
                                break;
                            case "log out":
                                active = false;
                                break;
                            default:
                                System.out.println("\nThat is not a recognized command. Please try again");
                                break;
                        }

                        break;

                    case 1:
                        user.deposit();
                        state = home;
                        break;
                    case 2:
                        user.withdraw();
                        state = home;
                        break;
                    case 3:
                        user.changeOwner();
                        state = home;
                        break;
                    case 4:
                        user.changeSecurityKey();
                        state = home;
                        break;
                }
            }

            System.out.println("\nThank you for using our banking app!!");
        }
        else {
            System.out.println("\nPlease log in to your account.");
            user.login();
            this.interact();
        }
    }
}

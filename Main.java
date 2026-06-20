import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Delete Account");
            System.out.println("7. Transaction History");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    accounts.add(new BankAccount(name, accNo));

                    System.out.println("Account Created Successfully!");
                    break;

                case 2:

                    if(accounts.isEmpty()) {
                        System.out.println("No Accounts Found!");
                    } else {

                        for(BankAccount acc : accounts) {
                            acc.showDetails();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    int searchNo = sc.nextInt();

                    boolean found = false;

                    for(BankAccount acc : accounts) {

                        if(acc.getAccountNumber() == searchNo) {

                            acc.showDetails();
                            found = true;
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Account Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    int depNo = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depAmount = sc.nextDouble();

                    for(BankAccount acc : accounts) {

                        if(acc.getAccountNumber() == depNo) {
                            acc.deposit(depAmount);
                        }
                    }

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");
                    int withNo = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double withAmount = sc.nextDouble();

                    for(BankAccount acc : accounts) {

                        if(acc.getAccountNumber() == withNo) {
                            acc.withdraw(withAmount);
                        }
                    }

                    break;

                case 6:

                    System.out.print("Enter Account Number to Delete: ");
                    int deleteNo = sc.nextInt();

                    boolean removed = false;

                    for(int i = 0; i < accounts.size(); i++) {

                        if(accounts.get(i).getAccountNumber() == deleteNo) {

                            accounts.remove(i);
                            removed = true;

                            System.out.println("Account Deleted Successfully!");
                            break;
                        }
                    }

                    if(!removed) {
                        System.out.println("Account Not Found!");
                    }

                    break;

                case 7:

                    System.out.print("Enter Account Number: ");
                    int histNo = sc.nextInt();

                    boolean historyFound = false;

                    for(BankAccount acc : accounts) {

                        if(acc.getAccountNumber() == histNo) {

                            acc.showHistory();
                            historyFound = true;
                            break;
                        }
                    }

                    if(!historyFound) {
                        System.out.println("Account Not Found!");
                    }

                    break;

                case 8:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 8);

        sc.close();
    }
}
public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;
    private String history = "";

    public BankAccount(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
        history += "Deposited: " + amount + "\n";
        System.out.println("Deposited Successfully!");
    }

    public void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            history += "Withdrawn: " + amount + "\n";
            System.out.println("Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showHistory() {
        System.out.println("\n===== TRANSACTION HISTORY =====");

        if(history.isEmpty()){
            System.out.println("No Transactions Yet!");
        } else {
            System.out.println(history);
        }
    }

    public void showDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Name: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
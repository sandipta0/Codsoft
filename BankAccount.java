package atminterface;
import java.util.Scanner;

public class BankAccount {
    Scanner sc=new Scanner(System.in);
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit() {
        double amount=sc.nextFloat();
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Kindly enter a positive number.");
        }
    }

    public void withdraw() {
        double amount=sc.nextFloat();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw Successfully: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your balance is: $" + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public static void main(String[] args) {
        
        BankAccount account = new BankAccount(500);
        account.deposit();
        account.withdraw();
        account.withdraw(); 
        System.out.println("Final Amount: $" + account.getBalance());
    }
}

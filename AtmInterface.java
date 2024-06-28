package atminterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmInterface {
    private BankAccount account;

    public AtmInterface(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit();
    }

    public void withdraw(double amount) {
        account.withdraw();
    }

    public void checkBalance() {
        System.out.println("Current balance is: $" + account.getBalance());
    }

    private void displayMenu() {
        System.out.println("\nWelcome to the ATM");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
        System.out.print("Kindly choose an option: ");
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Minimum balance is 1000
        AtmInterface atm = new AtmInterface(userAccount);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            atm.displayMenu();
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        atm.handleDeposit(scanner);
                        break;
                    case 2:
                        atm.handleWithdraw(scanner);
                        break;
                    case 3:
                        atm.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        } while (choice != 4);

        scanner.close();
    }

    private void handleDeposit(Scanner scanner) {
        try {
            System.out.print("Enter the amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            if (depositAmount > 0) {
                deposit(depositAmount);
            } else {
                System.out.println("Deposit failed.Enter a positive number.");
            }
        } catch (InputMismatchException e) {
            // Clear the invalid input
            System.out.println("Invalid input. Please enter a number value.");
            scanner.next(); 
        }
    }

    private void handleWithdraw(Scanner scanner) {
        try {
            System.out.print("Enter amount for to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            if (withdrawAmount > 0 && withdrawAmount <= account.getBalance()) {
                withdraw(withdrawAmount);
            } else if (withdrawAmount > account.getBalance()) {
                System.out.println("Withdrawal failed. Insufficient balance. Your balance is: $" + account.getBalance());
            } else {
                System.out.println("Withdrawal failed. Enter a positive number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number value.");
            scanner.next(); 
        }
    }
}

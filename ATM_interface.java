import java.util.Scanner;
import java.util.ArrayList;

public class ATM_interface {
    private static Scanner input = new Scanner(System.in);
    private static double balance = 1000.0;
    private static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer money");
            System.out.println("5. Transaction history");
            System.out.println("6. Exit");
            System.out.print("Enter an option: ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 6);
    }

    private static void checkBalance() {
        System.out.println("Your balance is $" + balance);
    }

    private static void withdraw() {
        System.out.print("Enter an amount to withdraw: $");
        double amount = input.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdrawn: $" + amount);
            System.out.println("Withdrawal successful.");
        }
    }

    private static void deposit() {
        System.out.print("Enter an amount to deposit: $");
        double amount = input.nextDouble();
        balance += amount;
        transactions.add("Deposited: $" + amount);
        System.out.println("Deposit successful.");
    }

    private static void transferMoney() {
        System.out.print("Enter an amount to transfer: $");
        double amount = input.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Transferred: $" + amount);
            System.out.println("Transfer successful.");
        }
    }

    private static void showTransactionHistory() {
        System.out.println("Transaction history:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

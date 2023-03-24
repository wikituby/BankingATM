package bankingatmapp;

import java.util.Scanner;

public class ATM {
    private int balance;
    private int accountNumber;
    private int pinNumber;

    public ATM(int balance, int accountNumber, int pinNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn. Current balance: $" + balance);
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited. Current balance: $" + balance);
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public boolean login(int accountNumber, int pinNumber) {
        if (accountNumber == this.accountNumber && pinNumber == this.pinNumber) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM atm = new ATM(1000, 123456, 1234);

        System.out.println("Welcome to the ATM. Please enter your account number and pin number.");
        int accountNumber = input.nextInt();
        int pinNumber = input.nextInt();

        if (atm.login(accountNumber, pinNumber)) {
            System.out.println("Login successful. What would you like to do?");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw:");
                    int withdrawAmount = input.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    int depositAmount = input.nextInt();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid account number or pin number.");
        }
    }
}


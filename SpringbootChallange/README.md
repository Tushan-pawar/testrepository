# SocietyManagement
1. Account Class: Create a class called `Account` that represents a bank account. It should have the following attributes: - `accountNumber` (String) - `accountHolderName` (String) - `balance` (double) Include a constructor to initialize these attributes and methods for: - `deposit(double amount)`: Add the specified amount to the balance. - `withdraw(double amount)`: Deduct the specified amount from the balance. - `getBalance()`: Return the current balance. 

2. Transaction Class: Create a class called `Transaction` to represent a transaction. It should have the following attributes: - `transactionId` (int) - `sourceAccount` (Account) - `destinationAccount` (Account) - `amount` (double) Include a constructor to initialize these attributes and a method for performing the transaction: - `executeTransaction()`: Transfer the specified amount from the source account to the destination account. Update the balances of both accounts.

 3. Main Program: Write a simple program that demonstrates functionality. Create two `Account` objects and perform the following operations: - Deposit some initial amount into each account. - Display the balances. - Create a `Transaction` object and execute a transfer between the two accounts. - Display the updated balances after the transaction.








// Define the Account class with fields for account number, holder name, and balance
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize account details
    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to get the current balance of the account
    public double getBalance() {
        return balance;
    }
}

// Define the Transaction class with fields for transaction ID, source and destination accounts, and amount
class Transaction {
    private int transactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;

    // Constructor to initialize transaction details
    public Transaction(int transactionId, Account sourceAccount, Account destinationAccount, double amount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    // Method to execute the transaction by transferring money from source to destination account
    public void executeTransaction() {
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
            System.out.println("Transaction successful.");
        } else {
            System.out.println("Transaction failed due to insufficient balance.");
        }
    }
}

// Main class to demonstrate the functionality of Account and Transaction classes
public class Main {
    public static void main(String[] args) {
        // Create two accounts
        Account account1 = new Account("123456789", "John Doe", 1000.0);
        Account account2 = new Account("987654321", "Jane Smith", 500.0);

        // Deposit initial amounts
        account1.deposit(500.0);
        account2.deposit(200.0);

        // Display balances
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

        // Create a transaction and execute transfer
        Transaction transaction = new Transaction(1, account1, account2, 300.0);
        transaction.executeTransaction();

        // Display updated balances after the transaction
        System.out.println("Updated Account 1 balance: " + account1.getBalance());
        System.out.println("Updated Account 2 balance: " + account2.getBalance());
    }
}

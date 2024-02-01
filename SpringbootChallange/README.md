# SocietyManagement
1. Account Class: Create a class called `Account` that represents a bank account. It should have the following attributes: - `accountNumber` (String) - `accountHolderName` (String) - `balance` (double) Include a constructor to initialize these attributes and methods for: - `deposit(double amount)`: Add the specified amount to the balance. - `withdraw(double amount)`: Deduct the specified amount from the balance. - `getBalance()`: Return the current balance. 

2. Transaction Class: Create a class called `Transaction` to represent a transaction. It should have the following attributes: - `transactionId` (int) - `sourceAccount` (Account) - `destinationAccount` (Account) - `amount` (double) Include a constructor to initialize these attributes and a method for performing the transaction: - `executeTransaction()`: Transfer the specified amount from the source account to the destination account. Update the balances of both accounts.

 3. Main Program: Write a simple program that demonstrates functionality. Create two `Account` objects and perform the following operations: - Deposit some initial amount into each account. - Display the balances. - Create a `Transaction` object and execute a transfer between the two accounts. - Display the updated balances after the transaction.






class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;


   public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
   public void deposit(double amount) {
        balance = balance+amount;
    }

 
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance =balance-amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Transaction {
    private int transactionId;
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;


    public Transaction(int transactionId, Account sourceAccount, Account destinationAccount, double amount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }


    public void runTransaction() {
        if (sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            destinationAccount.deposit(amount);
        } else {
            System.out.println("Transaction failed due to insufficient balance.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account("234", "Mahesh", 932);
        Account account2 = new Account("654", "Suresh", 777);

        account1.deposit(500.0);
        account2.deposit(200.0);
        
        System.out.println("Balance of first account is : " + account1.getBalance());
        System.out.println("Balance of second account is: " + account2.getBalance());

        
        Transaction transaction = new Transaction(1, account1, account2, 370.0);
        transaction.runTransaction();

        System.out.println("First account new Balance is: " + account1.getBalance());
        System.out.println("Second account new Balance is: " + account2.getBalance());
    }

}

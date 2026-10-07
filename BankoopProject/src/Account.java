public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: Amount must be greater than zero.");
            return;
        }
        this.balance += amount;
        System.out.printf("Account %s: Deposited $%.2f. New Balance: $%.2f%n", accountNumber, amount, balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public abstract boolean withdraw(double amount);
    public abstract void endOfMonth();
}
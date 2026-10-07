public class SavingsAccount extends Account {
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be greater than zero.");
            return false;
        }
        // Prevents balance from dropping below the minimum limit
        if (balance - amount < minimumBalance) {
            System.out.printf("REJECTED [SavingsAccount %s]: Withdrawal of $%.2f would violate minimum balance limit of $%.2f (Current balance: $%.2f)%n",
                    accountNumber, amount, minimumBalance, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("SavingsAccount %s: Withdrew $%.2f. New Balance: $%.2f%n", accountNumber, amount, balance);
        return true;
    }

    @Override
    public void endOfMonth() {
        double interestEarned = balance * interestRate;
        balance += interestEarned;
        System.out.printf("SavingsAccount %s: End of month. Interest added: $%.2f. New Balance: $%.2f%n", accountNumber, interestEarned, balance);
    }
}
public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double maintenanceFee;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit, double maintenanceFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be greater than zero.");
            return false;
        }
        // Allows negative balance up to the overdraft limit
        if (balance - amount < -overdraftLimit) {
            System.out.printf("REJECTED [CurrentAccount %s]: Withdrawal of $%.2f exceeds overdraft limit of $%.2f (Current balance: $%.2f)%n",
                    accountNumber, amount, overdraftLimit, balance);
            return false;
        }
        balance -= amount;
        System.out.printf("CurrentAccount %s: Withdrew $%.2f. New Balance: $%.2f%n", accountNumber, amount, balance);
        return true;
    }

    @Override
    public void endOfMonth() {
        balance -= maintenanceFee;
        System.out.printf("CurrentAccount %s: End of month. Fee deducted: $%.2f. New Balance: $%.2f%n", accountNumber, maintenanceFee, balance);
    }
}
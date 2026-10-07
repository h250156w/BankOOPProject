import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        // Instantiate accounts
        SavingsAccount savings = new SavingsAccount("SA-1001", 500.00, 100.00, 0.05);
        CurrentAccount current = new CurrentAccount("CA-2001", 200.00, 500.00, 15.00);

        System.out.println("==================================================");
        System.out.println(" DEMONSTRATING SPECIFIC ACCOUNT EDGE CASES");
        System.out.println("==================================================");

        // Edge Case 1: SavingsAccount withdrawal rejection (500 - 450 = 50 < 100 minimum)
        System.out.println("\n--- Edge Case 1: Rejected Savings Withdrawal ---");
        savings.withdraw(450.00);

        // Edge Case 2: CurrentAccount going into overdraft within limit (200 - 400 = -200 >= -500 limit)
        System.out.println("\n--- Edge Case 2: Valid Current Overdraft Withdrawal ---");
        current.withdraw(400.00);

        System.out.println("\n==================================================");
        System.out.println(" POLYMORPHIC LOOP (List<Account>)");
        System.out.println("==================================================");

        // Upcast accounts to standard Account references
        List<Account> accountList = new ArrayList<>();
        accountList.add(savings);
        accountList.add(current);

        // Loop through the list calling methods through the parent reference
        for (Account acc : accountList) {
            System.out.println("\nProcessing Account: " + acc.getAccountNumber());
            acc.withdraw(30.00);
            acc.endOfMonth();
        }
    }
}
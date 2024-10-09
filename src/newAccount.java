import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class newAccount extends Account {
    private String name;
    private List<Transaction> transactions;

    public newAccount(int id, double balance, String name) {
        super(id, balance);
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        transactions.add(new Transaction('W', amount, getBalance(), "Withdrawal"));
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions.add(new Transaction('D', amount, getBalance(), "Deposit"));
    }

    public void displayAccountSummary() {
        System.out.println("Account Summary for " + name);
        System.out.println("Annual Interest Rate: " + getAnnualInterestRate() + "%");
        System.out.println("Balance: " + getBalance() + " руб.");
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
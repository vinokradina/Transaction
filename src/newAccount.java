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
        transactions.add(new Transaction('W', amount, getBalance(), "Снятие"));
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions.add(new Transaction('D', amount, getBalance(), "Пополнение"));
    }

    public void displayAccountSummary() {
        System.out.println("Информация по счету для " + name);
        System.out.println("Годовая процентная ставка: " + getAnnualInterestRate() + "%");
        System.out.println("Баланс: " + getBalance() + " руб.");
        System.out.println("Транзакции:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private String name;
    private List<Transaction> transactions;
    private static List<Account> accounts = new ArrayList<>();
    private Date dateCreated;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public Account(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.transactions = new ArrayList<>();
        this.dateCreated = Date.from(Instant.now());
        accounts.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterest() {
        return annualInterestRate / 100 / 12;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdrawal"));
            System.out.println("Сумма снята со счета!");
        } else {
            System.out.println("Недостаточно средств на счёте.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit"));
        System.out.println("Депозит успешно введен!");
    }

    public static Account findAccountById(List<Account> accounts, int id) throws IllegalArgumentException {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new IllegalArgumentException("Счета с таким id не найден!");
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void displayAccountSummary() {
        System.out.println("Account Summary for " + name);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Balance: " + balance + " руб.");
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
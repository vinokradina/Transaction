import javax.swing.*;
import java.util.Scanner;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Account first = new Account(1,10000);
        Account second = new Account(2,10000);
        Account third = new Account(3,10000);
        Account fourth = new Account(4,10000);
        Account fifth = new Account(5,10000);
        Account sixth = new Account(6,10000);
        Account seventh = new Account(7,10000);
        Account eighth = new Account(8,10000);
        Account ninth = new Account(9,10000);
        Account tenth = new Account(10,10000);

        Account account = new Account(1155, 300000);
        account.setAnnualInterestRate(650);
        account.withdraw(16500);
        account.deposit(50000);
        System.out.println("===================================================");
        System.out.println("Номер счета : " + account.getId());
        System.out.println("Баланс : " + account.getBalance());
        System.out.println("Месячная ставка : " + account.getMonthlyInterest());
        System.out.println("Дата создания : " + account.getDateCreated());

        System.out.println("===================================================");


        newAccount acc = new newAccount(1233, 1100, "Семен");
        acc.setAnnualInterestRate(7.5);

        acc.deposit(500);
        acc.deposit(600);
        acc.deposit(700);

        acc.withdraw(700);
        acc.withdraw(600);
        acc.withdraw(100);

        acc.displayAccountSummary();
        System.out.println("===================================================");

        while (true) {

            while (true) {
                try {
                    System.out.println("Введите ID счета: ");
                    int id;
                    id = in.nextInt();
                    Account currentAccount = Account.findAccountById(Account.getAccounts(), id);

                    // Show the main menu
                    boolean exitMenu = false;
                    while (!exitMenu) {
                        System.out.println("Основное меню\n1: Проверить баланс счета\n2: Снять со счета\n3: Положить на счет\n4: Выйти");
                        int choice = in.nextInt();

                        switch (choice) {
                            case 1: // Проверка баланса
                                System.out.printf("Баланс счета %d: %.2f\n", id, currentAccount.getBalance());
                                break;
                            case 2: // Снятие со счета
                                System.out.println("Введите сумму для снятия:");
                                double amountWithdraw = in.nextDouble();
                                currentAccount.withdraw(amountWithdraw);
                                break;
                            case 3: // Пополнение счета
                                System.out.println("Введите сумму для пополнения:");
                                double amountDeposit = in.nextDouble();
                                currentAccount.deposit(amountDeposit);
                                break;
                            case 4: // Выход из меню
                                exitMenu = true;
                                break;
                            default:
                                System.out.println("Неверная команда! Пожалуйста, выберите 1, 2, 3 или 4.");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Попробуйте еще раз.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Введите корректный ID!");
                    in.next();
                }
            }
        }


    }
}





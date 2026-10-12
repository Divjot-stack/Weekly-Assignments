import java.util.Scanner;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class CardPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }
}

public class PaymentSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransfer();
                    break;
                default:
                    continue;
            }

            double adjustedAmount = payment.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
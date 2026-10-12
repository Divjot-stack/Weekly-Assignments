import java.util.*;
import java.util.function.Function;

interface Customer {
    double calculateAmount(double amount);
}

class Student implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    public double calculateAmount(double amount) {
        return amount + 10;
    }
}

public class CanteenBillingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Function<Double, Customer>> customers = new HashMap<>();

        customers.put("STUDENT", amount -> new Student());
        customers.put("STAFF", amount -> new Staff());
        customers.put("GUEST", amount -> new Guest());

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = customers.get(type).apply(amount);
            double finalAmount = customer.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10.0;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20.0;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        return Math.max(hours * 50.0, 100.0);
    }
}

public class ParkingChargeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike();
                    break;
                case "CAR":
                    vehicle = new Car();
                    break;
                case "TRUCK":
                    vehicle = new Truck();
                    break;
                default:
                    continue;
            }

            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

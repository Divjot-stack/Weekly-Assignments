import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    abstract int getValidityDays();

    LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan();
                    break;

                case "STANDARD":
                    plan = new StandardPlan();
                    break;

                case "PREMIUM":
                    plan = new PremiumPlan();
                    break;

                default:
                    continue;
            }

            LocalDate renewalDate = plan.calculateRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
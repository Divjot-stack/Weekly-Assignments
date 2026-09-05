import java.util.*;

public class RockPaperScissors {

    static String playRound(String p, String c) {
        if (p.equalsIgnoreCase(c))
            return "Draw";

        if ((p.equalsIgnoreCase("Rock") && c.equals("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equals("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.print("Round " + i + " - Enter move: ");
            String player = sc.next();

            String computer = moves[r.nextInt(3)];
            String result = playRound(player, computer);

            System.out.println("Computer: " + computer);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double winPercent = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercent);

        sc.close();
    }
}
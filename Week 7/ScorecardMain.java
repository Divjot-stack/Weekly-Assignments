class Scorecard {
private final boolean[] results;
private int count;
private int score;

public Scorecard(int totalQuestions) {
    results = new boolean[totalQuestions];
    count = 0;
    score = 0;
}

public void recordAnswer(boolean correct) {
    if (count < results.length) {
        results[count] = correct;

        if (correct) {
            score++;
        }

        count++;
    } else {
        System.out.println("All answers have been recorded");
    }
}

public int getScore() {
    return score;
}

}

public class ScorecardMain {
public static void main(String[] args) {
Scorecard sc = new Scorecard(4);

    sc.recordAnswer(true);
    sc.recordAnswer(true);
    sc.recordAnswer(false);
    sc.recordAnswer(true);

    System.out.println("Final Score: " + sc.getScore());
}

}
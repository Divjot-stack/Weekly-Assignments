import java.util.*;
import java.util.regex.*;

interface QuestionGrader {
    double grade(String correctAnswer, String studentAnswer, double points);
}

class MCQGrader implements QuestionGrader {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TrueFalseGrader implements QuestionGrader {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayGrader implements QuestionGrader {
    public double grade(String correctAnswer, String studentAnswer, double points) {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGraderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Map<String, QuestionGrader> graders = new HashMap<>();
        graders.put("MCQ", new MCQGrader());
        graders.put("TF", new TrueFalseGrader());
        graders.put("ESSAY", new EssayGrader());

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group(1) != null
                        ? matcher.group(1)
                        : matcher.group(2));
            }

            String type = values.get(0);
            String correctAnswer = values.get(2);
            String studentAnswer = values.get(3);
            double points = Double.parseDouble(values.get(4));

            QuestionGrader grader = graders.get(type);

            double score = grader.grade(correctAnswer, studentAnswer, points);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
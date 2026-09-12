import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine implements Comparable<FantasyLeagueAutoDraftRankingEngine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyLeagueAutoDraftRankingEngine(String name, int matchesPlayed,
                                               double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    private double fantasyPoints() {
        return matchesPlayed * battingAverage;
    }

    @Override
    public int compareTo(FantasyLeagueAutoDraftRankingEngine other) {
        return Double.compare(other.fantasyPoints(), this.fantasyPoints());
    }

    static String draftAndRank(FantasyLeagueAutoDraftRankingEngine[] players) {

        FantasyLeagueAutoDraftRankingEngine[] draftable =
                new FantasyLeagueAutoDraftRankingEngine[players.length];

        int count = 0;

        for (FantasyLeagueAutoDraftRankingEngine player : players) {
            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed, player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {
            result += (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyLeagueAutoDraftRankingEngine[] players = {
            new FantasyLeagueAutoDraftRankingEngine("Virat", 15, 48.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Rahul", 7, 55.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Sameer", 3, 60.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
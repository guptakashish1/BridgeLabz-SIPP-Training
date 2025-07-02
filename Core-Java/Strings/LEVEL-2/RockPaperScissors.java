import java.util.Scanner;

public class RockPaperScissors {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if (user.equals("rock") && computer.equals("scissors")) return "user";
        if (user.equals("paper") && computer.equals("rock")) return "user";
        if (user.equals("scissors") && computer.equals("paper")) return "user";
        return "computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][3];
        stats[0][0] = "User Wins";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", (userWins * 100.0) / totalGames) + "%";

        stats[1][0] = "Computer Wins";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / totalGames) + "%";

        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / totalGames) + "%";

        return stats;
    }

    public static void displayResults(String[][] games, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tResult");
        for (int i = 0; i < games.length; i++) {
            System.out.println((i+1) + "\t" + games[i][0] + "\t" + games[i][1] + "\t\t" + games[i][2]);
        }
        System.out.println("\nStats:");
        System.out.println("Type\t\tCount\tPercentage");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, computerWins = 0, draws = 0;

        System.out.print("Enter number of games: ");
        int totalGames = sc.nextInt();
        String[][] games = new String[totalGames][3];

        for (int i = 0; i < totalGames; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.next().toLowerCase();
            String compChoice = getComputerChoice();
            String winner = getWinner(userChoice, compChoice);

            if (winner.equals("user")) userWins++;
            else if (winner.equals("computer")) computerWins++;
            else draws++;

            games[i][0] = userChoice;
            games[i][1] = compChoice;
            games[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, totalGames);
        displayResults(games, stats);
        sc.close();
    }
}

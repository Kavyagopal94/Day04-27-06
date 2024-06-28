package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
//UC3

class SnakeAndLadderGame {
    private static final int WINNING_POSITION = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private int player1Position;
    private int player2Position;
    private Random random;

    public SnakeAndLadderGame() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        random = new Random();
        player1Position = 0;
        player2Position = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        // Snakes
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        // Ladders
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    private String checkOption() {
        int option = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
        switch (option) {
            case 0:
                return "No Play";
            case 1:
                return "Ladder";
            case 2:
                return "Snake";
        }
        return "No Play"; // Default case, should never hit this
    }

    private int movePlayer(int position, int roll, String option) {
        switch (option) {
            case "No Play":
                System.out.println("No Play. Staying in the same position.");
                break;
            case "Ladder":
                position += roll;
                System.out.println("Ladder! Moving ahead by " + roll + " positions.");
                break;
            case "Snake":
                position -= roll;
                System.out.println("Snake! Moving behind by " + roll + " positions.");
                break;
        }

        if (position < 0) {
            position = 0; // Ensuring position does not go below 0
        } else if (position > WINNING_POSITION) {
            position -= roll; // Stay in the same position if the roll exceeds 100
        } else if (snakes.containsKey(position)) {
            position = snakes.get(position);
            System.out.println("Oops! Hit a snake, slide down to " + position);
        } else if (ladders.containsKey(position)) {
            position = ladders.get(position);
            System.out.println("Yay! Climbed a ladder to " + position);
        }

        return position;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean player1Turn = true;

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            System.out.println((player1Turn ? "Player 1" : "Player 2") + "'s turn. Press Enter to roll the dice...");
            scanner.nextLine();

            int roll = rollDice();
            String option = checkOption();
            System.out.println("Rolled: " + roll);
            System.out.println("Option: " + option);

            if (player1Turn) {
                player1Position = movePlayer(player1Position, roll, option);
                System.out.println("Player 1's new position: " + player1Position);
                if (player1Position == WINNING_POSITION) {
                    System.out.println("Player 1 wins!");
                    break;
                }
            } else {
                player2Position = movePlayer(player2Position, roll, option);
                System.out.println("Player 2's new position: " + player2Position);
                if (player2Position == WINNING_POSITION) {
                    System.out.println("Player 2 wins!");
                    break;
                }
            }

            player1Turn = !player1Turn;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.play();
    }
}

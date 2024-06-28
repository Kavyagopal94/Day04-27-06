package basics;
import java.util.Random;

public class SnakeAndLadder {
    static final int WINNING_POSITION = 100;

    public static void main(String[] args) {
        int player1Position = 0;
        int player2Position = 0;
        int diceRollsPlayer1 = 0;
        int diceRollsPlayer2 = 0;

        Random random = new Random();

        boolean isPlayer1Turn = true;
        
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            if (isPlayer1Turn) {
                int diceRoll = rollDice(random);
                diceRollsPlayer1++;//diceRoll count
                player1Position = movePlayer(player1Position, diceRoll, random);//CurrentPlayerPosition,DiceRoll_value,Option(NOplay,Ladder,Snake)
                System.out.println("Player 1 rolls " + diceRoll + " and moves to position " + player1Position);
                if (player1Position == WINNING_POSITION) break;
                if (isLadder()) {
                    continue; // Player 1 gets another turn
                }
            } 
            else {
                int diceRoll = rollDice(random);
                diceRollsPlayer2++;//diceRoll count
                player2Position = movePlayer(player2Position, diceRoll, random);
                System.out.println("Player 2 rolls " + diceRoll + " and moves to position " + player2Position);
                if (player2Position == WINNING_POSITION) break;
                if (isLadder()) {
                    continue; // Player 2 gets another turn
                }
            }
            isPlayer1Turn = !isPlayer1Turn;
        }

        if (player1Position == WINNING_POSITION) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Player 2 wins the game!");
        }

        System.out.println("Player 1 rolled the dice " + diceRollsPlayer1 + " times.");//NOofTIMESdiceROLLED
        System.out.println("Player 2 rolled the dice " + diceRollsPlayer2 + " times.");//NOofTIMESdiceROLLED
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }

    private static int movePlayer(int position, int diceRoll, Random random) {
        int option = random.nextInt(3); // 0: No Play, 1: Ladder, 2: Snake
        switch (option) {
            case 0:
                // No Play, position stays the same
                break;
            case 1:
                // Ladder, move ahead
                position += diceRoll;
                break;
            case 2:
                // Snake, move behind
                position -= diceRoll;
                if (position < 0) {
                    position = 0;
                }
                break;
        }
        if (position > WINNING_POSITION) {
            position -= diceRoll; 
        }
        return position;
    }

    private static boolean isLadder() {
        return new Random().nextInt(3) == 1;
    }
}

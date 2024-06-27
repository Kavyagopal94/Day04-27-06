import java.util.Random;

public class SnakeAndLadder {

    public static void main(String[] args) {
        int position = 0, c = 0;
        Random random = new Random();

        while (position < 100) {
            
            int diceRoll = random.nextInt(6) + 1;
            System.out.println("Rolled: " + diceRoll);
            c++;
            System.out.println("Number of Times Rolled: " + c);
            
            int option = random.nextInt(3);
            switch (option) {
                case 0:
                    // No Play
                    System.out.println("No Play. Stay in the same position.");
                    break;
                    
                case 1:
                    // Ladder
                    position += diceRoll;
                    if(position > 100)
                    {
                    	position -= position;
                    }
                    System.out.println("Ladder! Move ahead by " + diceRoll + " positions.");
                    break;
                    
                case 2:
                    // Snake
                    position -= diceRoll;
                    if (position < 0) 
                    {
                        position = 0;
                    }
                    System.out.println("Snake! Move behind by " + diceRoll + " positions.");
                    break;
            }

            System.out.println("Player position: " + position);
            System.out.println("-------------------------");

            if (position == 100) {
                System.out.println("Congratulations! You've reached the winning position!");
                break;
            }
        }
    }
}

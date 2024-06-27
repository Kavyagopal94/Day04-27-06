
import java.util.Random;

public class SnakeAndLadderGame
{
    private static final int WINNING_POSITION = 100;
    private static final int[] SNAKES = new int[101];
    private static final int[] LADDERS = new int[101];

    static
    {
        SNAKES[16] = 6;
        SNAKES[47] = 26;
        SNAKES[56] = 53;
        SNAKES[64] = 60;
        SNAKES[87] = 24;
        SNAKES[98] = 78;
        
        LADDERS[1] = 38;
        LADDERS[21] = 42;
        LADDERS[36] = 44;
        LADDERS[51] = 67;
        LADDERS[71] = 91;
        LADDERS[80] = 100;
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int position = 0;

        while (position < WINNING_POSITION)
        {
            int dice = random.nextInt(7);//0 to 6
            position = position + dice;

            if (position > WINNING_POSITION) 
            {
                position = position + dice;
                continue;
            }

            if (SNAKES[position] != 0)
            {
                position = SNAKES[position];
            } 
            else if (LADDERS[position] != 0)
            {
                position = LADDERS[position];
            }

            System.out.println("Dice: " + dice + ", Position: " + position);
        }

        System.out.println("Congratulations! You reached the winning position.");
    }
}

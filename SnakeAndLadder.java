import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadder 
{
    static final Map<Integer, Integer> ladders = new HashMap<>();
    static final Map<Integer, Integer> snakes = new HashMap<>();
    
    static
    {
        ladders.put(2, 23);
        ladders.put(6, 45);
        ladders.put(20, 59);
        ladders.put(52, 72);
        ladders.put(57, 96);
        ladders.put(71, 92);
        
        snakes.put(43, 17);
        snakes.put(50, 5);
        snakes.put(56, 8);
        snakes.put(73, 15);
        snakes.put(84, 58);
        snakes.put(87, 49);
        snakes.put(98, 64);
    }

    public static void main(String[] args) 
    {
        int position = 0;
        Random random = new Random();
        
        while (position < 100)
        {
            int diceRoll = random.nextInt(6) + 1;
            position = position + diceRoll;
           
            if (ladders.containsKey(position))
            {
                System.out.println("Ladder! Climb up from " + position + " to " + ladders.get(position));
                position = ladders.get(position);
            }
          
            else if (snakes.containsKey(position))
            {
                System.out.println("Snake! Slide down from " + position + " to " + snakes.get(position));
                position = snakes.get(position);
            }
            
            if (position > 100)
            {
                position = position - diceRoll; 
            }
            
            System.out.println("Rolled a " + diceRoll + ", moved to position " + position);
            
            if (position == 100) 
            {
                System.out.println("Congratulations! You've won the game!");
            }
        }
    }
}

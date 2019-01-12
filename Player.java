
/**
 * Player class describes the player. Includes adding/subtracting/getting points. 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private int points; 
    private int tossRight;
    private int tossWrong;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        points = 0;
        tossRight = 0;
        tossWrong = 0;
    }
    
    /**
     * Method adds 10 points to the player's total amount of points if player gets the question correct.
     */
    public void addPoints()
    {
        points += 10;
    }
    
    /**
     * Method deducts 5 points from player's total amount of points if player gets the question wrong or timer is up. 
     */
    public void deductPoints()
    {
        points -= 5;
    }
    
    /**
     * Getter method allows access to the amount of points the player currently has. 
     */
    public int getPoints()
    {
        return points;
    }
   
    /**
     * Method adds to how many toss-ups the player has answered correctly.
     */
    public void tossRight()
    {
        tossRight++;
    }
    
    /**
     * Method adds to how many toss-ups the player has answered incorrectly.
     */
    public void tossWrong()
    {
        tossWrong++;
    }
    
    /**
     * Getter method allows access to the amount of toss-ups the player has answered correctly.
     */
    public int getTossRight()
    {
        return tossRight;
    }
    
    /**
     * Getter method allows access to the amount of toss-ups the player has answered incorrectly.
     */
    public int getTossWrong()
    {
        return tossWrong;
    }
}

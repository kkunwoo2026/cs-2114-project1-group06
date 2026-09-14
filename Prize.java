import java.util.Random;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Armaan Ali (amali052024)
//
// LLM Statement:
// I have not used any assistance for the assignment beyond course 
// resources and staff.

/**
 *  This is the class that stores what the prizes for each item are. The prizes
 *  would give you money back. Prizes can take up multiple places too and can
 *  hold a percentage. 
 * 
 *  @author Armaan
 *  @version Sep 14, 2026
 */

public class Prize
{
  //~ Fields ................................................................
    private int xCoord;
    private int yCoord;
    private int percentage;
    
//~ Constructors ..........................................................

//~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Prize object.
     * @param xCoord for the x coordinate of the prize class. 
     * @param yCoord for the y coordinate of the prize class. 
     * @param percentage for the percentages of the items. 
     */
    public void setPrize(int xCoord, int yCoord, int percentage)
    {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.percentage = percentage;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return the x coordinate for the prize.
     */
    public int getXCoord()
    {
        return xCoord;
    }
    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return the y coordinate for the prize.
     */
    public int getYCoord()
    {
        return yCoord;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param min for the minimum number
     * @param max for the maximum number
     * @return the number for percentage
     */
    // ----------------------------------------------------------
    // ----------------------------------------------------------
    public int generateRandomNumber(int min, int max)
    {
        Random rand =  new Random();
        this.percentage = rand.nextInt((max - min) + 1) + min; 
        return percentage;
    }
    /**
     * Getting the percentage of the item. 
     * @return percentage of the item. 
     */
    public int getPercentage()
    {
        return this.generateRandomNumber(1,100);
    }
    
    

}

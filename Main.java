// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Armaan Ali (amali052024), Jonathan Elliott (ejonathan25), Kunwoo Kim ()
//
// LLM Statement: ******
// I have not used any assistance for the assignment beyond course 
// resources and staff.

/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jonathan, Armaan, Kunwoo
 *  @version Sep 14, 2026
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main
{
    
  //~ Fields ................................................................
    private List<Prize> prizeList = new ArrayList<>();
    private Claw claw;
    
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * The main game
     */
    public void main()
    {
        boolean roundRun = true;
        Scanner userInput = new Scanner(System.in);
        
        this.setPrizeList();
        this.setClaw();
        //puts claw on prize for testing
        claw.setX(prizeList.get(0).getXCoord());
        claw.setY(prizeList.get(0).getYCoord());
        
        
        //gets prize and claw coords for testing
        System.out.println(prizeList.get(0).getXCoord());
        System.out.println(prizeList.get(0).getYCoord());
        System.out.println(claw.getX());
        System.out.println(claw.getY());
        
        /**
         * runs the rounds till prize or miss
         */
        while (roundRun)
        {
            System.out.print("Test: Enter command: ");
            String userInputString = userInput.nextLine();
            System.out.println(userInputString);
            
            
            //handles the claw picking up
            if (userInputString.equals(" "))
            {
                roundRun = false;
                if (hasPrize()) {
                    System.out.print("Hit! ");
                    
                }
            }
            this.getClaw().move(userInputString);
        }           
    }
    
    /**
     * creates the prizes and the list of them
     */
    public List<Prize> prizeListCreation()
    {
        List<Prize> prizes = new ArrayList<>();
        Prize prize1 = new Prize();
        prize1.setPrize(generateRandomNumber(0, 4), generateRandomNumber(0, 4));
        prizes.add(prize1);
        Prize prize2 = new Prize();
        prize2.setPrize(generateRandomNumber(0, 4), generateRandomNumber(0, 4));
        prizes.add(prize2);
        Prize prize3 = new Prize();
        prize3.setPrize(generateRandomNumber(0, 4), generateRandomNumber(0, 4));
        prizes.add(prize3);
        
        for (int i = 0; i < prizes.size(); i++)
        {
            for (int j = i + 1; j < prizes.size(); j++)
            {
                while (prizes.get(i).equals(prizes.get(j)))
                {
                    prizes.set(j, new Prize());
                }
            }
        }
        return prizes;
    }
    
    /**
     * checks if prize is where claw is
     * @return boolean returns if prize is where claw is
     */
    public boolean hasPrize()
    {
        boolean isPrizeHere = false;
        for (int i = 0; i < this.getPrizeList().size(); i++)
        {
            if (this.getPrizeList().get(i).getXCoord() == claw.getX())
            {
                if (this.getPrizeList().get(i).getYCoord() == claw.getY())
                {
                    isPrizeHere = true;
                }
            }
        }
        return isPrizeHere;
    }
    

    /**
     * returns prize arrayList
     * @return List<Prize> returns the prize list
     */
    public List<Prize> getPrizeList()
    {
        return this.prizeList;
    }
    
    /**
     * returns the claw
     * @return Claw returns the claw
     */
    public Claw getClaw()
    {
        return this.claw;
    }
    
    /**
     * sets the prize list
     */
    public void setPrizeList()
    {
        this.prizeList = prizeListCreation();
    }
    /**
     * sets the claw
     */
    public void setClaw()
    {
        this.claw = new Claw();
    }
    /**
     * generates a random number with parameters
     * @param min the minimum value of random
     * @param max the maximum value of random
     * @return int returns the randomly generated number
     */
    public int generateRandomNumber(int min, int max)
    {
        Random rand =  new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    
}

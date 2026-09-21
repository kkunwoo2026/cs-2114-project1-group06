// Virginia Tech Honor Code Pledge:
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Armaan Ali (amali052024), Jonathan Elliott (ejonathan25), Kunwoo Kim (kkunwoo)
//
// LLM Statement: ******
// I have not used any assistance for the assignment beyond course 
// resources and staff.

/**
 *  The main class. Where the whole program runs. 
 *  @author Jonathan, Armaan, Kunwoo
 *  @version Sep 14, 2026
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * 
/**
 *  The main class that handles the whole game
 * 
 *  @author Jonathan Elliott (ejonathan25)
 *  @version Sep 16, 2026
 */
public class Main
{
    
  //~ Fields ................................................................
    private List<Prize> prizeList = new ArrayList<>();
    private List<Prize> collectedList = new ArrayList<>();
    private Claw claw;
    private Player mainPlayer;
    
    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * The main game
     */
    public void main()
    {
        //setups the scanner and boolean to check round
        boolean useTokens = true;
        boolean roundRun = true;
        mainPlayer = new Player(100);
        Scanner userInput = new Scanner(System.in);
        
        
        //sets up the prize list and claw
        this.setPrizeList();
        this.setClaw();
        
        //prints the current prizes
        printPrizeList();
        
        //prints the help info at the start
        printHelp();
        
        //runs the rounds till prize or miss 
        while (mainPlayer.getTokens() >= 4)
        {
            while (roundRun)
            {
                System.out.println(mainPlayer.getTokens());
                if (useTokens)
                {
                    mainPlayer.useTokens();
                    useTokens = false;
                }
                //handles inputs from user
                System.out.print("Enter command: ");
                String userInputString = userInput.nextLine();
                System.out.println(userInputString);
                
                
                //handles the claw picking up
                //separate instruction if " " is entered
                if (userInputString.equals(" "))
                {
                    useTokens = true;
                    //checks if a prize is here
                    if (hasPrize()) {
                        Prize prize = prizeList.get(whatPrizeHere());
                        if (prize.tryPrize()) {
                            System.out.print("Hit! ");
                            System.out.print("\n");
                            this.collectedList.add(prizeList.get(this.whatPrizeHere()));
                            prizeList.set(this.whatPrizeHere(), null);
                            System.out.println("Amount of Prizes left to collect: " + howManyPrizeLeft());
                            System.out.println("Amount of Prizes collected: " + collectedList.size());
                            printPrizeList();
                        }
                        else {
                            System.out.print("Miss! try again. ");
                            System.out.print("\n");
                            printPrizeList();
                            System.out.print("\n");
                        }
                        
                        //if prize list is empty, end the game
                        if (howManyPrizeLeft() == 0)
                        {
                            roundRun = false;
                            System.out.println("Congrats you got all the prizes!");
                        }
                        else if (mainPlayer.getTokens() <= 0)
                        {
                            roundRun = false;
                            System.out.println("Oops, out of Tokens!");
                        }
                    
                    }
                }
            
                //print help if h is inputed
                if (userInputString.equals("h"))
                {
                    printHelp();
                    printPrizeList();
                }
                if (userInputString.equals("lower"))
                {
                    for (int i = 0; i < this.getPrizeList().size(); i++) {
                        this.getPrizeList().get(i).setPercentage(15);
                    }
                }
                if (userInputString.equals("higher"))
                {
                    for (int i = 0; i < this.getPrizeList().size(); i++) {
                        this.getPrizeList().get(i).setPercentage(50);
                    }
                }
                //move the claw as long as the game is not over
                if (roundRun)
                {
                    this.getClaw().move(userInputString);
                }
            }           
        }
    }
    /**
     * Gets how many prizes there is left in the game
     * @return number of prize left.
     */
    public int howManyPrizeLeft()
    {
        int count = 0;
        for (int i = 0; i < prizeList.size(); i++)
        {
            if (prizeList.get(i) != null)
            {
                count++;
            }
        }
        return count;      
    }
    
    /**
     * creates the prizes and the list of them
     * @return List<Prize> returns a generated list of prizes
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
                //make sure prizes are not on each other
                while (prizes.get(i).getXCoord() == (prizes.get(j).getXCoord()) && prizes.get(i).getYCoord() == (prizes.get(j).getYCoord()))
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
            if (this.getPrizeList().get(i) != null)
            {
                if (this.getPrizeList().get(i).getXCoord() == claw.getX())
                {
                    if (this.getPrizeList().get(i).getYCoord() == claw.getY())
                    {
                        isPrizeHere = true;
                    }
                }
            }
        }
        return isPrizeHere;
    }
    
    /**
     * determines if and what prize is below the claw
     * @return returns the arrayList position of the prize
     */
    public int whatPrizeHere()
    {
        for (int i = 0; i < this.getPrizeList().size(); i++)
        {
            if (this.getPrizeList().get(i) != null)
            {
                if (this.getPrizeList().get(i).getXCoord() == claw.getX())
                {
                    if (this.getPrizeList().get(i).getYCoord() == claw.getY())
                    {
                        return i;
                    }
                }     
            }
        }
        return -1;
    }
    
    /**
     * prints the current prizes still on the board
     */
    public void printPrizeList()
    {
        for (int i = 0; i < prizeList.size(); i++)
        {
            if (prizeList.get(i) != null)
            {
                System.out.println("Prize " + (i + 1) + " is at: (" + prizeList.get(i).getXCoord() + ", " + prizeList.get(i).getYCoord() + ")");      

            }
            else
            {
                System.out.println("Prize " + (i + 1) + " taken!");
            }
            
        }
        System.out.println("\n Tokens left: " + mainPlayer.getTokens());
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
     * prints the help text
     */
    public void printHelp()
    {
        System.out.println("Commands:\n'w' for up.\n's' for down.\n'd' for right.\n'a' for left.\n' 'to try to grab prize!\n'h' to see this message again.");
    }
    /**
     * generates a random number with parameters
     * @param min the minimum value of random
     * @param max the maximum value of random
     * @return returns the randomly generated number
     */
    public int generateRandomNumber(int min, int max)
    {
        Random rand =  new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    
}

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

    //~ Constructors ..........................................................
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * The main game
     */
    public void main()
    {
        boolean roundRun = true;
        Claw claw = new Claw();
        Scanner userInput = new Scanner(System.in);
        
        while (roundRun)
        {
            System.out.print("Test: Enter command: ");
            String userInputString = userInput.nextLine();
            System.out.println(userInputString);
            if (userInputString.equals(" "))
            {
                roundRun = false;
            }
            claw.move(userInputString);
        }           
    }
    
    /**
     * creates the prizes and the list of them
     */
    public List<Prize> prizeListCreation()
    {
        List<Prize> prizes = new ArrayList<>();
        Prize prize1 = new Prize();
        prize1.setPrize(generateRandomNumber(0, 5), generateRandomNumber(0, 5));
        prizes.add(prize1);
        Prize prize2 = new Prize();
        prize2.setPrize(generateRandomNumber(0, 5), generateRandomNumber(0, 5));
        prizes.add(prize2);
        Prize prize3 = new Prize();
        prize3.setPrize(generateRandomNumber(0, 5), generateRandomNumber(0, 5));
        prizes.add(prize3);
        
        for (int i = 0; i < prizes.size(); i++)
        {
            for (int j = i; j < prizes.size(); j++)
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
     * generate random number
     */
    public int generateRandomNumber(int min, int max)
    {
        Random rand =  new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}

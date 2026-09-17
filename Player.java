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
 *  This is how the player would utilize from their inventory of items.
 * 
 *  @author Armaan Ali
 *  @version Sep 14, 2026
 */
public class Player
{
//~ Fields ................................................................
    private int tokens;
//~ Constructors ..........................................................
 // ----------------------------------------------------------
    /**
     * Create a new Player object.
     * @param tokens for the current tokens.
     */
    public Player(int tokens)
    {
        this.getTokens();
    }
// ----------------------------------------------------------

//~Public  Methods ........................................................
    /**
     * This method shows the tokens currently that the player has. 
     * @return tokens for the tokens currently. 
     */
    public int getTokens()
    {
        return tokens;
    }
    // ----------------------------------------------------------
    /**
     * This method uses up the tokens for the game.
     */
    public void useTokens()
    {
        this.tokens = tokens - 5;
    }
 // ----------------------------------------------------------
    /**
     * This method adds more tokens for the game.
     * @param addedTokens for the additional tokens needed for the player to
     * operate the machine. 
     */
    public void addTokens(int addedTokens)
    {
        this.tokens = tokens + addedTokens;
    }
    
    

}

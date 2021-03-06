package roulette;

import java.util.ResourceBundle;

import util.ConsoleReader;

/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public class Bet
{
    private String myDescription;
    private int myOdds;
    protected String betChoice;
    private ResourceBundle myResources;
    
    /**
     * Constructs a bet with the given name and odds.
     * 
     * @param description name of this kind of bet
     * @param odds odds given by the house for this kind of bet
     */
    public Bet (String description, int odds)
    {
        
    	myDescription = description;
        myOdds = odds;
    }


    /**
     * @return odds given by the house for this kind of bet
     */
    public int getOdds ()
    {
        return myOdds;
    }


    /**
     * @return name of this kind of bet
     */
    public String getDescription ()
    {
        return myDescription;
    }
    
    public boolean makeBet(Wheel myWheel) 
    {
    	return false; 
    }
    
    public String returnResult() {
		return "";
	}
    
    public String printResults(String result) {
    	System.out.println();
    	return result;
    }
    
    public String placeBet() {
    	return returnResult();
    }
    
    public void setBetChoice(String betChoice) {
    	this.betChoice = betChoice;
    }
}

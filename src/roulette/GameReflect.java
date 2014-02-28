package roulette;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 * @author LeeYuZhou (yl218)
 * @author AmyWang (alw56)
 * @author Lawrence Lin (al196)
 */
public class GameReflect
{
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    public static final String RED_BLACK = "Red or Black";
    public static final int RED_BLACK_ODDS = 1;
    public static final String ODD_EVEN = "Odd or Even";
    public static final int ODD_EVEN_ODDS = 1;
    public static final String THREE_ROW = "Three in a Row";
    public static final int THREE_ROW_ODDS = 11;
    public static final String HIGH_LOW = "High or Low";
    public static final int HIGH_LOW_ODDS = 1;
    public static final String SINGLE_NUM = "Single Number";
    public static final int SINGLE_NUM_ODDS = 35;
    public static final String TWO_ROW = "Two in a Row";
    public static final int TWO_ROW_ODDS = 17;
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private ResourceBundle myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Files");
    private Wheel myWheel;
    private Bet[] myPossibleBets;
    

    /**
     * Construct the game.
     */
    public GameReflect ()
    {
        myWheel = new Wheel();
        myPossibleBets = createBetArray();
    }


    /**
     * @return name of the game
     */
    public String getName ()
    {
        return DEFAULT_NAME;
    }
    
    public Bet[] createBetArray() {
    	Bet[] bets = new Bet[myResources.keySet().size()];
    	int index = 0;
    	for (String key: myResources.keySet()) {
    		try {
    		
				Class c = Class.forName(myResources.getString(key));
				Bet b = (Bet) c.newInstance();
				bets[index] = b;
				index++;
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return bets;
    }


    /**
     * Play a round of this game.
     *
     * For Roulette, this means prompting the player to make a bet, 
     * spinning the roulette wheel, and then verifying that the bet
     * is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player)
    {
        int amount = ConsoleReader.promptRange("How much do you want to bet", 
                                               0, player.getBankroll());
        int whichBet = promptForBet();
        Bet myBet = myPossibleBets[whichBet];
        String betChoice = myBet.placeBet();
        myBet.setBetChoice(betChoice);
        System.out.print("Spinning ...");
        myWheel.spin();
        System.out.println("Dropped into " + myWheel.getColor() + " " + myWheel.getNumber());

        if (myBet.makeBet(myWheel))
        {
            System.out.println("*** Congratulations :) You win ***");
            amount *= myPossibleBets[whichBet].getOdds();
        }
        else
        {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
    }


    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private int promptForBet ()
    {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++)
        {
            System.out.println((k + 1) + ") " + myPossibleBets[k].getDescription());
        }

        return ConsoleReader.promptRange("Please make a choice",
                                         1, myPossibleBets.length) - 1;
    }


    /**
     * Place the given bet by prompting the user for the specific information
     * need to complete the given bet.
     *
     * @param whichBet specific bet chosen by the user
     */


    /**
     * Checks if the given bet is won or lost given the user's choice and the result
     * of spinning the wheel.
     *
     * @param whichBet specific bet chosen by the user
     * @param betChoice specific value user chose to try to win the bet 
     */

}

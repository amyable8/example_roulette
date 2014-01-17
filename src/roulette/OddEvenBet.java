package roulette;

import util.ConsoleReader;

public class OddEvenBet extends Bet {
	public OddEvenBet() {
		super(Game.ODD_EVEN, Game.ODD_EVEN_ODDS);
		// TODO Auto-generated constructor stub
	}
	public boolean makeBet(Wheel myWheel) {
		return (myWheel.getNumber() % 2 == 0 && betChoice.equals("even")) ||
                (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
	}
	
	public String returnResult() {
		String result = ConsoleReader.promptOneOf("Please bet", "even", "odd");
		return printResults(result);
	}

}

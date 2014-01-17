package roulette;

import util.ConsoleReader;

public class RedBlackBet extends Bet {

	public RedBlackBet() {
		super(Game.RED_BLACK, Game.RED_BLACK_ODDS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean makeBet(Wheel myWheel) {
		return myWheel.getColor().equals(betChoice);
	}
	
	public String returnResult() {
		String result =  ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
		return printResults(result);
	}

}

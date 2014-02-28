package roulette;

import util.ConsoleReader;

public class RedBlackBet extends Bet {

	public RedBlackBet() {
		super(GameEnum.RED_BLACK, GameEnum.RED_BLACK_ODDS);
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

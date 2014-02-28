package roulette;

import util.ConsoleReader;

public class TwoRowBet extends Bet {
	public TwoRowBet() {
		super(GameEnum.TWO_ROW, GameEnum.TWO_ROW_ODDS);
		// TODO Auto-generated constructor stub
	}
	public boolean makeBet(Wheel myWheel) {
		 int start = Integer.parseInt(betChoice);
         return (start <= myWheel.getNumber() && myWheel.getNumber() < start + 2);
	}
	
	public String returnResult() {
		String result = "" + ConsoleReader.promptRange("Enter first of two consecutive numbers", 1, 34);
		return printResults(result);
	}

}

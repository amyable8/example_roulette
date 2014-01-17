package roulette;

import util.ConsoleReader;

public class ThreeRowBet extends Bet {
	public ThreeRowBet() {
		super(Game.THREE_ROW, Game.THREE_ROW_ODDS);
		// TODO Auto-generated constructor stub
	}
	public boolean makeBet(Wheel myWheel) {
		 int start = Integer.parseInt(betChoice);
         return (start <= myWheel.getNumber() && myWheel.getNumber() < start + 3);
	}
	
	public String returnResult() {
		String result = "" + ConsoleReader.promptRange("Enter first of three consecutive numbers", 1, 34);
		return printResults(result);
	}

}

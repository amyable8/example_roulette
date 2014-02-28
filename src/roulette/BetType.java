package roulette;

public enum BetType {
	REDBLACK(new RedBlackBet()), 
	ODDEVEN(new OddEvenBet()), 
	THREEROWBET(new ThreeRowBet()), 
	TWOROWBET(new TwoRowBet());
	
	private Bet myB;
	private BetType(Bet b) {
		myB = b;
	}
	
	private Bet getBet() {
		return myB;
	}
}



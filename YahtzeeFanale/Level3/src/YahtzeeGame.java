import java.util.Scanner;

public class YahtzeeGame
{
	private static final int NUM_SIDES = 6;
	private YahtzeeDie die1;
	private YahtzeeDie die2;
	private YahtzeeDie die3;
	private YahtzeeDie die4;
	private YahtzeeDie die5;
	YahtzeeScorecard sc;
	Scanner s = new Scanner(System.in);

	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */

	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		die1 = new YahtzeeDie(NUM_SIDES);
		die2 = new YahtzeeDie(NUM_SIDES);
		die3  = new YahtzeeDie(NUM_SIDES);
		die4 = new YahtzeeDie(NUM_SIDES);
		die5= new YahtzeeDie(NUM_SIDES);
		sc= new YahtzeeScorecard();

	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for(int i = 0;i<13;i++){
			takeTurn();
		}
		sc.printScoreCard();
		System.out.println(sc.getGrandTotal());
		/* your code here */
		return sc.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		rollDice();
		printDice();
		System.out.print("Are you (s)atisfied or to you want to freeze dice and (r)oll again? (s/r): ");
		char wantsToRoll = s.nextLine().charAt(0);
		if(wantsToRoll == 's'){
			markScore();
		}
		else{
			chooseFrozen();
			rollDice();
			printDice();
			System.out.print("Are you (s)atisfied or to you want to freeze dice and (r)oll again? (s/r): ");
			s.nextLine();
			char wantsToRoll2 = s.nextLine().charAt(0);
			if(wantsToRoll2 == 's'){
				markScore();
			}
			else{
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}
		}
		/* your code here */
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!die1.isFrozen()) die1.rollDie();
		if(!die2.isFrozen()) die2.rollDie();
		if(!die3.isFrozen()) die3.rollDie();
		if(!die4.isFrozen()) die4.rollDie();
		if(!die5.isFrozen()) die5.rollDie();
		die1.unfreezeDie();
		die2.unfreezeDie();
		die3.unfreezeDie();
		die4.unfreezeDie();
		die5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.print("Choose Frozen Dice: ");
		String frozenDice = s.nextLine();
		if(frozenDice.contains("1")) die1.freezeDie();
		if(frozenDice.contains("2")) die2.freezeDie();
		if(frozenDice.contains("3")) die3.freezeDie();
		if(frozenDice.contains("4")) die4.freezeDie();
		if(frozenDice.contains("5")) die5.freezeDie();
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println(die1.getValue() + "\t" + die2.getValue() + "\t"+ die3.getValue() + "\t"+ die4.getValue() + "\t"+ die5.getValue() + "\t" );

		/* your code here */
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		sc.printScoreCard();
		System.out.print("Where would you like to place your score?\n" +
				"1. Ones \t7.  3 of Kind\n" +
				"2. Twos \t8.  4 of Kind\n" +
				"3. Threes \t9.  Full House\n" +
				"4. Fours \t10. Sm Straight\n" +
				"5. Fives \t11. Lg Straight\n" +
				"6. Sixes \t12. Yahtzee\n" +
				"\t\t13. Chance\n" +
				"Enter 1-13: ");
		int placement = s.nextInt();
		switch (placement){
			case 1: sc.markOnes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 2: sc.markTwos(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 3: sc.markThrees(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 4: sc.markFours(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 5: sc.markFives(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 6: sc.markSixes(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 7: sc.markThreeOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 8: sc.markFourOfAKind(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 9: sc.markFullHouse(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 10: sc.markSmallStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 11: sc.markLargeStraight(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 12: sc.markYahtzee(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
			case 13: sc.markChance(die1.getValue(),die2.getValue(),die3.getValue(),die4.getValue(),die5.getValue());
		}

	}
}
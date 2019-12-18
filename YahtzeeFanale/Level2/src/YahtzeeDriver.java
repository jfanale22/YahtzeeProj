import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
			Scanner s = new Scanner(System.in);
			YahtzeeGame myGame;
			char wantsToPlay = 'y';
			int score;
			int gamesPlayed = 0;
			int minScore = 999;
			int maxScore = -999;
			double averageScore = 0;
			while(wantsToPlay == 'y') {
				myGame = new YahtzeeGame();
				System.out.println("Welcome to Jake's APCSA Yahtzee Game!");
				score = myGame.playGame();
				System.out.println("Would you like to play again? y/n");
				if(score <minScore) minScore = score;
				if(score >maxScore) maxScore = score;
				wantsToPlay = s.nextLine().charAt(0);
				gamesPlayed ++;
				averageScore +=score;
			}
			averageScore /= gamesPlayed;
		System.out.println("Games Played: "+ gamesPlayed + "Min Score: "+ minScore + "MaxScore: " + maxScore + "Avg Score: " + averageScore);

	}
}

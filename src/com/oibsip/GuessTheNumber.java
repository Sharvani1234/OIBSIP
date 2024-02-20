package com.oibsip;

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
	public static void main(String[] args) {
		final int MIN_NUMBER=1;
		final int MAX_NUMBER=100;
		final int MAX_ATTEMPTS=5;
		
		Random random=new Random();
		int randomNumber=random.nextInt(MAX_NUMBER-MIN_NUMBER+1)+MIN_NUMBER;
		
		int attempts=0;
		int score=0;
		
		while(attempts<MAX_ATTEMPTS) {
			String guessString=JOptionPane.showInputDialog(null,"Guess the number between "+MIN_NUMBER+" and "+MAX_NUMBER);
			if(guessString==null) {
				JOptionPane.showMessageDialog(null,"Thanks for playing!");
				break;
			}
			
			int guess=Integer.parseInt(guessString);
			
			if(guess<MIN_NUMBER||guess>MAX_NUMBER) {
				JOptionPane.showMessageDialog(null, "Please enter a number within the valid range!");
				continue;
			}
			
			attempts++;
			
			if(guess==randomNumber) {
				JOptionPane.showMessageDialog(null,"Congratulations!You guessed the number in "+attempts+" attempts!");
				score+=(MAX_ATTEMPTS-attempts)*10;
				int option=JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if(option==JOptionPane.YES_OPTION) {
					randomNumber=random.nextInt(MAX_NUMBER-MIN_NUMBER+1)+MIN_NUMBER;
					attempts=0;
				}
				else {
					JOptionPane.showMessageDialog(null, "Your final score:"+score);
					break;
				}
			}
			else if(guess<randomNumber) {
				JOptionPane.showMessageDialog(null, "Too low!try again.");
			}
			else {
				JOptionPane.showMessageDialog(null, "Too high!Try again.");
			}
		}
		
		if(attempts==MAX_ATTEMPTS) {
			JOptionPane.showMessageDialog(null,"Sorry,you've used all your attempts.The number was:"+randomNumber);
			int option=JOptionPane.showConfirmDialog(null,"Do you want to play again?");
			if(option==JOptionPane.YES_OPTION) {
				main(null);
			}
			else {
				JOptionPane.showMessageDialog(null,"Your final score:"+score);
			}
		}
	}
}
package com.company;
/*
*           Andrew Mills
*           February 9, 2021
*           COSC 1437.004
*           JDK 1.8
 */
import java.util.Locale;
import java.util.Random;
import javax.swing.*;

/*
*       Variables for Rock Paper Scissors
*               1 = Rock
*               2 = Paper
*               3 = Scissors
 */

public class RockPaperScissors {
    public static int randomNumberGenerator(int ceiling)
    {
        Random randomVariable = new Random();
        return randomVariable.nextInt(ceiling);
    }
    public static int selectChoice()
    {
        int choice;
        String Input = JOptionPane.showInputDialog(null, "Please choose rock, paper or scissors");
        Input = Input.toLowerCase(Locale.ROOT);
        return switch (Input) {
            case "rock" -> 1;
            case "paper" -> 2;
            case "scissors" -> 3;
            case "scissor" -> 3;
            default -> -1;
        };
    }
    public static void gameplay (int player, int computer)
    {
        switch(player)
        {
            case 1:
                if(computer == 1)       JOptionPane.showMessageDialog(null,"You both picked Rock, try again!");           //Returning zero indicates a loss
                else if(computer == 2)  JOptionPane.showMessageDialog(null,"Paper covers Rock, you lose!");           //Returning one indicates a win
                else                    JOptionPane.showMessageDialog(null,"Rock smashes Scissors, you win!");           //Returning two indicates a tie
                break;
            case 2:
                if(computer == 1)       JOptionPane.showMessageDialog(null,"Paper covers Rock, you win!");
                else if(computer == 2)  JOptionPane.showMessageDialog(null,"You both picked Paper, try again!");
                else                    JOptionPane.showMessageDialog(null,"Scissors cut Paper, you lose!");
                break;
            case 3:
                if(computer == 1)       JOptionPane.showMessageDialog(null,"Rock smashes scissors, you lose!");
                else if (computer == 2) JOptionPane.showMessageDialog(null,"Scissors cut Paper, you win!");
                else                    JOptionPane.showMessageDialog(null,"You both picked Scissors, try again!");
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
	    int playerChoice, computerChoice, gameWinner;
	    computerChoice = randomNumberGenerator(3);
	    playerChoice = selectChoice();
	    gameplay(playerChoice, computerChoice);
	    while(playerChoice == computerChoice)
        {
            computerChoice = randomNumberGenerator(3);
            playerChoice = selectChoice();
            gameplay(playerChoice, computerChoice);
        }
	    System.exit(1);
    }
}

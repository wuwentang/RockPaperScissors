/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alice Tang
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        boolean playAgain;
        int roundsLeft, roundsTotal = 1;
        int playerMove, computerMove;
        int minRandom = 1, maxRandom = 3;
        int ties = 0, userWins = 0, computerWins = 0;
        boolean userIsWinner = false, tied = false;
        
        System.out.println("*******************************");
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("*******************************");
       
        Scanner sc = new Scanner(System.in);
        
        do {
            // ask for rounds
            System.out.println("How many rounds would you like to play?");
            roundsLeft = Integer.parseInt(sc.nextLine());

            if (roundsLeft <= 0 || roundsLeft > 10){
                System.out.println("Invalid number of rounds. Goodbye!");
                return;
            }

            while (roundsLeft > 0) {
            // ask for player choice
                System.out.println("Round " + roundsTotal);
                
                do {
                    System.out.println("Which would you like to play?\n "
                            + "1-Rock\n "
                            + "2-Paper\n "
                            + "3-Scissors");
                    playerMove = Integer.parseInt(sc.nextLine());
                    if (playerMove <1 || playerMove > 3) {
                        System.out.println("Please enter a valid move.");
                    }
                } while (playerMove <1 || playerMove > 3);

                System.out.println(playerMove);

                // computer generates its own move :)
                Random rng = new Random();
                computerMove = rng.nextInt(maxRandom - minRandom + 1) + minRandom;
                System.out.println(computerMove);

                // compute winner
                int playerMoveMod = playerMove % 3;
                int computerMoveMod = computerMove % 3;

                if (playerMoveMod > computerMoveMod) {
                    System.out.println("Player Wins this round!\n");
                    userWins++;
                } else if (playerMoveMod < computerMoveMod) {
                    System.out.println("Computer Wins this round!\n");
                    computerWins++;
                } else {
                    System.out.println("It's a tie!\n");
                    ties++;
                }

                // end game
                System.out.println("Game Status:\n "
                        + "User has won " + userWins + " games!\n "
                        + "Computer has won " + computerWins + " games!\n "
                        + "You have tied " + ties + " times!\n");

               if (userWins > computerWins) {
                    userIsWinner = true;
                    System.out.println("User is winning!\n");
                } else if (userWins < computerWins) {
                    userIsWinner = false;
                    System.out.println("Computer is winning!\n");
                } else {
                    tied = true;
                    System.out.println("You are tied!\n");
                }  
                roundsLeft--;
                roundsTotal++;
            }

            if (userIsWinner == true) {
                System.out.println("******************");
                System.out.println("Congrats! You won!");
                System.out.println("******************\n");
            } else if (tied == true) {
                System.out.println("***************************************");
                System.out.println("The winner is... no one. You have tied.");
                System.out.println("***************************************\n");
            } else if (userIsWinner == false && tied == false) {
                System.out.println("*********************");
                System.out.println("The computer has won.");
                System.out.println("*********************\n");
            }

            System.out.println("Would you like to play again? (Y/N)");
            String playMore = sc.nextLine();
            playMore = playMore.toLowerCase();
            
            if (playMore.equals("y")) {
                playAgain = true;
                roundsLeft = 0;
                roundsTotal = 1;
                ties = 0;
                userWins = 0;
                computerWins = 0;
            } else {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
       
        } while (playAgain == true);
    }
}

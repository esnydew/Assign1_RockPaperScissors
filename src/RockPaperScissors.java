import java.util.Scanner;

/** A rock, paper, scissors game that takes input from two players, outputs the result of the game, then asks to play again. */
/* For the record, I chose to add some additional functionality, such as keeping track of scores, or taking full words for moves and not just letters.
For some functionality, I had to do additional research. Most of this was done using W3Schools. For example, .trim().toLowerCase() was found using it.
Originally, with the moves, I was going to use .charAt() by itself. The editor caught this and I realized I was trying to give it a char value. I checked W3Schools' method references and decided to use substring instead. */
/* Also, this code does not use any other methods (functions). Ideally, some of this code would be defined separately and then the main() method would call those methods to run the program. */

public class RockPaperScissors {
    static void main() {
        // Declarations
            Scanner in = new Scanner(System.in);
            String playerAMove = "";
            String playerBMove = "";
            String playGame = "";
            int playerAScore = 0;
            int playerBScore = 0;
            boolean valid = false;
            boolean playAgain = false;
        // IPO
        // When program first runs, prompts player to ask if they'd like to play the game. This is beyond the initial scope, but was added for QoL.
        do {
            System.out.print("Welcome to Rock, Paper, Scissors! Would you like to play? (Yes or No)>> ");
            playGame = in.nextLine().trim().toLowerCase();
            if(playGame.equals("y") || playGame.equals("yes")) {
                playAgain = true;
                valid = true;
            } else if(playGame.equals("n") || playGame.equals("no")) {
                valid = true;
            } else {
                System.out.printf("You entered: '%s'.%n", playGame);
                System.out.printf("'%s' is not a valid input! You must respond with either yes or no.%n", playGame);
            }
        } while (!valid);
        // Game loop. Will ask if players would like to continue at the end. Uses a while since the first block asks whether the players would like to play.
        while(playAgain) {
            valid = false;
            // Collect the move for Player A.
            do {
                System.out.print("Please enter Player A's move (Rock, Paper, or Scissors)>> ");
                playerAMove = in.nextLine().trim().toLowerCase();
                if(playerAMove.equals("r") || playerAMove.equals("rock") ||
                        playerAMove.equals("p") || playerAMove.equals("paper") ||
                        playerAMove.equals("s") || playerAMove.equals("scissors")) {
                    playerAMove = playerAMove.substring(0,1); // Grabs only the first letter for reference later. This cannot be done earlier because the word "sick" would count as the move scissors.
                    valid = true;
                } else {
                    System.out.printf("You entered: '%s'.%n", playerAMove);
                    System.out.printf("'%s' is not a valid move! You must enter rock, paper, or scissors!%n", playerAMove);
                }
            } while(!valid);
            // This loop is used to clear the console for player B to input a move without cheating.
            for(int i = 0; i < 50; i++) {
                System.out.println();
            }
            valid = false;
            // Collect the move for Player B
            do {
                System.out.print("Please enter Player B's move (Rock, Paper, or Scissors)>> ");
                playerBMove = in.nextLine().trim().toLowerCase();
                if(playerBMove.equals("r") || playerBMove.equals("rock") ||
                        playerBMove.equals("p") || playerBMove.equals("paper") ||
                        playerBMove.equals("s") || playerBMove.equals("scissors")) {
                    playerBMove = playerBMove.substring(0,1); // Grabs only the first letter for reference later. This cannot be done earlier because the word "sick" would count as the move scissors.
                    valid = true;
                } else {
                    System.out.printf("You entered: '%s'.%n", playerBMove);
                    System.out.printf("'%s' is not a valid move! You must enter rock, paper, or scissors!%n", playerBMove);
                }
            } while(!valid);
            System.out.printf("Player A's move: '%s'.%nPlayer B's move: '%s'.%n", playerAMove.toUpperCase(), playerBMove.toUpperCase());
            if(playerAMove.equals("r")) {
                if(playerBMove.equals("r")) {
                    System.out.println("Rock and Rock; it's a tie!");
                } else if(playerBMove.equals("p")) {
                    System.out.println("Paper covers Rock; Player B wins!");
                    playerBScore++;
                } else {
                    System.out.println("Rock breaks Scissors; Player A wins!");
                    playerAScore++;
                }
            } else if(playerAMove.equals("p")) {
                if(playerBMove.equals("r")) {
                    System.out.println("Paper covers Rock; Player A wins!");
                    playerAScore++;
                } else if(playerBMove.equals("p")) {
                    System.out.println("Paper and Paper; it's a tie!");
                } else {
                    System.out.println("Scissors cuts Paper; Player B wins!");
                    playerBScore++;
                }
            } else {
                if(playerBMove.equals("r")) {
                    System.out.println("Rock breaks Scissors; Player B wins!");
                    playerBScore++;
                } else if(playerBMove.equals("p")) {
                    System.out.println("Scissors cuts Paper; Player A wins!");
                    playerAScore++;
                } else {
                    System.out.println("Scissors and Scissors; it's a tie!");
                }
            }
            System.out.printf("Player A's score: %d.%nPlayer B's score: %d.%n", playerAScore, playerBScore);
            valid = false;
            // Ask if the players want to play again.
            do {
                System.out.print("Would you like to play again? (Yes or No)>> ");
                playGame = in.nextLine().trim().toLowerCase();
                if(playGame.equals("y") || playGame.equals("yes")) {
                    valid = true;
                    // Clear the previous game.
                    for(int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                } else if(playGame.equals("n") || playGame.equals("no")) {
                    playAgain = false;
                    valid = true;
                } else {
                    System.out.printf("You entered: '%s'.%n", playGame);
                    System.out.printf("'%s' is not a valid input! You must respond with either yes or no.%n", playGame);
                }
            } while (!valid);
        }
    }
}
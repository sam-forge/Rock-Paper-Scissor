import java.util.*;
class game{
    void display(int choice){
        if(choice == 1){
                System.out.println("Rock");
            }
            else if (choice == 2){
                System.out.println("Paper");
            }
            else {
                System.out.println("Scissors");
            }
    }
}
public class RPS_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String playAgain;
        int player_win = 0;
        int computer_win = 0;
        int draw_win = 0;
        int rounds = 0;

        game g = new game();

        System.out.println("============================================================");
        System.out.println("                  ROCK PAPER SCISSORS GAME                  ");
        System.out.println("============================================================");
        System.out.println();
        System.out.print("Enter your name: ");
        String PlayerName = sc.next();
        System.out.println("Welcome, " + PlayerName + "!");
        
        do{
            System.out.println();
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Rock 2. Paper 3. Scissors");
            System.out.print("Enter your choice: ");
            int UserChoice = sc.nextInt();

            while (UserChoice < 1 || UserChoice > 3) {
                System.out.println();
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                UserChoice = sc.nextInt();
            }
            System.out.println();
            System.out.print("You chose: ");
            g.display(UserChoice);

            int ComputerChoice = rand.nextInt(3) + 1;
            System.out.print("Computer chose: ");
            g.display(ComputerChoice);

            if (UserChoice == ComputerChoice){
                System.out.println();
                System.out.println("It's a tie!");
                draw_win += 1;
                rounds +=1;
            } 
            else if ((UserChoice == 1 && ComputerChoice == 3) || (UserChoice == 2 && ComputerChoice == 1) || (UserChoice == 3 && ComputerChoice == 2)){
                System.out.println();
                System.out.println("You win!");
                player_win += 1;
                rounds += 1;
                
            }
            else {
                System.out.println();
                System.out.println("Computer wins!");
                computer_win += 1;
                rounds += 1;
            }
            
            System.out.println();
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                        GAME OVER                           ");
        System.out.println("============================================================");
        System.out.println("Total rounds played : " + rounds);
        System.out.println("Player wins         : " + player_win);
        System.out.println("Computer wins       : " + computer_win);
        System.out.println("Draws               : " + draw_win);

        System.out.println();
        System.out.println("============================================================");
        if(player_win > computer_win){
            System.out.println("Congratulations, " + PlayerName + "! You are the overall winner!");
        }
        else if (computer_win > player_win){
            System.out.println("Computer is the overall winner! Better luck next time, " + PlayerName + "!");
        }
        else {
            System.out.println("It's an overall tie! Great game, " + PlayerName + "!");
        }
        System.out.println("============================================================");
        sc.close();
    }
}

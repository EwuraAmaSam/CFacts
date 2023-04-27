/**
 * @authors: Ewura Ama Sam, Princess Asiru-Bologun, Alvin Harrison-Indome
 */
import java.util.Scanner;

public class Menu {
    
    // instance variables
    private static String choice1 = "1";
    private static String choice2 = "2";
    private static boolean access = false;
    private String choice;
    Scanner scan = new Scanner(System.in);
    
    // printing introductory message to the user
    public void  Intro(){
        System.out.println("Welcome to C-Facts. \n");
        System.out.println("We provide you with: ");
        System.out.println("A) Credible information on climate.");
        System.out.println("B) A short proficiency quizz on Climate Change. \n");
        System.out.println("Kindly press");
        System.out.println("1) To take a proficiency quiz");
        System.out.println("2) To generate an article to read.");
        System.out.print("Enter 1 or 2: ");
    }
    
    // Asking the user to choose between playing the game and reading the article
    public void Choice(){
        while (access == false){
            choice = scan.nextLine();
            System.out.println(" ");
            // Instantiates Game if the user types 1
            if (choice.equals(choice1)){
                ClimateGame game = new ClimateGame();
                
                // Calling relevant methods in the ClimateGame class
                game.introMessage();
                game.printQuestions();
                game.scoreSum();
                game.ProficiencyScore();
                game.backToMenu();
                // access is changed to true to break the while loop
                access = true;
            }
            // Instantiates CFacts if the user types 2
            else if (choice.equals(choice2)){
                CFacts article = new CFacts();
                article.introMessage();
                article.Article();
                // access is changed to true to break the while loop
                access = true;
                
            }
            // Prompts the user to make an option between 1 and 2
            else{
                System.out.println("Please type either 1 or 2");
                choice = scan.nextLine();
            }  
        }
        // Closing the Scanner object
        scan.close();
    }

    

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.Intro();
        menu.Choice();
    }
   
    
}

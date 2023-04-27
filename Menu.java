// import java.io.IOException;
// import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    private static String choice1 = "1";
    private static String choice2 = "2";
    private static boolean access = false;
    private String choice;
    Scanner scan = new Scanner(System.in);
    
    public String toString(){
        return "Welcome";
        
    }
    
    
    public void Choice(){
        while (access == false){
            System.out.println("Welcome to C-Facts.");
            System.out.println("We provide you with: ");
            System.out.println("A) Credible information on climate.");
            System.out.println("B) A short proficiency quizz on Climate Change ");
            System.out.println("Kindly press");
            System.out.println("1) To take a proficiency quiz");
            System.out.println("2) To generate an article to read.");
            
            System.out.print("Enter 1 or 2: ");
            choice = scan.nextLine();
            System.out.println(" ");
            if (choice.equals(choice1)){
                ClimateGame game = new ClimateGame();
                game.introMessage();
                game.printQuestions();
                game.scoreSum();
                game.ProficiencyScore();
                game.backToMenu();
                access = true;
            }
            else if (choice.equals(choice2)){
                CFacts article = new CFacts();
                article.introMessage();
                article.Article();
                access = true;
                
            }
            else{
                System.out.println("Please type either 1 or 2");
                choice = scan.nextLine();
            }  
        }
        scan.close();
    }

    

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.toString();
        menu.Choice();
    }
   
    
}

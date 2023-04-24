import java.util.Scanner;

public class Menu {
    
    public int choice1 = 1;
    private int choice2 = 2;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello. You are welcome to C-Facts. Here, we provide you with accurate information on Climate Change.");
        System.out.println("If you want to test your knowledge on climate change, type 1.");
        System.out.println("If you want to read an interesting article, type 2");
        System.out.print("Type Here:");
        int choice = scan.nextInt();

        if (choice == 1){

            ClimateGame game = new ClimateGame();
            game.printQuestions();
            game.scoreSum();

        }


    }
    
}

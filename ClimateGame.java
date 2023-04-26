import java.util.Scanner;
import java.util.Random;

public class ClimateGame implements Game{

    private int totalScores;
    private int attainableScore = 5;
    private int numQuestions = 5;
    
    String QuestionBank[] = {"What is the major cause of climate change? a) CO2 b) O2 c) N2", 
    "Which gas poses the most threat to the earth? a) O2 b)CO2 c) N2", 
    "dnwken", "dhsood", "hjdow"};
    String AnswerBank[] = {"A", "B", "D", "A", "C"};
    String selectedQuestions[] = new String[5];
    String selectedAnswers[] = new String[5];
    int count = 0;



    public ClimateGame(){
        this.totalScores = 0;
    }

    public void introMessage(){
        System.out.println("Welcome to the Proficiency quiz.");
        System.out.println("Have fun!");
    }

    Scanner scan = new Scanner(System.in);
    Random randIndex = new Random();

    public void printQuestions(){
        while (count < numQuestions){
            int index = randIndex.nextInt(QuestionBank.length);

            boolean selected = false;

            for (int i = 0; i < count; i++){
                if (selectedQuestions != null && selectedQuestions[i].equals(QuestionBank[index])){
                    selected = true;
                    break;
                }
            }
            if (!selected && QuestionBank[index] != null){
                selectedQuestions[count] = QuestionBank[index];
                selectedAnswers[count] = AnswerBank[index];
                count++;
            }

        }
        for (int i = 0; i < numQuestions; i++){
            System.out.println(selectedQuestions[i]);
            System.out.println("Answer here:");
            String ans = scan.nextLine();
            if (ans.toUpperCase().equals(selectedAnswers[i])){
                System.out.println("Correct!");
                totalScores++;
            }
            else{
                System.out.println("Wrong please. The answer is: " + selectedAnswers[i]);
            }
        }
    }   
    
    public void scoreSum(){
        System.out.println("Your total score is: " + totalScores);
    }
    
    public void ProficiencyScore(){
        
        double profPercent = (((double)totalScores/(double)attainableScore)*100);
        System.out.println(profPercent);
    
        if (profPercent >= Excellent){
            System.out.println("Proficiency Level: Excellent");
            System.out.println("We recommend that you read advanced articles to boost your knowledge.");
            System.out.println("You should also join advocacy for Climate Change with this knowledge.");
        }
        else if (profPercent >= Good && profPercent < Excellent){
            System.out.println("Proficiency Level: Good");
            System.out.println("That's great. An article once in a while could push you towards excellent.");
        }
        else if (profPercent >= Average && profPercent < Good){
            System.out.println("Proficiency Level: Average");
            System.out.println("Great but you could do better. Kindly read more material to be well informed.");
            
        }
        else if (profPercent < Average){
            System.out.println("Proficiency Level: Low");
            System.out.println("Whoaw. You really need to step up on Climate Change material.");
            System.out.println("We recommend an article a day.");
        }
    }
    public static void main(String[] args){
        // ClimateGame trygame = new ClimateGame();
        // trygame.printQuestions();
        
    }
}

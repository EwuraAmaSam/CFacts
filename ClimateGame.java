import java.util.Scanner;

public class ClimateGame implements Game{

    private int totalScores;
    String QuestionBank[] = {"What is the major cause of climate change? a) CO2 b) O2 c) N2", "Which gas poses the most threat to the earth? a) O2 b)CO2 c) N2"};
    String AnswerBank[] = {"A", "B"};


    public ClimateGame(){
        this.totalScores = 0;
    }

    Scanner scan = new Scanner(System.in);
    public void printQuestions(){
        for (int i = 0; i < QuestionBank.length; i++){
            System.out.println(QuestionBank[i]);
            System.out.println("Answer here:");
            String ans = scan.nextLine();
            if (ans.toUpperCase().equals(AnswerBank[i])){
                System.out.println("Correct!");
                totalScores++;
            }
            else{
                System.out.println("Wrong please. The answer is: " + AnswerBank[i]);
            }
        }
    }   
    
    public int scoreSum(){
        return totalScores;
    }
}

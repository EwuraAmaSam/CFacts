/**
 * @authors: Ewura Ama Sam, Princess Asiru-Bologun, Alvin Harrison-Indome
 */
import java.util.Scanner;
import java.util.Random;

public class ClimateGame implements Game{

    // instance variables
    private int totalScores;
    private int attainableScore = 5;
    private int numQuestions = 5;
    
// String array that contains the questions to be selected at random for the quiz
String QuestionBank[] = {"How many degree Celsius has the earth warmed up by since 1750? \n A) 1.1 degrees \n B) 2 degrees \n C) 4 degrees",
"What is the earths current temperature in Celsius? \n A) 16.75C \n B) 20C \n C) 14.18C ",
"What is global warming? \n A) The long term warming of the planet \n B) The melting of frozen ice on earth \n C) Collection of CO2 in atmosphere",
"The earth is expected to get warmer by how many degrees celsius? \n A) 1 degree \n B) 1.5 degree \n C) 9 degrees",
"Global warming is an effect of climate change. \n A) True \n B) False \n C) Maybe",
"What causes Tides? \n A) Ocean Levels \n B) Wind \n C) Gravitational pull from moon and sun",
"CO2 pollutes the air \n A) True \n B) False \n C) Maybe",
"How long does dust and soot remain in the air? \n A) 3 days \n B) 10 days \n C) 20 days",
"Which of the following has greater effect on the rising sea levels? \n A) Melting sea Ice \n B) Melting Ice on land \n C) Hurricanes",
"Cars do not produce ground-level ozone into the atmosphere \n A) True \n B) False \n C) Maybe",
"Why is the sea level rising? \n A) The ocean is getting filled with plastic \n B) Tornadoes are happening more frequently \n C) Land ice is melting and being added to the oceanwater",
"Too much Ozone is bad for humans \n A) True \n B) False \n C) Maybe",
"By how many inches has the sea level risen since 1880? \n A) 2 inches \n B) 8 inches \n C) 10 inches",
"By how much has carbon dioxide levels in the atmosphere risen since 1751? \n A) 10% \n B) 30% \n C) 49% ",
"Hurricanes have become more intense and frequent. \n A) True \n B) False \n C) Maybe",
"Forest fires affect carbon rates in the environment \n A) True \n B) False \n C) Maybe",
"What forms most of the earths water body? \n A) Rain \n B) The ocean \n C) The atmosphere",
"Methane contains carbon \n A) True \n B) False \n C) Maybe",
"How does global warming affect Antartica? \n A) It increases its sea levels \n B) it causes all the ice there to melt \n C) It causes drought",
"What is the current strongest source of Nitrogen Dioxide? \n A) Car fumes \n B) Plant waste \n C) Burning fossil fuels"};

// String arrays that contain answers that correspond to the questions in QuestionBank array

String AnswerBank[] = {
"A",
"C",
"A",
"B",
"A",
"C",
"A",
"B",
"B",
"A",
"C",
"A",
"B",
"C",
"A",
"A",
"B",
"A",
"B",
"C"};

    // A string array to hold the five questions that would be selected at random from the QuestionBank
    String selectedQuestions[] = new String[5];
    // A string array to hold the answers that correspond to the questions in selectedQuestions
    String selectedAnswers[] = new String[5];
    // To keep count of how many questions have been added to selectedQuestions
    int count = 0;

    public ClimateGame(){
        this.totalScores = 0;
    }

    // Prints an introductory message to the user
    public void introMessage(){
        System.out.println("Welcome to the Proficiency quiz.");
        System.out.println("Have fun!");
    }

    Scanner scan = new Scanner(System.in);
    Random randIndex = new Random();

    /**Until the selectedQuestions array is full, an index in the range of QuestionBank 
     * is generated at random without repetition. The question with that index is stored 
     * */
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

        // Printing the selected questions to the user
        for (int i = 0; i < numQuestions; i++){
            System.out.println(selectedQuestions[i]);
            System.out.print("Answer here:");
            String ans = scan.nextLine();
            // Evaluating the user's answer, whether it corresponds to the answers stored for it
            if (ans.toUpperCase().equals(selectedAnswers[i])){
                System.out.println("Correct!");
                System.out.println(" ");
                // Updating the user's score after each correct answer
                totalScores++;
            }
            else{
                // Displaying the answer to the user if they had it wrong
                System.out.println("Wrong please. The answer is: " + selectedAnswers[i]);
                System.out.println(" ");
            }
        }
    }   
    
    // Displaying the total score to the user
    public void scoreSum(){
        System.out.println("Your total score is: " + totalScores);
    }
    
    public void ProficiencyScore(){
        
        double profPercent = (((double)totalScores/(double)attainableScore)*100);
        System.out.println("Proficiency Score: " +profPercent);
    
        /*
         * Displaying the user's proficiency level by comparing their proficiency score to
         * already defined thresholds in the Game interface 
         */
        
        if (profPercent >= Excellent){
            System.out.println("Proficiency Level: Excellent");
            System.out.println("We recommend that you read advanced articles to boost your knowledge.");
            System.out.println("You should also join advocacy for Climate Change with this knowledge.");
            System.out.println(" ");
        }
        else if (profPercent >= Good && profPercent < Excellent){
            System.out.println("Proficiency Level: Good");
            System.out.println("That's great. An article once in a while could push you towards excellent.");
            System.out.println(" ");
        }
        else if (profPercent >= Average && profPercent < Good){
            System.out.println("Proficiency Level: Average");
            System.out.println("Great but you could do better. Kindly read more material to be well informed.");
            System.out.println(" ");  
        }
        else if (profPercent < Average){
            System.out.println("Proficiency Level: Low");
            System.out.println("Whoaw. You really need to step up on Climate Change material.");
            System.out.println("We recommend an article a day.");
            System.out.println(" ");
        }
    }

    //This method gives the user the chance to either go back to the menu or quit the program 
    public void backToMenu(){
        System.out.println("Would you like go back to the menu?");
        System.out.print("Type y go back or any letter to quit: ");
        String redo = scan.nextLine().trim().toLowerCase();
        System.out.println(" ");
        if (redo.equals("y")){
            // Instantiating the Menu class to call the Choice method
            Menu menu = new Menu();
            menu.Choice();
        }
        else {
            System.out.println("Goodbye. See you another time.");
        }

    }

    public static void main(String[] args){
            
    }
}

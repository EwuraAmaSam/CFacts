/**
 * @authors: Ewura Ama Sam, Princess Asiru-Bologun, Alvin Harrison-Indome
 */
public interface Game{
    // Constants to be used in the ClimateGame class

    // Constants to be compared with the user's input during the qui
    public final char  Answer1 = 'A';
    public final char  Answer2 = 'B';
    public final char  Answer3 = 'C';
   

    // Constants for the proficiency level after calculating the percentage of the total score
    public final int Excellent = 90;
    public final int Good = 70;
    public final int Average = 50;
 

    // Public methods used to implement the ClimateGame class
    public void introMessage();
    public void scoreSum();
    public void printQuestions();
    public void ProficiencyScore();
    public void backToMenu();

}
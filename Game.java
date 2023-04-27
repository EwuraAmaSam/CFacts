public interface Game{
    final char  Answer1 = 'A';
    final char  Answer2 = 'B';
    final char  Answer3 = 'C';
    final char  Answer4 = 'D';

    final int Excellent = 90;
    final int Good = 70;
    final int Average = 50;
 


    public void introMessage();
    public void scoreSum();
    public void printQuestions();
    public void ProficiencyScore();
    public void backToMenu();

}
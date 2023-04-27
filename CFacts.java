import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CFacts implements ArticleFinder{

    public CFacts(){

    }


    public void introMessage(){
        System.out.println("Welcome to the article section.");
        System.out.println("Here, we provide you articles at random");
        System.out.println("Aimed at informing you about climate change.");
        System.out.println("You have the option to read an article or request for a new one.");
        System.out.println("Have Fun!");

    }

    Scanner scan = new Scanner(System.in);
    public void Article(){
        System.out.println("Welcome");
        String fileName = "article.txt";
        String fileTitle = "title.txt";

        ArrayList<String> links = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            

            String line = read.readLine();
            while (line != null){
                links.add(line);
                line = read.readLine();
            }
            read.close();
        }
        catch (IOException e){
            System.err.println("Cannot read the file " + e.getMessage());
            return;
        }
        try{
            
            BufferedReader readTitle = new BufferedReader(new FileReader(fileTitle));

            String title = readTitle.readLine();
            while (title != null){
                titles.add(title);
                title = readTitle.readLine();
            }
            readTitle.close();
        }
        catch (IOException e){
            System.err.println("Cannot read the file " + e.getMessage());
            return;
        }
        
        

        Random random = new Random();
        String getLink = links.get(random.nextInt(links.size()));
        int getIndex = links.indexOf(getLink);

        System.out.println(getLink);
        System.out.println("TITLE: " + titles.get(getIndex));
        System.out.println("Do you want to read this? y for yes and n for no.");
        String input = scan.nextLine().trim().toLowerCase();
        if (input.equals("y")){
            openLink(getLink);
            // break;
        }
        else if (input.equals("n")){
            getLink = links.get(random.nextInt(links.size()));
            System.out.println("TITLE: " + titles.get(getIndex));
        }
        else if (input.equals("exit")){
            System.out.println("Goodbye.");
            // break;
        }
        else{
            System.out.println("Answer not valid. Enter 'y', 'n' or 'exit'.");
        }
    }

    public static void openLink(String url){
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            System.err.println("Error opening link: " + e.getMessage());
        }
    }

    public static void main (String[] args){

       
        
    }
    
}

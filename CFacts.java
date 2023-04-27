/**
 * @authors: Ewura Ama Sam, Princess Asiru-Bologun, Alvin Harrison-Indome
 */

// importing the necessary classes
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CFacts implements ArticleFinder{

    public CFacts(){

    }

    // Prints an introductory message to the user
    public void introMessage(){
        System.out.println("Welcome to the article section.");
        System.out.println("Here, we provide you articles at random");
        System.out.println("Aimed at informing you about climate change.");
        System.out.println("You have the option to read an article or request for a new one.");
        System.out.println("Have Fun!");
        System.out.println(" ");

    }

    Scanner scan = new Scanner(System.in);
    // This method interacts with the user to generate random articles from the database
    public void Article(){
        System.out.println("Hi there!");
        System.out.println(" ");

        // ArrayList to store the links to the articles read from the articles file
        ArrayList<String> links = new ArrayList<>();
        // ArrayList to store the corresponding titles read from the titles file
        ArrayList<String> titles = new ArrayList<>();

        // Reading from the articles file to add the links to the links ArrayList
        try{
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String line = read.readLine();
            while (line != null){
                links.add(line);
                line = read.readLine();
            }
            read.close();
        }
        // Catching an exception of an instance where the file does not exist or cannot be read
        catch (IOException e){
            System.err.println("Cannot read the file " + e.getMessage());
            return;
        }
        
        // Reading from the titles file to add the titles of the articles to the titles ArrayList
        try{
            
            BufferedReader readTitle = new BufferedReader(new FileReader(fileTitle));
            
            String title = readTitle.readLine();
            while (title != null){
                titles.add(title);
                title = readTitle.readLine();
            }
            readTitle.close();
        }
        // Catching an exception of an instance where the file does not exist or cannot be read
        catch (IOException e){
            System.err.println("Cannot read the file " + e.getMessage());
            return;
        }
        
        // Creating an object from the random class to generate an index randomly 
        Random random = new Random();
        // Getting the current generated link and storing it in getLink 
        String getLink = links.get(random.nextInt(links.size()));
        // Getting the index of the current generated link in order to use it to get its title
        int getIndex = links.indexOf(getLink);
        System.out.println("Do you want to read this?");
        // Printing the title of the current generated link to the user
        System.out.println("TITLE: " + titles.get(getIndex));
        System.out.println(" ");
        System.out.print("Type y for yes and n for no or any other key to exit: ");
        System.out.println(" ");
        String input = scan.nextLine().trim().toLowerCase();

        /*If the user types n or N, meaning they do not want to read the particular article, 
         * a new article is generated. This goes on as long as they type n or N
         */
        while (input.equals("n")){
            getLink = links.get(random.nextInt(links.size()));
            getIndex = links.indexOf(getLink);
            System.out.println("Do you want to read this?");
            System.out.println("TITLE: " + titles.get(getIndex));
            System.out.println(" ");
            System.out.print("Type y for yes and n for no or any other key to exit: ");
            System.out.println(" ");
            input = scan.nextLine().trim().toLowerCase();

        }
        
        /*
         *  If the user types y, the generated link (getLink) is passed 
         *  to the openLink method to open the link in the default browser
         */
        if (input.equals("y")){
            openLink(getLink);
        }
        // A condition to requery the user if they type n
        else if (input.equals("n")){
            getLink = links.get(random.nextInt(links.size()));
            getIndex = links.indexOf(getLink);
            System.out.println("Do you want to read this?");
            System.out.println("TITLE: " + titles.get(getIndex));
            System.out.println(" ");
            System.out.print("Type y for yes and n for no or any other key to exit: ");
            System.out.println(" ");
            input = scan.nextLine().trim().toLowerCase();
        }

        // The program closes if the user types any other letter aside y or n
        else{
            System.out.println("Goodbye.");
        }
    }

    /*
     * This method opens the generated link in the browser when the user chooses to read. 
     * The Desktop class allows a Java application to launch associated applications 
     * registered on the native desktop to handle a URI or a file
     * (Java Doc - https://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html). 
     * The Desktop class has methods like getDesktop and browse. The getDesktop class represents 
     * the desktop environment whilst the browse method launches the link in the default browser 
    */
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

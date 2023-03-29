import java.io.*;
import java.util.Scanner;

/*
 * UserWord.java
 * UserWord class contains methods to receive the user's input and determine its validity
 * Owen Wang
 * Last Edited: 25/03/2023
 */
public class UserWord {

    Scanner sc;
    FileReader in;
    BufferedReader br;

    String word;
    String lineOfText;

    /**
     * Constructor
     * Gives word and lineOfText default values
     */
    public UserWord(){
        word = "";
        lineOfText = "";
    }

    /**
     * Prompts the user for their guess
     * Stores guess in the word variable
     */
    public void setGuess(){
        sc = new Scanner(System.in);
        System.out.println("Please enter a word:");
        word = sc.next();
    }

    /**
     * Checks the validity of word
     * @return - validity of guess
     */
    public boolean checkValidity(){
        if(word.length() != 5){ //determines if word length is valid
            if(word.length() > 5){
                System.out.println("The word entered is too long!");
            }else{
                System.out.println("The word entered is too short!");
            }
            return false;
        }

        try{ // ADD CLOSE*****
            File dataFile = new File("src/res/ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while((lineOfText = br.readLine()) != null){
                if(lineOfText.equals(word)){
                    return true;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found");
            System.err.println("FileNotFoundException:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        return false;
    }

    /**
     * Returns the value of the user's guess
     * @return - user guess
     */
    public String getWord(){
        return word;
    }
}

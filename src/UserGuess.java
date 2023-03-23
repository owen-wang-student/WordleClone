import java.io.*;
import java.util.Scanner;

/*
 * UserGuess.java
 * UserGuess class contains methods to receive the user's input and
 * determine its validity
 * Owen Wang
 * Last Edited: 21/03/2023
 */
public class UserGuess {

    Scanner sc;
    FileReader in;
    BufferedReader br;

    String guess; // variable that stores user guess
    String lineOfText; // variable that stores valid words
    // DO I EVEN NEED THESE?

    /**
     * Constructor
     * Gives default values to variables
     */
    public UserGuess(){
        guess = "";
        lineOfText = "";
        generateGuess();
    }

    /**
     * Prompts the user for their guess
     * Stores guess in the guess variable
     */
    public void generateGuess(){
        sc = new Scanner(System.in);
        System.out.println("Please enter a word:");
        guess = sc.next();
        System.out.println(checkValidity(guess));
    }

    /**
     * Checks the validity of word
     *
     * @param guess -  the user's guess
     * @return - validity of guess
     */
    public boolean checkValidity(String guess){

        if(guess.length() != 5){ //determines if word length is valid
            System.out.println("The word you entered is not valid");
            return false;
        }

        try{
            File dataFile = new File("ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while((lineOfText = br.readLine()) != null){
                if(lineOfText.equals(guess)){
                    System.out.println("VALID");
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

    public String getGuess(){
        return guess;
    }
}

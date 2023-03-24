import java.io.*;
import java.util.Scanner;

/*
 * UserGuess.java
 * UserGuess class contains methods to receive the user's input and determine its validity
 * Owen Wang
 * Last Edited: 24/03/2023
 */
public class UserGuess {

    Scanner sc;
    FileReader in;
    BufferedReader br;

    String guess;
    String lineOfText;

    /**
     * Constructor
     * Gives guess and lineOFText default values
     */
    public UserGuess(){
        guess = "";
        lineOfText = "";
        setGuess();
    }

    /**
     * Prompts the user for their guess
     * Stores guess in the guess variable
     */
    public void setGuess(){
        sc = new Scanner(System.in);
        System.out.println("Please enter a word:");
        guess = sc.next();
        System.out.println(checkValidity());
    }

    /**
     * Checks the validity of word
     *
     * @return - validity of guess
     */
    public boolean checkValidity(){
        if(guess.length() != 5){ //determines if word length is valid
            if(guess.length() > 5){
                System.out.println("The word entered is too long!");
            }else{
                System.out.println("The word entered is too short!");
            }
            return false;
        }

        try{ // ADD CLOSE*****
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

    /**
     * Returns the value of the user's guess
     *
     * @return - user guess
     */
    public String getGuess(){
        return guess;
    }
}
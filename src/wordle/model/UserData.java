package wordle.model;

import java.io.*;
import java.util.Scanner;

/*
 * UserData.java
 * UserData class contains methods to receive the user's input and determine its validity
 * Owen Wang
 * Last Edited: 03/04/2023
 */
public class UserData {

    Scanner sc;
    FileReader in;
    BufferedReader br;

    String guess; // user guess
    String lineOfText;

    /**
     * Constructor
     * Gives guess and lineOfText default values
     */
    public UserData(){
        guess = "";
        lineOfText = "";
    }

    /**
     * Prompts the user for their guess
     * Stores guess in the guess variable
     */
    public void setGuess(){
        sc = new Scanner(System.in);
        System.out.println("Please enter a word:");
        guess = sc.next();
        guess = guess.toLowerCase(); // change to lower case

        if(!checkValidity()){ // if the guess is invalid
            setGuess();
        }
    }

    /**
     * Checks the validity of guess
     * @return - validity of guess
     */
    public boolean checkValidity() {
        if(guess.length() != 5){ //determines if word length is valid
            if(guess.length() > 5){
                System.out.println("The word entered is too long!");
            }else{
                System.out.println("The word entered is too short!");
            }
            return false;
        }

        try{
            File dataFile = new File("src/res/ValidWords.txt"); //create file
            in = new FileReader(dataFile); // create file reader
            br = new BufferedReader(in); // create buffered reader

            while((lineOfText = br.readLine()) != null){ //determines if word is in valid words list
                if(lineOfText.equals(guess)){
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
        System.out.println("Guess is not a valid word");
        return false;
    }

    /**
     * Returns the value of the user's guess
     * @return - user guess
     */
    public String getGuess(){
        return guess;
    }
}

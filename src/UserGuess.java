import java.util.Scanner;

/*
 * UserGuess.java
 * UserGuess class contains methods to receive the user's input and
 * determine its validity
 * Owen Wang
 * Last Edited: 21/03/2023
 */
public class UserGuess {

    String guess; // variable that stores user guess

    /**
     * Constructor
     * Gives default value to guess
     */
    public UserGuess(){
        guess = "";
        generateGuess();
    }

    /**
     * Prompts the user for their guess
     * Stores guess in the guess variable
     */
    public void generateGuess(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a word:");
        guess = sc.next();
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

        // add section on checking if it is a valid word

        return true;
    }

    public String getGuess(){
        return guess;
    }
}

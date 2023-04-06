package wordle.model;

import java.util.Arrays;

/*
 * GameData.Java
 * GameData class determines if the user's guess is correct
 * and determines the placement of hints
 * Owen Wang
 * Last Edited: 03/04/2023
 */
public class GameData {

    String guess;
    String word;
    int[] hint; //0-gray, 1-yellow, 2-green
    char[] letter; //contains all the letters of the computer generated word

    /**
     * Constructor
     * Applies default values to variables
     */
    GameData(){
        guess = "";
        hint = new int[5];
        letter = new char[5];

        ComputerData c = new ComputerData();
        c.setWord(c.generateRandom(c.countWords()));
        word = c.getWord();
    }

    /**
     * Compares the user guess to the computer generated word
     * @return - correctness of work
     */
    public boolean checkWord(){
        UserData u = new UserData();
        u.setGuess();
        guess = u.getGuess(); // get user guess

        if(guess.equals(word)){ // guess is correct
            return true;
        }else{ // guess is incorrect
            setLetter();
            setHint();
            System.out.println(word);
            System.out.println(Arrays.toString(getHint()));
            return false;
        }
    }

    /**
     * Adds all the available letters in the computer generated word into the letters array
     * Used in determining yellow hints
     */
    public void setLetter(){
        for(int i = 0; i < word.length(); i++){
            letter[i] = word.charAt(i);
        }
    }

    /**
     * Determines the hints the user wil receive and organizes them in an array
     */
    public void setHint(){
        for(int i = 0; i < guess.length(); i ++){ // loop through all the characters in the guess
            if(guess.charAt(i) == word.charAt(i)){ // character is in the word and correct placement
                hint[i] = 2;
            }else{
                boolean cond = false; // true = in word, false = not in word
                for(int j = 0; j < letter.length; j++){
                    if (letter[j] == guess.charAt(i)) { // character is in the word but incorrect placement
                        hint[i] = 1;
                        letter[j] = ' ';
                        cond = true;
                        break;
                    }
                }
                if(!cond){ // character is not in the word
                    hint[i] = 0;
                }
            }
        }
    }

    /**
     * Returns the array of user hints
     * @return - array of hints
     */
    public int[] getHint(){
        return hint;
    }

}

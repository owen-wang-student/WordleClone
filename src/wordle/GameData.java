package wordle;

/*
 * wordle.GameData.Java
 * wordle.GameData class determines if the user's guess is correct
 * and determines the placement of hints
 * Owen Wang
 * Last Edited: 25/03/2023
 */
public class GameData {

    String guess;
    String word;

    /**
     * Constructor
     * Gives guess and word default values
     */
    GameData(){
        guess = "";
        word = "";
    }

    /**
     * Compares the user guess to the computer generated word
     */
    public void checkWord(){
        UserData u = new UserData();
        u.setGuess();
        guess = u.getGuess();

        ComputerData c = new ComputerData();
        c.setWord(c.generateRandom(c.countWords()));
        word = c.getWord();

        // ADD CHECK WORD PORTION

    }

}

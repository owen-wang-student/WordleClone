/*
 * GameData.Java
 * GameData class determines if the user's guess is correct
 * and determines the placement of hints
 * Owen Wang
 * Last Edited: 25/03/2023
 */
public class GameData {

    String guess;
    String word;

    int turn;
    boolean win;

    /**
     * Constructor
     * Gives guess, word, turn, and win default values
     */
    GameData(){
        guess = "";
        word = "";
        turn = 0;
        win = false;
    }

    /**
     * Checks if the
     */
    public void checkWord(){

        ComputerWord c = new ComputerWord();

        UserWord u = new UserWord();
        u.setGuess();
        if(u.checkValidity()){
            turn += 1;
            guess = u.getWord();
        }else{
            checkWord();
        }

    }

    public void determine(){
        //
    }

}

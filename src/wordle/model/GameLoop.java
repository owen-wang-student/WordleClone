package wordle.model;

public class GameLoop {
    int turn;
    boolean win;

    GameLoop(){
        turn = 0;
        win = false;
    }

    public boolean userTurn(){
        if(turn > 6){
            return false;
        }
        return false;
    }

}

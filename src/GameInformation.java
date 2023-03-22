public class GameInformation {

    int turnNumber;
    String input;
    String computer;
    boolean win;

    GameInformation(){
        turnNumber = 0;
        input = "";
        computer = "";
        win = false;
    }

    public boolean checkWord(){

        UserInformation userInput = new UserInformation();
        input = userInput.getGuess();
        ComputerInformation computerInput = new ComputerInformation();
        computer = computerInput.getWord();

        if(input.equals(computer)){
            return true;
        }else {
            determine();
        }
        return false;
    }

    public void determine(){
        //
    }

}

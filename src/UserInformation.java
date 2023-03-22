import java.util.Scanner;

public class UserInformation {

    String guess;

    public UserInformation(){
        guess = "";
        generateGuess();
    }

    public void generateGuess(){
        Scanner sc = new Scanner(System.in);
        guess = sc.next();
    }

    public String getGuess(){
        return guess;
    }
}

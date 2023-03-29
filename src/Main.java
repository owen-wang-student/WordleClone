/*
 * Main.java
 * Entry point for the program
 * Owen Wang
 * Last Edited: 2023-03-17
 */

public class Main {
    public static void main(String[] args) {
        UserWord u = new UserWord();
        u.setGuess();
        System.out.println(u.checkValidity());
    }
}
package wordle;

import java.io.*;

/*
 * ComputerData.java
 * ComputerData class determines the computer generated word
 * Owen Wang
 * Last Edited 03/04/2023
 */
public class ComputerData {

    FileReader in;
    BufferedReader br;

    String word;
    String lineOfText;

    /**
     * Constructor
     * Gives word and lineOfText default values
     */
    ComputerData(){
        word = "";
        lineOfText = "";
    }

    /**
     * Counts the number of words inside the Valid Words file
     * @return - number of words in the text file
     */
    public int countWords(){
        int count = 0; // number of words in the text fiel

        try{
            File dataFile = new File("src/res/ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while((lineOfText = br.readLine()) != null){ //read until nothing left
                count += 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.err.println("FileNotFoundException:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        return count;
    }

    /**
     * Generates the index of the random word to be chosen
     * @param upper - number of words in the text file
     * @return - random value between 1 -> upper
     */
    public int generateRandom(int upper){
        return (int) ((Math.random() * (upper - 1)) + 1);
    }

    /**
     * Randomly generates the value of a word from a list of valid words
     */
    public void setWord(int lineNumber) {
        int count = 0;

        try{
            File dataFile = new File("src/res/ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while(count < lineNumber){ //set word to the nth word int he text file
                word = br.readLine();
                count += 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.err.println("FileNotFoundException:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }

    /**
     * Returns the value of the computer generated word
     * @return - computer generated word
     */
    public String getWord(){
        return word;
    }
}

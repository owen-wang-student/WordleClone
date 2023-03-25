import java.io.*;

/*
 * ComputerWord.java
 * ComputerWord class determines the computer generated word
 * Owen Wang
 * Last Edited 25/03/2023
 */
public class ComputerWord {

    FileReader in;
    BufferedReader br;

    String word;
    String lineOfText;

    /**
     * Constructor
     * Gives word and lineOfText default values
     */
    ComputerWord(){
        word = "";
        lineOfText = "";
        setWord(generateRandom(countWords()));
    }

    /**
     * Counts the number of words inside the Valid Words file
     * @return - number of words in the text file
     */
    public int countWords(){
        int count = 0;

        try{
            File dataFile = new File("ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while((lineOfText = br.readLine()) != null){
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
            File dataFile = new File("ValidWords.txt");
            in = new FileReader(dataFile);
            br = new BufferedReader(in);
            while(count < lineNumber){
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

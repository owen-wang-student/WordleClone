package wordle.view;

import javax.swing.*;
import java.awt.*;

/*
 * GamePanel.java
 * Displays the main game that the user interacts with
 * Owen Wang
 * Last Edited: 08/04/2023
 */
public class GamePanel {

    public GamePanel(){
        //Creating the Frame
        JFrame frame = new JFrame("Game Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        frame.setVisible(true);
    }

}

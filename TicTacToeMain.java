/*
 *  File Name: TicTacToeMain.java
 *  Author: Jason Boyd
 *  Date: Dec.5.2023
 *  Goal: to reveal object (aka my tic tac toe game).
 */

import javax.swing.*;

public class TicTacToeMain
{
    public static void main(String[] args)
    {
        // Use the Swing invoke later method to call the objects
            // helps with a stable and responsive GUI
        SwingUtilities.invokeLater(() ->
        {
            // Single Player Game
            Moves singlePlayerGame = new Moves();
            TicTacToeGUI singlePlayerGUI = new TicTacToeGUI(singlePlayerGame);
            singlePlayerGUI.setVisible(true);
        });
    }

}
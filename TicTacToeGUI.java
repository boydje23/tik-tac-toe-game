/*
 *  File Name: TicTacToeGUI.java
 *  Author: Jason Boyd
 *  Date: Dec.5.2023
 *  Goal: The interface class that sets up the GUI and lets teh user interact with it.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToeGUI extends JFrame
{
    private TicTacToeBasics game;
    private JButton[][] buttons;

    // Create the GUI with title, size of display, and grid layout
    public TicTacToeGUI(TicTacToeBasics game)
    {
        this.game = game;

        setTitle("Tic Tac Toe Game!");
        setSize(1000, 800);
        // close the program on frame closure. (Clicking the x button on the window)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
    }

    // Initialize the buttons
    private void initializeButtons()
    {
        // create a 3x3 grid of Jbuttons
        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // Create a Jbutton for the current cell
                JButton button = new JButton();
                //set font
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
                // add ButtonClickListener to handle button clicks for a certain cell i,j
                button.addActionListener(new ButtonClickListener(i, j));
                // Assign the button to the corresponding i,j position
                buttons[i][j] = button;
                // add the button to the GUI!!!
                add(button);
            }
        }
    }

    // Action listener implementation for handling button clicks in the game
    private class ButtonClickListener implements ActionListener
    {
        // Store the row and column of the button associated with the listener
        private int row;
        private int col;

        // constructor to initialize the row and column
        public ButtonClickListener(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        // override method called when the button is clicked
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (game.getBoardMark(row, col) == ' ' && !game.gameWon)
            {
                game.makeMove(row, col);
                buttons[row][col].setText(String.valueOf(game.getBoardMark(row, col)));
                checkGameStatus();
            }
        }

        // if game is won announce what player won
        // if game is drawn announce that the game is drawn
        private void checkGameStatus()
        {
            if (game.gameWon)
            {
                JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer() + " wins!");
            } else if (game.isBoardFull()) {
                JOptionPane.showMessageDialog(null, "It's a draw!");
            }
        }
    }
}
/*
 *  File Name: Moves.java
 *  Author: Jason Boyd
 *  Date: Dec.5.2023
 *  Goal: Extended class of TicTacToeBasics that allows players to select a spot and move while also checking
 *        for the win condition.
 */

public class Moves extends TicTacToeBasics
{
    private int moves;

    public Moves()
    {
        super();
        moves = 0;
    }

    public Moves(int moves)
    {
        super();
        moves = 0;
    }

    @Override
    public void makeMove(int row, int col)
    {
        // If the selected spot is empty and the game isn't over
        if (board[row][col] == ' ' && !gameWon)
        {
            // define the space with the current player's char(x or o)
            board[row][col] = currentPlayer;
            // increase the number of made moves
            moves++;
            // check to see if that move satisfied the win condition
            gameWon = checkForWinner();

            if (!gameWon && moves < 9)
            {
                // Switch player for the next move
                // Short hand for an if else statement

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                /* Another way to write it
                if (currentPlayer == 'X')
                {
                    currentPlayer = 'O';
                }
                else
                {
                    currentPlayer = 'X';
                }
                */
            }
        }
    }

    public boolean checkForWinner()
    {
        // Check the rows and columns
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
            {
                return true; // Three in a row (horizontal)
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
            {
                return true; // Three in a column (vertical)
            }
        }

        // Check for the diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
        {
            return true; // Diagonal from top-left to bottom-right
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
        {
            return true; // Diagonal from top-right to bottom-left
        }

        return false; // No winner yet
    }

}
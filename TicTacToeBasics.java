/*
 *  File Name: TicTacToeBasics.java
 *  Author: Jason Boyd
 *  Date: Dec.5.2023
 *  Goal: The base class that initializes the board, player, and checks win condition.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class TicTacToeBasics
{
    // 2D array to represent the board
    protected char[][] board;

    // Current player (X or O)
    protected char currentPlayer;

    // flag weather th game has been won or not
    protected boolean gameWon;

    // Default constructor
    public TicTacToeBasics()
    {
        board = new char[3][3];
        currentPlayer = 'X';
        gameWon = false;

        // Initialize the board
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    // Constructor with parameters to set the initial state of the game
    public TicTacToeBasics(char[][] board,char currentPlayer)
    {
        board = new char[3][3];
        currentPlayer = 'O';
        gameWon = false;

        // Initialize the board
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    // Constructor with parameters to set the initial current player
    public TicTacToeBasics(char currentPlayer)
    {
        board = new char[3][3];
        currentPlayer = 'X';
        gameWon = false;

        // Initialize the board
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    // abstract method to be used by a subclass to make a move on the board
    public abstract void makeMove(int row, int col);

    // abstract method to be used by a subclass to check for a winner
    public abstract boolean checkForWinner();

    // Check to see if the board is full
    public boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == ' ')
                {
                    return false; // There is an empty space, board is not full
                }
            }
        }
        return true; // Board is full
    }

    // Setter methods for updating the current player, board, and game won status
    public void setCurrentPlayer(char currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }

    public void setBoard(char[][] board)
    {
        this.board = board;
    }

    public void setGameWon(boolean gameWon)
    {
        this.gameWon = gameWon;
    }

    // getter method for retrieving the current player and the mark for a cell on the board
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }

    public char getBoardMark(int row, int col)
    {
        return board[row][col];
    }
}

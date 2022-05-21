/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author sarav
 */
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.*;

public  class TicTacToe extends JFrame{
	private Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private boolean winner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	private int count;
                  GameSelection s1 = new GameSelection();
	public  TicTacToe() {
		pane = getContentPane();
	    pane.setLayout(new GridLayout(3,3));
                      setTitle("Tic Tac Toe");
	    setSize(500,500);
	    setResizable(false);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    currentPlayer = "x";
	    board = new JButton[3][3];
	    winner = false;
	    startBoard(); 
	    addMenubar();
	    setVisible(true);
	   	}
        
	private void addMenubar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
			});
		quit = new JMenuItem("Main menu");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameSelection s1 = new GameSelection();
                                                                         s1.setVisible(true); 
                                                                         setVisible(false);
			}
			});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		}

	private void winner(){
        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            printwinner(currentPlayer);
            winner = true;
        }
        else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
           
           printwinner(currentPlayer);
            winner = true;
        }
        else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
           
            printwinner(currentPlayer);
            winner = true;
        }
        else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            
          printwinner(currentPlayer);
            
            winner = true;
        }
        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
           
           printwinner(currentPlayer);
            winner = true;
        }
        else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
            
            printwinner(currentPlayer);
            winner = true;
        }
        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
            
            printwinner(currentPlayer);
            winner = true;
        }
        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            
            printwinner(currentPlayer);
            winner = true;
        }else if (count == 8) {
              
                    
                  printwinner("No");
        	winner = false;
        	count = 0;
        }
        }
	public void resetBoard() {
		currentPlayer = "x";
		winner = false;
	    int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3;j++) {
				board[i][j].setText("");
			}
		}
	}
	private void startBoard() { 
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3;j++) {
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SERIF,Font.BOLD,100));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getText().equals("") && winner ==  false) {
							btn.setText(currentPlayer);
							winner();
							switchPlayer();
						}
					}
				});
				pane.add(btn);
			}
		}
	}
	private void switchPlayer() {
		
		if(currentPlayer.equals("x"))
			currentPlayer = "0";
		else
			currentPlayer = "x";
		count++;
		
	}
        private void printwinner(String currentPlayer){
            int result = JOptionPane.showConfirmDialog(null,currentPlayer+" player has won. Do you want to play again?");
      switch (result) {
         case JOptionPane.YES_OPTION:
         setVisible(false);
         new TicTacToe();
         break;
         case JOptionPane.NO_OPTION:              
         s1.setVisible(true); 
         setVisible(false);
         break;
         case JOptionPane.CANCEL_OPTION:
         s1.setVisible(true); 
         setVisible(false);
         break;
         case JOptionPane.CLOSED_OPTION:
         s1.setVisible(true); 
         setVisible(false);
         break;
      }
        }
	public static void main(String[]args) {
                                    
		new TicTacToe();
      
	}
}

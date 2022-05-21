package game;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class puzzle extends JFrame{
	private Container pane;
	private JButton [][] board;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private boolean winner = false;
    GameSelection s1 = new GameSelection();
	public puzzle(){
		pane = getContentPane();
		pane.setLayout(new GridLayout(4,4));
		setTitle("Puzzle");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		board = new JButton[4][4];
                                    
		setboard();
    	setPattern();
		addMenubar();
		setVisible(true);
	    for(int x = 0; x < 4; x++) {
			for(int y = 0;y < 4;y++) {
				board[x][y].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int n[] = findblank();
						int i = n[0];
						int j = n[1];
						if(i==0 && j == 0) {
						     button2 =  board[i][j+1];
						     button4 =  board[i+1][j];  
						     if(e.getSource()==button2) {
									moviepiece(i,j,i,j+1);
						     }		
						     if(e.getSource()==button4) {
									moviepiece(i,j,i+1,j);
						     }
							}
						if(i==0 && j == 3) {
							  button1 =  board[i][j-1];
						      button4 =  board[i+1][j];
						      if(e.getSource()==button1) {
									moviepiece(i,j,i,j-1);
						      }
						      if(e.getSource()==button4) {
									moviepiece(i,j,i+1,j);	
						      }
						}
						if(i==3 && j == 0) {
						     button2 =  board[i][j+1];
						     button3 =  board[i-1][j];		     
						     if(e.getSource()==button2) {
									moviepiece(i,j,i,j+1);
						     }					
						     if(e.getSource()==button3) {
									moviepiece(i,j,i-1,j);
						     }
							}
						if(i==3 && j == 3) {
							 button1 =  board[i][j-1];
						     button3 =  board[i-1][j];  
						     if(e.getSource()==button1) {
									moviepiece(i,j,i,j-1);
						     }					
						     if(e.getSource()==button3) {
						    	 	moviepiece(i,j,i-1,j);
						     }
						}
						 if(i < 3 && i > 0 && j==0) {
						     button2 =  board[i][j+1];
						     button3 =  board[i-1][j];
						     button4 =  board[i+1][j];
						     if(e.getSource()==button2) {
									moviepiece(i,j,i,j+1);
						     }
						     if(e.getSource()==button3) {
									moviepiece(i,j,i-1,j);
						     }
						     if(e.getSource()==button4) {
									moviepiece(i,j,i+1,j);
						     }
						}
						 if(i==0 && j<3 && j > 0) {
							 button1 =  board[i][j-1];
						     button2 =  board[i][j+1];
						     button4 =  board[i+1][j];
						     if(e.getSource()==button1) {
									moviepiece(i,j,i,j-1);
						     }
						     if(e.getSource()==button2) {
									moviepiece(i,j,i,j+1);
						     }
						     if(e.getSource()==button4) {
									moviepiece(i,j,i+1,j);
						     }
							}
						 if(i < 3 && i > 0 && j==3) {
							 button1 =  board[i][j-1];
						     button3 =  board[i-1][j];
						     button4 =  board[i+1][j];
						     if(e.getSource()==button1) {
									moviepiece(i,j,i,j-1);
					         }		
						     if(e.getSource()==button3) {
									moviepiece(i,j,i-1,j);
						     }
						     if(e.getSource()==button4) {
									moviepiece(i,j,i+1,j);
							 }
						     }
						 if(i==3&&j<3 && j>0) {
							 button1 =  board[i][j-1];
						     button2 =  board[i][j+1];
						     button3 =  board[i-1][j];    
						     if(e.getSource()==button1) {
										moviepiece(i,j,i,j-1);
						     }
						     if(e.getSource()==button2) {
										moviepiece(i,j,i,j+1);
						     }
						     if(e.getSource()==button3) {
										moviepiece(i,j,i-1,j);
						     }	    
						}
						 if (i<3 && i>0 && j > 0 && j < 3)
							{
								 button1 =  board[i][j-1];
							     button2 =  board[i][j+1];
							     button3 =  board[i-1][j];
							     button4 =  board[i+1][j];
							     if(e.getSource()==button1) {
											moviepiece(i,j,i,j-1);
							     }
							     if(e.getSource()==button2) {
											moviepiece(i,j,i,j+1);
							     }
							     if(e.getSource()==button3) {
											moviepiece(i,j,i-1,j);
							     }
							     if(e.getSource()==button4) {
											moviepiece(i,j,i+1,j);
							     }
							}
				 }});
			}
		}
		}
	private void addMenubar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPattern();
			}
			});
		quit = new JMenuItem("Main menu");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                                                                         s1.setVisible(true); 
                                                                         setVisible(false);
			}

                    private void systemexit(int i) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
			});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		}		
	public void setboard() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0;j < 4;j++) {
				JButton btn = new JButton();
				board[i][j] = btn;
				board[i][j].setText("");
				pane.add(board[i][j]);
			}
		}
	}
	public void setPattern(){
		String []numbers = { "1", "2", "3", "4", "5", "6", "7" , "8", "9", "10", "11", "12", "13", "14", "15"};
		List<String> intList = Arrays.asList(numbers);
		Collections.shuffle(intList);
		intList.toArray(numbers);
		 for(int i = 0; i < 4; i++) {
			 for(int j = 0 ; j < 4 ; j++) { 
				if(i*4+j!=15) {
				board[i][j].setText(numbers[i*4 + j]);
				}else
				{
				 board[i][j].setText("");
				}
			}
		 }
	}
	public int[] findblank() {
		int[] id = {3,3};
		for(int i=0;i<=3;i++) 
			for(int j=0;j<=3;j++){
			if(board[i][j].getText().equals("")) {
			 id[0] = i;
			 id[1] = j;
		     return id;
			}
		}
		return id;
	}
	void moviepiece(int i, int j, int x, int y) {
	String value = board[x][y].getText();
    String empty = board[i][j].getText();
	board[i][j].setText(value);
	board[x][y].setText(empty);
	winnercheck();
	}
	void winnercheck() {
		if(board[0][0].getText().equals("1")&&board[0][1].getText().equals("2")&&board[0][2].getText().equals("3")&&board[0][3].getText().equals("4")&&board[1][0].getText().equals("5")&&board[1][1].getText().equals("6")&&board[1][2].getText().equals("7")&&board[1][3].getText().equals("8")&&board[2][0].getText().equals("9")&&board[2][1].getText().equals("10")&&board[2][2].getText().equals("11")&&board[2][3].getText().equals("12")&&board[3][0].getText().equals("13")&&board[3][1].getText().equals("14")&&board[3][2].getText().equals("15")&&board[3][3].getText().equals("")){
                                                        int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
      switch (result) {
         case JOptionPane.YES_OPTION:
         setVisible(false);
         new puzzle();
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
                            
	}
public static void main(String[]args) {
	new puzzle();
}
}
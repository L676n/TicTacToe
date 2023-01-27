
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TicTacToe extends JFrame{

    JPanel Panel;
    JPanel buttonsPanel;
    JButton newGameButton;
    JButton exitButton;
    JLabel[] labels;
    int gameBoard[]; 
    String letter; 		
      
    
    public TicTacToe(){
        
        setTitle("Tic Tac Toe");
        setSize(600, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        buildLabelsPanel();
        buildButtonPanel();
        
        
        add(Panel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        
       
        
        setVisible(true);
    }
    
    public void buildLabelsPanel(){
        
      Panel = new JPanel();
        
      Panel.setLayout(new GridLayout(3,3));
        
     
      labels = new JLabel[9];

      
      for(int i = 0; i < 9; i++){
          
        labels[i] = new JLabel();
        labels[i].setFont(new Font("Dialog", Font.BOLD, 72));
        Panel.add(labels[i]);
      }
    }
    
    public void buildButtonPanel(){
        
        buttonsPanel = new JPanel();
        
        
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ButtonListener());
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ButtonListener());
        
        buttonsPanel.add(newGameButton);
        buttonsPanel.add(exitButton);
    }
    
   private void gameBoard(){
       
    Random rand = new Random();
      
    
    gameBoard = new int[9];
      
   
    for(int i = 0; i < 9; i++){
        
        gameBoard[i] = rand.nextInt(2);
         
        
        if (gameBoard[i] == 1)
        letter = "X";
        else
        letter = "O";
         
        labels[i].setText(letter);
    }     
   }
   
    private void showResult(){
        
       
       if(gameBoard[0] == 1 && gameBoard[1] == 1 && gameBoard[2] == 1 ||
          gameBoard[3] == 1 && gameBoard[4] == 1 && gameBoard[5] == 1 ||
          gameBoard[6] == 1 && gameBoard[7] == 1 && gameBoard[8] == 1 ||
          gameBoard[0] == 1 && gameBoard[3] == 1 && gameBoard[6] == 1 ||
          gameBoard[1] == 1 && gameBoard[4] == 1 && gameBoard[7] == 1 ||
          gameBoard[2] == 1 && gameBoard[5] == 1 && gameBoard[8] == 1 ||
          gameBoard[0] == 1 && gameBoard[4] == 1 && gameBoard[8] == 1 ||
          gameBoard[2] == 1 && gameBoard[4] == 1 && gameBoard[6] == 1)
          JOptionPane.showMessageDialog(null, "X wins!");
       
        //Will be excuted if O wins 
       else if(gameBoard[0] == 0 && gameBoard[1] == 0 && gameBoard[2] == 0 ||
         gameBoard[3] == 0 && gameBoard[4] == 0 && gameBoard[5] == 0 ||
         gameBoard[6] == 0 && gameBoard[7] == 0 && gameBoard[8] == 0 ||
         gameBoard[0] == 0 && gameBoard[3] == 0 && gameBoard[6] == 0 ||
         gameBoard[1] == 0 && gameBoard[4] == 0 && gameBoard[7] == 0 ||
         gameBoard[2] == 0 && gameBoard[5] == 0 && gameBoard[8] == 0 ||
         gameBoard[0] == 0 && gameBoard[4] == 0 && gameBoard[8] == 0 ||
         gameBoard[2] == 0 && gameBoard[4] == 0 && gameBoard[6] == 0)
         JOptionPane.showMessageDialog(null, "O wins!");
         
      // Will be excuted if the game was a tie
      else
         JOptionPane.showMessageDialog(null, "The game was a tie!");
   }
    
    
    private class ButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == newGameButton){
                
                gameBoard();
                showResult();
            }
            
            else
            {
                System.exit(0);
            }
        }
    }
    
  
    public static void main(String[] args){
        new TicTacToe();
    }
}

    


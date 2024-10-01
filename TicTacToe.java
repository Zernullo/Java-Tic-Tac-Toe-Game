package Project7;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	Random random = new Random();
	
	JPanel panel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	JLabel textfield = new JLabel();
	JButton[] button = new JButton[9];
	
	boolean player_1or2_Turn;
	
	public TicTacToe() {
		// TODO Auto-generated constructor stub
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		
		textfield.setBackground(new Color(25,25,25));//background color
		textfield.setForeground(new Color(25,255,0));//text color
		textfield.setFont(new Font("Times New Roman", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		panel.setLayout(new BorderLayout());
		panel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			buttonPanel.add(button[i]);
			button[i].setFont(new Font("Times New Roman", Font.BOLD, 120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		panel.add(textfield);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		frame.setVisible(true);
		
		turn();
	}
	
	public void turn(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2) == 0) {//Get a number either 0 or 1
			player_1or2_Turn = true;
			textfield.setText("X Turn");
		}
		else {
			player_1or2_Turn = false;
			textfield.setText("O Turn");
		}
	}
	
	public void check() {
		//check X win conditions
		if((button[0].getText() == "X" &&
			button[1].getText() == "X" &&
			button[2].getText() == "X" )) {
			
			xwins(0,1,2);
		}
		
		if((button[3].getText() == "X" &&
			button[4].getText() == "X" &&
			button[5].getText() == "X" )) {
			
			xwins(3,4,5);	
		}
		
		if((button[6].getText() == "X" &&
			button[7].getText() == "X" &&
			button[8].getText() == "X" )) {
				
			xwins(6,7,8);
		}
		if((button[0].getText() == "X" &&
			button[3].getText() == "X" &&
			button[6].getText() == "X" )) {
			
			xwins(0,3,6);
		}
		
		if((button[1].getText() == "X" &&
			button[4].getText() == "X" &&
			button[7].getText() == "X" )) {
			
			xwins(1,4,7);
		}
		if((button[2].getText() == "X" &&
			button[5].getText() == "X" &&
			button[8].getText() == "X" )) {
			
			xwins(2,5,8);	
		}
		if((button[0].getText() == "X" &&
			button[4].getText() == "X" &&
			button[8].getText() == "X" )) {
			
			xwins(0,4,8);
		}
		if((button[2].getText() == "X" &&
			button[4].getText() == "X" &&
			button[6].getText() == "X" )) {
			
			xwins(2,4,6);
		}
		
		//check O win condition
		if((button[0].getText() == "O" &&
				button[1].getText() == "O" &&
				button[2].getText() == "O" )) {
				
				owins(0,1,2);
			}
			
			if((button[3].getText() == "O" &&
				button[4].getText() == "O" &&
				button[5].getText() == "O" )) {
				
				owins(3,4,5);	
			}
			
			if((button[6].getText() == "O" &&
				button[7].getText() == "O" &&
				button[8].getText() == "O" )) {
					
				owins(6,7,8);
			}
			if((button[0].getText() == "O" &&
				button[3].getText() == "O" &&
				button[6].getText() == "O" )) {
				
				owins(0,3,6);
			}
			
			if((button[1].getText() == "O" &&
				button[4].getText() == "O" &&
				button[7].getText() == "O" )) {
				
				owins(1,4,7);
			}
			if((button[2].getText() == "O" &&
				button[5].getText() == "O" &&
				button[8].getText() == "O" )) {
				
				owins(2,5,8);	
			}
			if((button[0].getText() == "O" &&
				button[4].getText() == "O" &&
				button[8].getText() == "O" )) {
				
				owins(0,4,8);
			}
			if((button[2].getText() == "O" &&
				button[4].getText() == "O" &&
				button[6].getText() == "O" )) {
				
				owins(2,4,6);
			}
	}

	public void xwins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		
		for(int i = 0; i < button.length; i++) {
			button[i].setEnabled(false);
		}
		textfield.setText("X Wins");

	}
	public void owins(int a, int b, int c) {
		button[a].setBackground(Color.green);
		button[b].setBackground(Color.green);
		button[c].setBackground(Color.green);
		
		for(int i = 0; i < button.length; i++) {
			button[i].setEnabled(false);
		}
		textfield.setText("O Wins");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < button.length; i++) {
			if(e.getSource() == button[i]) {
				
				if(player_1or2_Turn) {
					if(button[i].getText() == "") {//check if there is a text on the button
						button[i].setForeground(Color.blue);
						button[i].setText("X");
						
						player_1or2_Turn = false;
						textfield.setText("O Turn");
						check();
					}
					
				}
				else {
					if(button[i].getText() == "") {//check if there is a text on the button
						button[i].setForeground(Color.red);
						button[i].setText("O");
						
						player_1or2_Turn = true;
						textfield.setText("X Turn");
						check();
					}
				}
			}
		}
	}

}

package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.GameEngine;
import data.Board;
import data.Player;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class SwingUI extends JFrame implements UI{

	private JPanel contentPane;
	private JButton squares[][] = new JButton[3][3];
	
	private JLabel labelGame;
	private int squareSelected = -1;
	private boolean select = false;
	private int menuOption = -1;
	private int counter = 0;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public SwingUI() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jhjan\\Documents\\Java Ecl\\TicTacToe\\TicTacToe\\images\\icon\\tic.png"));
		setForeground(Color.WHITE);
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(383,350);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setForeground(Color.BLACK);
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new LineBorder(new Color(50, 205, 50), 4, true));
		panelSuperior.setBackground(new Color(230, 230, 250));
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		labelGame = new JLabel("Welcome to Tic Tac Toe");
		panelSuperior.add(labelGame);
		labelGame.setForeground(new Color(255, 69, 0));
		labelGame.setFont(new Font("Open Sans Semibold", Font.PLAIN, 14));
		
		
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(255, 255, 255));
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(UIManager.getColor("Button.highlight"));
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(3, 3, 0, 0));
		for(int i = 0; i < 3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				this.squares[i][j] = new JButton();
				panelCentral.add(this.squares[i][j]);
				this.squares[i][j].setEnabled(false);
				this.squares[i][j].setFont(new Font("Verdana", Font.BOLD, 18));
			}
		}
			
			
			JButton btnNewButton_9 = new JButton("New Game");
			btnNewButton_9.setForeground(new Color(255, 69, 0));
			btnNewButton_9.setFont(new Font("Verdana", Font.BOLD, 14));
			btnNewButton_9.setBackground(new Color(30, 144, 255));
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					squareSelected = -1;
					menuOption = 1;
					boardState(true);
					changeColor();

				}
			});
			panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelInferior.add(btnNewButton_9);
			
			JButton btnNewButton = new JButton("Exit");
			btnNewButton.setForeground(new Color(255, 69, 0));
			btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
			btnNewButton.setBackground(new Color(50, 205, 50));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 System.exit(0);
				}
			});
			panelInferior.add(btnNewButton);
		
		
		
		
		squares[0][0].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(1);
			}
		});
		
		squares[0][1].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(2);
			}
		});
		
		squares[0][2].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(3);
			}
		});
		squares[1][0].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(4);
			}
		});
		squares[1][1].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(5);
			}
		});
		squares[1][2].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(6);
			}
		});
		squares[2][0].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(7);
			}
		});
		squares[2][1].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(8);
			}
		});
		
		squares[2][2].addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent e) {
				selectSquare(9);
			}
		});
        this.setVisible(true);
		
		
	}
	
	
	
	
	
	public void selectSquare(int square)
	{
		squareSelected = square;

	}
	

	@Override
	public void printWelcome(Player player1, Player player2) {
		labelGame.setText("Welcome "+player1+" and "+player2);
		
	}


	@Override
	public int askMovement(Board board, char player) {
		
		printBoard(board);
		labelGame.setText("Your turn");
		int lastSelected = squareSelected;
		while(lastSelected == squareSelected)
		{
			pause();
		}
		return squareSelected;
	}


	@Override
	public int askMenuOption() {
		  while (menuOption == -1) {
	            pause();
	        }
	        return menuOption;
	}


	@Override
	public void printError(String error) {
		
	}


	@Override
	public void printBoard(Board board) {
		for(int i = 0; i < 3;i++)
		{
			for(int j = 0; j<3;j++)
			{
				this.squares[i][j].setText(board.getBoard()[i][j].toString());
				
				
			}
		}
		
		
	}


	@Override
	public void printWinner(Player player) {
		boardState(false);
		labelGame.setText("Game Over");	
		if(player.isHumanPlayer())
		{
			JOptionPane.showMessageDialog(this,"You Win!","Congratulations", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{		
			JOptionPane.showMessageDialog(this,"You lost","Game Over", JOptionPane.INFORMATION_MESSAGE);	
		}
		
	}


	@Override
	public void printTie() {
		boardState(false);
		JOptionPane.showMessageDialog(this,"Tie","Game Over", JOptionPane.INFORMATION_MESSAGE);
	}


	@Override
	public void printMenu() {
		menuOption = -1;
	}
	
	public void boardState(boolean state)
	{
		for(int i = 0; i < 3;i++)
		{
			for(int j = 0; j <3; j++)
			{
				squares[i][j].setEnabled(state);
			}
		}
	}
	
	public void pause()
	{
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			 Logger.getLogger(SwingUI.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public void changeColor(int index,char symbolPlayer)
	{
		
			int row = (index - 1) / 3;
	        int col = (index - 1) % 3;
			if(symbolPlayer == 'X')
			{
				
		        this.squares[row][col].setForeground(new Color(50, 205, 50));	
			}
			else
			{
				this.squares[row][col].setForeground(new Color(255,0 ,0 ));	
				
			}
			
		
	}
	public void changeColor()
	{
			for(int i = 0; i<3;i++)
			{
				for(int j = 0; j<3; j++)
				{
					this.squares[i][j].setForeground(new Color(1,1 ,1 ));	
					
				}
			}
	}

}

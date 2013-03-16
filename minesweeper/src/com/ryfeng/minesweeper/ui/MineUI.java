package com.ryfeng.minesweeper.ui;

import javax.swing.JFrame;

import com.ryfeng.minesweeper.abs.Board;

public class MineUI {
	
	public MineUI() {
		JFrame frame = new JFrame("Minesweeper!");
		
		Board board = new Board(9, 9, 10);
		board.generateBoard();
		MinePanel panel = new MinePanel(board);
		frame.setContentPane(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MineUI();
	}
	
}

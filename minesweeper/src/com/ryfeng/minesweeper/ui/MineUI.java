package com.ryfeng.minesweeper.ui;

import javax.swing.JFrame;

import com.ryfeng.minesweeper.abs.Board;

public class MineUI {

	private JFrame frame;
	
	public MineUI() {
		frame = new JFrame();
		MinePanel panel = new MinePanel(new Board(9, 9, 10));
		frame.setContentPane(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minesweeper!");
	}
	
}

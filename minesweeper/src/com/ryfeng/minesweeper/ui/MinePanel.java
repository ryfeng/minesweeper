package com.ryfeng.minesweeper.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ryfeng.minesweeper.abs.Board;

public class MinePanel extends JPanel {
	
	private class MineListener implements ActionListener {
		private final Board board;
		private final int x,y;
		
		public MineListener(Board board, int x, int y) {
			this.board = board;
			this.x = x;
			this.y = y;
		}
		
		public void actionPerformed(ActionEvent e) {
			int result = board.move(x, y);
			
			JButton button = (JButton) e.getSource();
			button.setText(String.valueOf(result));
		}
	}
	
	public MinePanel(final Board board) {
		super();
		
		int width = board.getWidth();
		int height = board.getHeight();
		this.setLayout(new GridLayout(width, height));
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				JButton button = new JButton("");
				this.add(button);
				button.addActionListener(new MineListener(board, i, j));
			}
		}
	}
	
}

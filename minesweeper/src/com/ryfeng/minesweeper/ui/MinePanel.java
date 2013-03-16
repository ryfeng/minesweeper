package com.ryfeng.minesweeper.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ryfeng.minesweeper.abs.Board;

public class MinePanel extends JPanel {
	
	private JButton[][] buttons;
	
	private class MineListener implements ActionListener {
		private final Board board;
		private final int x,y;
		
		public MineListener(Board board, int x, int y) {
			this.board = board;
			this.x = x;
			this.y = y;
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			reveal(button);
		}
		
		public void reveal(JButton button) {
			int result = board.move(x, y);
			button.setText(String.valueOf(result));
			if (result == 0) {
				if (x != 0) {
					if (y != 0) {
						clickIfUnrevealed(buttons[x-1][y-1]);
					}
					clickIfUnrevealed(buttons[x-1][y]);
					if (y < board.getHeight() - 1) {
						clickIfUnrevealed(buttons[x-1][y+1]);
					}
				}
				if (y != 0) {
					clickIfUnrevealed(buttons[x][y-1]);
				}
				if (y < board.getHeight() - 1) {
					clickIfUnrevealed(buttons[x][y+1]);
				}
				if (x < board.getWidth() - 1) {
					if (y != 0) {
						clickIfUnrevealed(buttons[x+1][y-1]);
					}
					clickIfUnrevealed(buttons[x+1][y]);
					if (y < board.getHeight() - 1) {
						clickIfUnrevealed(buttons[x+1][y+1]);
					}
				}
			}
		}
	}
	
	public MinePanel(final Board board) {
		super();
		
		int width = board.getWidth();
		int height = board.getHeight();
		this.setLayout(new GridLayout(width, height));
		
		buttons = new JButton[width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				JButton button = new JButton("   ");
				this.add(button);
				buttons[i][j] = button;
				button.addActionListener(new MineListener(board, i, j));
			}
		}
	}
	
	private void clickIfUnrevealed(final JButton button) {
		if (button.getText() == "   ") {
			((MineListener) button.getActionListeners()[0]).reveal(button);
		}
	}
	
}

package com.ryfeng.minesweeper.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ryfeng.minesweeper.abs.Board;

public class MinePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9095360309171443449L;
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
			
			if (result > 0) {
				button.setText(String.valueOf(result));
			} else {
				button.setText("  ");
			}
			
			switch(result) {
				case 0: button.setEnabled(false); button.setBackground(new Color(192, 192, 192)); break;
				case 1: button.setForeground(Color.BLUE); break;
				case 2: button.setForeground(Color.GREEN); break;
				case 3: button.setForeground(Color.RED); break;
				case 4: button.setForeground(new Color(128, 0, 128)); break; // Purple
				case 5: button.setForeground(new Color(195, 33, 72)); break; // Maroon
				case 6: button.setForeground(new Color(64, 224, 208)); break; // Turquoise
				case 7: button.setForeground(Color.BLACK); break;
				case 8: button.setForeground(new Color(128, 128, 128)); break; // Gray
				case -1: button.setBackground(Color.BLACK); break;
				default: break;
			}
				
			
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
				button.setBackground(new Color(160, 160, 160));
				button.setFocusPainted(false);
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

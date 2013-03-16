package com.ryfeng.minesweeper.abs;

import java.util.Random;

/**
 * Abstract data representation for board
 * 
 * @author Royce Feng
 *
 */
public class Board {

	private final int width, height;
	private int[][] board;
	private int mines;
	private Random gen;
	
	public Board(int width, int height, int mines) {
		// One extra column/row for edges (no mines placed on these)
		board = new int[width+2][height+2];
		this.width = width;
		this.height = height;
		this.mines = mines;
		gen = new Random();
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	/**
	 * Unseeded generation
	 */
	public void generateBoard() {
		// Place all the mines first
		int minesLeft = mines;
		while (minesLeft > 0) {
			int pos = gen.nextInt(width * height);
			int x = (int) Math.floor(pos % height);
			int y = (int) Math.floor(pos / height);
			if (board[x+1][y+1] != -1) {
				minesLeft--;
				board[x+1][y+1] = -1;
				// Increment the neighbors
				if (board[x][y] != -1) {
					board[x][y]++;
				}
				if (board[x+1][y] != -1) {
					board[x+1][y]++;
				}
				if (board[x+2][y] != -1) {
					board[x+2][y]++;
				}
				if (board[x][y+1] != -1) {
					board[x][y+1]++;
				}
				if (board[x+2][y+1] != -1) {
					board[x+2][y+1]++;
				}
				if (board[x][y+2] != -1) {
					board[x][y+2]++;
				}
				if (board[x+1][y+2] != -1) {
					board[x+1][y+2]++;
				}
				if (board[x+2][y+2] != -1) {
					board[x+2][y+2]++;
				}
			}
		}
	}
	
	/**
	 * Seeded generation
	 * 
	 * @param x X-coordinate for first move
	 * @param y Y-coordinate for first move
	 */
	public void generateBoard(int x, int y) {
		
	}
	
	public void firstMove(int x, int y) {
		
	}
	
	public int move(int x, int y) {
		return board[x+1][y+1];
	}

}

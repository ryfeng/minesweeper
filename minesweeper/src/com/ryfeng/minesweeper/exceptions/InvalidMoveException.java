package com.ryfeng.minesweeper.exceptions;

public class InvalidMoveException extends Exception {
	
	private static final long serialVersionUID = -5511724539162082968L;
	private int x, y;

	public InvalidMoveException(int x, int y) {
		super(String.format("Invalid move at (%d, %d)", x, y));
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}

package com.xyz.chess.model;

public class Square {
	private char rank;
	private char file;

	public char getRank() {
		return rank;
	}

	public void setRank(char rank) {
		this.rank = rank;
	}

	public char getFile() {
		return file;
	}

	public void setFile(char file) {
		this.file = file;
	}

	public String getName() {
		return file + "" + rank;
	}
}

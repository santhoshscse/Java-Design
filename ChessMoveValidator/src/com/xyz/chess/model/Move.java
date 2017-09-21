package com.xyz.chess.model;

import com.xyz.chess.util.ChessUtil;

public class Move {
	private char piece;
	private int fromRank;
	private int fromFile;
	private int toRank;
	private int toFile;
	private boolean isCapture;

	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	public int getFromRank() {
		return fromRank;
	}

	public void setFromRank(int fromRank) {
		this.fromRank = fromRank;
	}

	public int getFromFile() {
		return fromFile;
	}

	public void setFromFile(int fromFile) {
		this.fromFile = fromFile;
	}

	public int getToRank() {
		return toRank;
	}

	public void setToRank(int toRank) {
		this.toRank = toRank;
	}

	public int getToFile() {
		return toFile;
	}

	public void setToFile(int toFile) {
		this.toFile = toFile;
	}

	public String getFrom() {
		return ChessUtil.getAsFile(fromFile) + "" + ChessUtil.getAsRank(fromRank);
	}

	public String getTo() {
		return ChessUtil.getAsFile(toFile) + "" + ChessUtil.getAsRank(toRank);
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Move [piece=");
		builder.append(piece);
		builder.append(", fromRank=");
		builder.append(fromRank);
		builder.append(", fromFile=");
		builder.append(fromFile);
		builder.append(", toRank=");
		builder.append(toRank);
		builder.append(", toFile=");
		builder.append(toFile);
		builder.append(", from=");
		builder.append(getFrom());
		builder.append(", to=");
		builder.append(getTo());
		builder.append(", isCapture=");
		builder.append(isCapture);
		builder.append("]");
		return builder.toString();
	}

}

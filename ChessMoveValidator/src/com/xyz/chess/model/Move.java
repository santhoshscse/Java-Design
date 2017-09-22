package com.xyz.chess.model;

public class Move {
	private char piece;
	private PieceType pieceType;
	private Square source;
	private Square target;
	private boolean isCapture;

	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public Square getSource() {
		return source;
	}

	public void setSource(Square source) {
		this.source = source;
	}

	public Square getTarget() {
		return target;
	}

	public void setTarget(Square target) {
		this.target = target;
	}

	public boolean isCapture() {
		return isCapture;
	}

	public void setCapture(boolean isCapture) {
		this.isCapture = isCapture;
	}

}

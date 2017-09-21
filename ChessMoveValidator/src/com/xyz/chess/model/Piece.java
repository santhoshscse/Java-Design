package com.xyz.chess.model;

/**
 * @author santhoshsrinivasan
 *
 */
public class Piece {
	private Coordinate coordinate;
	private String square;
	private char piece;
	private String id;

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Piece [coordinate=");
		builder.append(coordinate);
		builder.append(", square=");
		builder.append(square);
		builder.append(", piece=");
		builder.append(piece);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}

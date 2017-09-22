package com.xyz.chess.model;

import java.util.HashMap;

import com.xyz.chess.model.Coordinate;
import com.xyz.chess.model.Piece;
import com.xyz.chess.util.ChessUtil;

/**
 * @author santhoshsrinivasan
 *
 */

public class ChessBoard {
	private Piece[][] elements;
	private char nextMoveBy;
	private String castling;
	private String enPassant;
	private int halfMoveClock;
	private int fullMoveNo;
	private HashMap<String, Coordinate> pieceVSLocation;

	/**
	 * 
	 */
	public ChessBoard() {
		String str = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		String[] strArr = str.split(" ");
		convertAsPiece(strArr[0]);
		nextMoveBy = strArr[1].charAt(0);
		castling = strArr[2];
		enPassant = strArr[3];
		halfMoveClock = Integer.parseInt(strArr[4]);
		fullMoveNo = Integer.parseInt(strArr[5]);
	}

	private void convertAsPiece(String in) {
		elements = new Piece[8][8];
		pieceVSLocation = new HashMap<>();
		String[] strArr = in.split("/");
		for (int rankNo = 0; rankNo < 8; rankNo++) {
			String row = strArr[rankNo];
			for (int fileNo = 0; fileNo < row.length(); fileNo++) {
				char piece = row.charAt(fileNo);
				if (piece >= 49 && piece <= 56) {
					int num = piece - 48;
					for (int k = 0; k < num; k++) {
						Piece pieceObj = ChessUtil.getEmptyPiece(rankNo, fileNo);
						elements[rankNo][fileNo] = pieceObj;
						fileNo++;
					}
				} else {

					Coordinate asCoordinate = ChessUtil.getAsCoordinate(rankNo, fileNo);
					String id = piece + "" + ChessUtil.getAsFile(fileNo);
					elements[rankNo][fileNo] = ChessUtil.getAsPiece(rankNo, fileNo, piece, id);

					pieceVSLocation.put(id, asCoordinate);
				}
			}
		}
	}

	public Piece[][] getElements() {
		return elements;
	}

	public void setElements(Piece[][] elements) {
		this.elements = elements;
	}

	public char getNextMoveBy() {
		return nextMoveBy;
	}

	public void setNextMoveBy(char nextMoveBy) {
		this.nextMoveBy = nextMoveBy;
	}

	public String getCastling() {
		return castling;
	}

	public void setCastling(String castling) {
		this.castling = castling;
	}

	public String getEnPassant() {
		return enPassant;
	}

	public void setEnPassant(String enPassant) {
		this.enPassant = enPassant;
	}

	public int getHalfMoveClock() {
		return halfMoveClock;
	}

	public void setHalfMoveClock(int halfMoveClock) {
		this.halfMoveClock = halfMoveClock;
	}

	public int getFullMoveNo() {
		return fullMoveNo;
	}

	public void setFullMoveNo(int fullMoveNo) {
		this.fullMoveNo = fullMoveNo;
	}

	public HashMap<String, Coordinate> getPieceVSLocation() {
		return pieceVSLocation;
	}

	public void setPieceVSLocation(HashMap<String, Coordinate> pieceVSLocation) {
		this.pieceVSLocation = pieceVSLocation;
	}

	public String toFen() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int count = 0;
			for (int j = 0; j < 8; j++) {
				char piece = elements[i][j].getPiece();
				if (piece == '-') {
					count++;
				} else {
					if (count != 0) {
						builder.append(count);
						count = 0;
					}
					builder.append(piece);
				}
			}
			if (count != 0) {
				builder.append(count);
				count = 0;
			}

			if (i < 7) {
				builder.append("/");
			}
		}

		builder.append(" " + nextMoveBy);
		builder.append(" " + castling);
		builder.append(" " + enPassant);
		builder.append(" " + halfMoveClock);
		builder.append(" " + fullMoveNo);
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChessBoard [elements=");
		for (int i = 0; i < 8; i++) {
			builder.append(" ");
			for (int j = 0; j < 8; j++) {
				builder.append(elements[i][j].getPiece());
			}
		}
		builder.append(", nextMoveBy=");
		builder.append(nextMoveBy);
		builder.append(", castling=");
		builder.append(castling);
		builder.append(", enPassant=");
		builder.append(enPassant);
		builder.append(", halfMoveClock=");
		builder.append(halfMoveClock);
		builder.append(", fullMoveNo=");
		builder.append(fullMoveNo);
		builder.append(", pieceVSLocation=");
		builder.append(pieceVSLocation);
		builder.append("]");
		return builder.toString();
	}

	public void increaseFullMoveNo(int i) {
		fullMoveNo++;
	}

}

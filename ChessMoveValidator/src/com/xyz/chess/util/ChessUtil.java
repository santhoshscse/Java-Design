package com.xyz.chess.util;

import com.xyz.chess.handler.ChessBoard;
import com.xyz.chess.model.Coordinate;
import com.xyz.chess.model.Piece;

/**
 * @author santhoshsrinivasan
 *
 */
public class ChessUtil {
	public static Piece getPiece(ChessBoard board, char file, char rank) throws Exception {
		Piece[][] elements = board.getElements();
		if (file >= 'a' && file <= 'h') {
			int fileNo = file - 97;
			if (rank >= '1' && rank <= '8') {
				int rankNo = Math.abs(rank - 49 - 7);
				return elements[rankNo][fileNo];
			}
		}
		throw new Exception("Invalid file / rank");
	}

	public static Piece getPiece(ChessBoard board, int file, int rank) throws Exception {
		Piece[][] elements = board.getElements();
		Piece piece = elements[rank][file];
		if (piece != null) {
			return piece;
		}
		throw new Exception("Invalid file / rank");
	}

	/**
	 * @param charAt
	 * @return
	 */
	public static int getAsRankNo(char charAt) {
		return Math.abs(charAt - 49 - 7);
	}

	public static char getAsRank(int j) {
		return (char) (49 + 7 - j);
	}

	/**
	 * @param charAt
	 * @return
	 */
	public static int getAsFileNo(char charAt) {
		return charAt - 97;
	}

	public static char getAsFile(int i) {
		return (char) (i + 97);
	}

	/**
	 * @param rankNo
	 * @param fileNo
	 * @return
	 */
	public static Coordinate getAsCoordinate(int rankNo, int fileNo) {
		Coordinate coordinate = new Coordinate();
		coordinate.setFileNo(fileNo);
		coordinate.setRankNo(rankNo);
		return coordinate;
	}

	/**
	 * @param rankNo
	 * @param fileNo
	 * @param piece
	 * @param id
	 * @return
	 */
	public static Piece getAsPiece(int rankNo, int fileNo, char piece, String id) {
		Piece pieceObj = new Piece();
		Coordinate coordinate = new Coordinate();
		coordinate.setFileNo(fileNo);
		coordinate.setRankNo(rankNo);
		pieceObj.setCoordinate(coordinate);
		pieceObj.setSquare(ChessUtil.getAsFile(fileNo) + " " + ChessUtil.getAsRank(rankNo));
		pieceObj.setPiece(piece);
		pieceObj.setId(id);
		return pieceObj;
	}

	public static Piece getEmptyPiece(int rankNo, int fileNo) {
		Piece pieceObj = new Piece();
		Coordinate coordinate = new Coordinate();
		coordinate.setFileNo(fileNo);
		coordinate.setRankNo(rankNo);
		pieceObj.setCoordinate(coordinate);
		pieceObj.setSquare(ChessUtil.getAsFile(fileNo) + " " + ChessUtil.getAsRank(rankNo));
		pieceObj.setPiece('-');
		return pieceObj;
	}

}

package com.xyz.chess.handler;

import java.util.HashMap;

import com.xyz.chess.model.Coordinate;
import com.xyz.chess.model.Move;
import com.xyz.chess.model.Piece;
import com.xyz.chess.model.PieceType;
import com.xyz.chess.model.Square;
import com.xyz.chess.util.ChessUtil;

/**
 * @author santhoshsrinivasan
 *
 */
public class PieceHandlerUtil {

	private static HashMap<PieceType, PieceHandler> handlers = new HashMap<>();
	static {
		handlers.put(PieceType.P, new PawnHandler());
	}

	public static Move validateMove(PieceType p, ChessBoard board, Square source, Square target, boolean isCapture)
			throws Exception {
		return handlers.get(p).validateAndGetMove(board, source, target, isCapture);
	}

	public static void makeMove(ChessBoard board, Move move) throws Exception {

		Piece[][] elements = board.getElements();
		int fromFile = move.getFromFile();
		int fromRank = move.getFromRank();

		int toFile = move.getToFile();
		int toRank = move.getToRank();

		Piece sourcePiece = elements[fromRank][fromFile];
		elements[toRank][toFile] = sourcePiece;
		Piece emptyObj = ChessUtil.getEmptyPiece(fromRank, fromFile);
		elements[fromRank][fromFile] = emptyObj;

		Coordinate asCoordinate = ChessUtil.getAsCoordinate(toRank, toFile);

		HashMap<String, Coordinate> pieceVSLocation = board.getPieceVSLocation();
		pieceVSLocation.put(sourcePiece.getId(), asCoordinate);

		board.setEnPassant(getEnPassant(move));

		if (board.getNextMoveBy() == 'w') {
			board.setNextMoveBy('b');
		} else {
			board.setNextMoveBy('w');
			board.increaseFullMoveNo(1);
		}
	}

	private static String getEnPassant(Move move) {
		int fromFile = move.getFromFile();
		int fromRank = move.getFromRank();

		int toFile = move.getToFile();
		int toRank = move.getToRank();

		if (fromFile == toFile) {
			if (Math.abs(fromRank - toRank) == 2) {
				if (fromRank > toRank) {
					return ChessUtil.getAsFile(fromFile) + "" + ChessUtil.getAsRank(toRank + 1);
				} else {
					return ChessUtil.getAsFile(fromFile) + "" + ChessUtil.getAsRank(toRank - 1);
				}
			}
		}
		return "-";
	}
}

package com.xyz.chess.handler;

import java.util.HashMap;

import com.xyz.chess.model.Move;
import com.xyz.chess.model.PieceType;
import com.xyz.chess.model.Square;

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

	public static void makeMove(PieceType p, ChessBoard board, Move move) throws Exception {
		handlers.get(p).makeMove(board, move);
		if (board.getNextMoveBy() == 'w') {
			board.setNextMoveBy('b');
		} else {
			board.setNextMoveBy('w');
			board.increaseFullMoveNo(1);
		}
	}
}

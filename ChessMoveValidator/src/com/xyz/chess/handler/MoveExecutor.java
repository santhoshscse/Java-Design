package com.xyz.chess.handler;

import com.xyz.chess.model.Move;
import com.xyz.chess.util.PieceUtil;

/**
 * @author santhoshsrinivasan
 *
 */
public class MoveExecutor {
	public static void makeMove(ChessBoard board, Move move) throws Exception {
		PieceHandlerUtil.makeMove(PieceUtil.getType(move.getPiece()), board, move);
	}
}

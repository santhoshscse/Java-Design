package com.xyz.chess.handler;

import com.xyz.chess.model.Move;

/**
 * @author santhoshsrinivasan
 *
 */
public class MoveExecutor {
	public static void makeMove(ChessBoard board, Move move) throws Exception {
		PieceHandlerUtil.makeMove(board, move);
	}
}

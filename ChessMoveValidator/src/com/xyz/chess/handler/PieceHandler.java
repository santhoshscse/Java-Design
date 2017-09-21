package com.xyz.chess.handler;

import com.xyz.chess.model.Move;
import com.xyz.chess.model.Square;

/**
 * @author santhoshsrinivasan
 *
 */
public interface PieceHandler {

	Move validateAndGetMove(ChessBoard board, Square source, Square target, boolean isCapture) throws Exception;

	void makeMove(ChessBoard board, Move move);

	String getEnPassant(Move move);
}

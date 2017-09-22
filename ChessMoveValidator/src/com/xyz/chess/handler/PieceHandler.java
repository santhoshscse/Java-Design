package com.xyz.chess.handler;

import com.xyz.chess.model.Move;
import com.xyz.chess.model.Square;

/**
 * @author santhoshsrinivasan
 *
 */
public interface PieceHandler {

	Move validateAndGetMove(Square source, Square target, boolean isCapture) throws Exception;

	String getEnPassant(Move move);
}

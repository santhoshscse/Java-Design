package com.xyz.chess.handler;

import com.xyz.chess.model.Move;
import com.xyz.chess.util.ChessUtil;

/**
 * @author santhoshsrinivasan
 *
 */
public class ChessMoveValidatorTest {
	public static void main(String[] args) throws Exception {
		ChessBoard board = new ChessBoard();
		System.out.println(ChessUtil.getPiece(board, 'e', '1'));
		System.out.println(board);
		System.out.println(board.toFen());

		// List<Move> possibleMoves = MoveReader.getPossibleMoves(board, "e4");
		// System.out.println(possibleMoves);
		// possibleMoves = MoveReader.getPossibleMoves(board, "e3");
		// System.out.println(possibleMoves);
		//

		isValidMoveTest(board, "e3");
		isValidMoveTest(board, "ee3");
		isValidMoveTest(board, "de3");
		isValidMoveTest(board, "fe3");
		isValidMoveTest(board, "2e3");
		isValidMoveTest(board, "3e3");
		isValidMoveTest(board, "xe3");
		isValidMoveTest(board, "fxe3");

		makeMoveTest(board, "e4");
		makeMoveTest(board, "c5");
	}

	private static void makeMoveTest(ChessBoard board, String string) {
		try {
			Move move = CommandReader.getMove(board, string);
			System.out.println(move);

			MoveExecutor.makeMove(board, move);
			System.out.println(board.toFen());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void isValidMoveTest(ChessBoard board, String string) {
		try {
			Move move = CommandReader.getMove(board, string);
			System.out.println(move);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

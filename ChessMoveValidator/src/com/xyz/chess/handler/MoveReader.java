package com.xyz.chess.handler;

import com.xyz.chess.model.Move;
import com.xyz.chess.model.PieceType;
import com.xyz.chess.model.Square;
import com.xyz.chess.util.MoveUtil;
import com.xyz.chess.util.PieceUtil;

/**
 * @author santhoshsrinivasan
 *
 */

public class MoveReader {


	public static Move getMove(ChessBoard board, String input) throws Exception {
		if (input.length() <= 1) {
			throw new Exception("Invalid input");
		}
		Object[] res = null;
		Square target = new Square();
		res = MoveUtil.getRank(input);
		input = (String) res[0];
		target.setRank((char) res[1]);

		res = MoveUtil.getFile(input);
		input = (String) res[0];
		target.setFile((char) res[1]);

		res = MoveUtil.getCapture(input);
		input = (String) res[0];
		boolean isCapture = (boolean) res[1];

		if (input.isEmpty()) {
			return PieceHandlerUtil.validateMove(PieceType.P, board, null, target, isCapture);
		}
		int len = input.length();
		if (len == 1) {
			char firstChar = input.charAt(0);
			if (isPiece(firstChar)) {
				return PieceHandlerUtil.validateMove(PieceUtil.getType(firstChar), board, null, target, isCapture);
			} else if (isFile(firstChar)) {
				Square source = new Square();
				source.setFile(firstChar);
				return PieceHandlerUtil.validateMove(PieceType.P, board, source, target, isCapture);
			} else if (isRank(firstChar)) {
				Square source = new Square();
				source.setRank(firstChar);
				return PieceHandlerUtil.validateMove(PieceType.P, board, source, target, isCapture);
			}
		} else if (len == 2) {
			char firstChar = input.charAt(0);
			if (isPiece(firstChar)) {
				char secondChar = input.charAt(1);
				if (isFile(secondChar)) {
					Square source = new Square();
					source.setFile(secondChar);
					return PieceHandlerUtil.validateMove(PieceUtil.getType(firstChar), board, source, target, isCapture);
				} else if (isRank(secondChar)) {
					Square source = new Square();
					source.setRank(secondChar);
					return PieceHandlerUtil.validateMove(PieceUtil.getType(firstChar), board, source, target, isCapture);
				}
			} else if (isFile(firstChar)) {
				char secondChar = input.charAt(1);
				Square source = new Square();
				source.setFile(firstChar);
				if (isRank(secondChar)) {
					source.setRank(secondChar);
					return PieceHandlerUtil.validateMove(PieceType.P, board, source, target, isCapture);
				}
			}
		} else if (len == 3) {
			char piece = input.charAt(0);
			char fromFile = input.charAt(1);
			char fromRank = input.charAt(2);
			if (isPiece(piece) && isFile(fromFile) && isRank(fromRank)) {
				Square source = new Square();
				source.setFile(fromFile);
				source.setRank(fromRank);
				return PieceHandlerUtil.validateMove(PieceUtil.getType(piece), board, source, target, isCapture);
			}
		}
		return null;
	}


	/**
	 * @param firstChar
	 * @return
	 */
	private static boolean isRank(char firstChar) {
		return firstChar >= '1' && firstChar <= '8';
	}

	/**
	 * @param firstChar
	 * @return
	 */
	private static boolean isFile(char firstChar) {
		return firstChar >= 'a' && firstChar <= 'h';
	}

	/**
	 * @param firstChar
	 * @return
	 */
	private static boolean isPiece(char firstChar) {
		if (firstChar == 'r' || firstChar == 'R') {
			return true;
		} else if (firstChar == 'n' || firstChar == 'N') {
			return true;
		} else if (firstChar == 'b' || firstChar == 'B') {
			return true;
		} else if (firstChar == 'q' || firstChar == 'Q') {
			return true;
		} else if (firstChar == 'k' || firstChar == 'K') {
			return true;
		}
		return false;
	}

}

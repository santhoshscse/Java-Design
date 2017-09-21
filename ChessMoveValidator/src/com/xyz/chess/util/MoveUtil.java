package com.xyz.chess.util;

import com.xyz.chess.model.Coordinate;
import com.xyz.chess.model.Move;

public class MoveUtil {

	public static Object[] getRank(String input) {
		int length = input.length();
		char toRank = input.charAt(length - 1);
		input = input.substring(0, length - 1);
		return new Object[] { input, toRank };
	}

	public static Object[] getFile(String input) {
		int length = input.length();
		char toFile = input.charAt(length - 1);
		input = input.substring(0, length - 1);
		return new Object[] { input, toFile };
	}

	public static Object[] getCapture(String input) {
		boolean isCapture = false;
		int length = input.length();
		if (length >= 1) {
			isCapture = input.charAt(length - 1) == 'x' ? true : false;
			if (isCapture) {
				input = input.substring(0, length - 1);
			}
		}
		return new Object[] { input, isCapture };
	}

	public static Move getAsMove(int fileNo, int rankNo, Coordinate co) {
		Move move = new Move();
		move.setFromRank(co.getRankNo());
		move.setFromFile(co.getFileNo());
		move.setToRank(rankNo);
		move.setToFile(fileNo);
		return move;
	}
}

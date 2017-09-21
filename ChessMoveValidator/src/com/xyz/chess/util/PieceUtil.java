package com.xyz.chess.util;

import com.xyz.chess.model.Piece;
import com.xyz.chess.model.PieceType;

public class PieceUtil {

	enum Category {
		W, B, None;
	}

	public static PieceType getType(char piece) {
		switch (piece) {
		case 'p':
		case 'P':
			return PieceType.P;
		case 'r':
		case 'R':
			return PieceType.R;
		case 'n':
		case 'N':
			return PieceType.N;
		case 'b':
		case 'B':
			return PieceType.B;
		case 'q':
		case 'Q':
			return PieceType.Q;
		case 'k':
		case 'K':
			return PieceType.K;
		default:
			return null;

		}
	}

	public static boolean isSameCategory(Piece source, Piece target) {
		char s = source.getPiece();
		char t = target.getPiece();
		return getCategory(s) == getCategory(t);
	}

	private static Category getCategory(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return Category.B;
		} else if (ch >= 'A' && ch <= 'Z') {
			return Category.W;
		} else {
			return Category.None;
		}
	}
}

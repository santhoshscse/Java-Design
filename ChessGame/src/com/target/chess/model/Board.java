package com.target.chess.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.target.chess.util.PieceUtil;
import com.target.chess.util.SquareUtil;

public class Board {

	private Square[][] elements;
	private HashMap<String, Location> pieceVSLocation;

	public Board(String input) throws Exception {
		init(input);
	}

	private void init(String input) throws Exception {
		elements = new Square[8][8];
		pieceVSLocation = new HashMap<>();
		String[] strArr = input.split("/");
		for (int rankNo = 0; rankNo < 8; rankNo++) {
			String row = strArr[rankNo];
			for (int fileNo = 0; fileNo < row.length(); fileNo++) {
				char piece = row.charAt(fileNo);
				if (piece >= 49 && piece <= 56) {
					int num = piece - 48;
					for (int k = 0; k < num; k++) {
						elements[rankNo][fileNo] = null;
						fileNo++;
					}
				} else {
					char asFile = getAsFile(fileNo);
					char asRank = getAsRank(rankNo);

					String id = piece + "" + asFile;
					Location loc = getAsLocation(asFile, asRank);
					Piece p = getAsPiece(id, piece);
					Square sq = getAsSquare(loc, p);

					elements[rankNo][fileNo] = SquareUtil.getAsSquare(asFile, asRank, piece, id);
					pieceVSLocation.put(id, loc);
				}
			}
		}

	}

	private Square getAsSquare(Location loc, Piece p) {
		Square sq = new Square();
		sq.setLocation(loc);
		sq.setPiece(p);
		return sq;
	}

	private Location getAsLocation(char asFile, char asRank) {
		Location loc = new Location();
		loc.setFile(asFile);
		loc.setRank(asRank);
		return loc;
	}

	private int getAsRankNo(char charAt) {
		return Math.abs(charAt - 49 - 7);
	}

	private char getAsRank(int j) {
		return (char) (49 + 7 - j);
	}

	/**
	 * @param charAt
	 * @return
	 */
	private int getAsFileNo(char charAt) {
		return charAt - 97;
	}

	private char getAsFile(int i) {
		return (char) (i + 97);
	}

	private Piece getAsPiece(String id, char pieceName) throws Exception {
		Piece piece = new Piece();
		piece.setId(id);
		piece.setName(pieceName);
		piece.setPieceType(PieceUtil.getType(pieceName));
		piece.setWhite(PieceUtil.isWhite(pieceName));
		return piece;
	}

	public String toFen() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int count = 0;
			for (int j = 0; j < 8; j++) {
				char piece = elements[i][j].getPiece().getName();
				if (piece == '-') {
					count++;
				} else {
					if (count != 0) {
						builder.append(count);
						count = 0;
					}
					builder.append(piece);
				}
			}
			if (count != 0) {
				builder.append(count);
				count = 0;
			}

			if (i < 7) {
				builder.append("/");
			}
		}
		return builder.toString();
	}

	public List<Location> getAllLocationsOfPiece(PieceType pieceType, boolean isWhite) {
		List<Location> list = new ArrayList<>();
		char pieceName = PieceUtil.getPieceName(pieceType, isWhite);
		for (char ch = 'a'; ch <= 'h'; ch++) {
			String key = pieceName + "" + ch;
			Location location = pieceVSLocation.get(key);
			if (location != null) {
				list.add(location);
			}
		}
		return list;
	}
}

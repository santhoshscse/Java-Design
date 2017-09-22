package com.target.chess.handler;

import java.util.List;

import com.target.chess.model.Board;
import com.target.chess.model.Location;
import com.target.chess.model.PieceType;
import com.target.chess.model.Player;
import com.target.chess.util.PlayerUtil;

public class ChessBoardHandler {
	private Board board;
	private Player nextPlayer;
	private String castling;
	private String enPassant;
	private int halfMoveClock;
	private int fullMoveNo;

	public ChessBoardHandler() throws Exception {
		initBoard();
	}

	private void initBoard() throws Exception {
		String str = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		String[] strArr = str.split(" ");
		board = new Board(strArr[0]);
		nextPlayer = PlayerUtil.getPlayerType(strArr[1]);
		castling = strArr[2];
		enPassant = strArr[3];
		halfMoveClock = Integer.parseInt(strArr[4]);
		fullMoveNo = Integer.parseInt(strArr[5]);
	}

	public String display() {
		StringBuilder builder = new StringBuilder();
		builder.append(board.toFen());
		builder.append(" " + PlayerUtil.getPlayerName(nextPlayer));
		builder.append(" " + castling);
		builder.append(" " + enPassant);
		builder.append(" " + halfMoveClock);
		builder.append(" " + fullMoveNo);
		return builder.toString();
	}

	public List<Location> getAllLocationsOfPiece(PieceType pieceType, boolean isWhite) {
		return board.getAllLocationsOfPiece(pieceType, isWhite);
	}

}

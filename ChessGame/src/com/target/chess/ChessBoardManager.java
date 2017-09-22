package com.target.chess;

import com.target.chess.handler.ChessBoardHandler;
import com.target.chess.handler.CommandReader;
import com.target.chess.handler.PieceHandler;

public class ChessBoardManager {

	private CommandReader commandReader = null;
	private PieceHandler pieceHandler = null;
	private ChessBoardHandler boardHandler = null;

	public ChessBoardManager() throws Exception {
		commandReader = new CommandReader();
		pieceHandler = new PieceHandler();
		boardHandler = new ChessBoardHandler();
	}

	public static void move(String input) {

	}

	public static String display() {
		return null;
	}
}

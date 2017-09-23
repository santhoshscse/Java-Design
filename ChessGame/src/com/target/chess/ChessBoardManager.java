package com.target.chess;

import com.target.chess.handler.ChessBoardHandler;
import com.target.chess.handler.CommandReader;
import com.target.chess.handler.CommandValidator;

public class ChessBoardManager {

	private CommandReader commandReader = null;
	private CommandValidator pieceHandler = null;
	private ChessBoardHandler boardHandler = null;

	public ChessBoardManager() throws Exception {
		commandReader = new CommandReader();
		pieceHandler = new CommandValidator();
		boardHandler = new ChessBoardHandler();
	}

	public void move(String input) {
		
	}

	public String display() {
		return null;
	}
}

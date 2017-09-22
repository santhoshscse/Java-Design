package com.target.chess.validator;

import com.target.chess.model.Command;
import com.target.chess.model.Move;
import com.target.chess.model.Player;

public interface MoveValidator {
	Move validateCommandAndGetMove(Player player, Command command);
}

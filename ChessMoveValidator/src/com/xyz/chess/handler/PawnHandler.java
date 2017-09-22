package com.xyz.chess.handler;

import java.util.HashMap;

import com.xyz.chess.model.Coordinate;
import com.xyz.chess.model.Move;
import com.xyz.chess.model.Piece;
import com.xyz.chess.model.PieceType;
import com.xyz.chess.model.Square;
import com.xyz.chess.util.ChessUtil;
import com.xyz.chess.util.MoveUtil;
import com.xyz.chess.util.PieceUtil;

/**
 * @author santhoshsrinivasan
 *
 */
public class PawnHandler implements PieceHandler {

	@Override
	public Move validateAndGetMove(Square source, Square target, boolean isCapture) throws Exception {

		Move move = getMove(source, target, isCapture);
		if (move == null) {
			throw new Exception("No move found");
		}
		Piece sourcePiece = ChessUtil.getPiece(move.getFromFile(), move.getFromRank());
		Piece targetPiece = ChessUtil.getPiece(board, move.getToFile(), move.getToRank());

		if (PieceUtil.isSameCategory(sourcePiece, targetPiece)) {
			throw new Exception("Invalid move, same category");
		}

		if (move != null) {
			move.setCapture(isCapture);
			move.setPiece(board.getNextMoveBy() == 'w' ? 'P' : 'p');

		}
		return move;
	}

	private Move getMove(Square source, Square target, boolean isCapture) throws Exception {
		int toRankNo = ChessUtil.getAsRankNo(target.getRank());
		int toFileNo = ChessUtil.getAsFileNo(target.getFile());
		if (source == null || source.getName().trim().isEmpty()) {
			return getMove(toRankNo, toFileNo, target.getName(), isCapture);
		}
		char sourceFile = source.getFile();
		char sourceRank = source.getRank();
		if (sourceFile != Character.MIN_VALUE && sourceRank != Character.MIN_VALUE) {
			int sourceFileNo = ChessUtil.getAsFileNo(sourceFile);
			int sourceRankNo = ChessUtil.getAsRankNo(sourceRank);
			return getMoveWithFileRank(sourceFileNo, sourceRankNo, toFileNo, toRankNo, isCapture);
		}

		if (sourceFile != Character.MIN_VALUE && sourceRank == Character.MIN_VALUE) {
			int sourceFileNo = ChessUtil.getAsFileNo(sourceFile);
			return getMoveWithFile(sourceFileNo, toFileNo, toRankNo, isCapture);
		}

		if (sourceFile == Character.MIN_VALUE && sourceRank != Character.MIN_VALUE) {
			int sourceRankNo = ChessUtil.getAsRankNo(sourceRank);
			return getMoveWithRank(sourceRankNo, toFileNo, toRankNo, isCapture);
		}
		return null;
	}

	private Move getMoveWithRank(ChessBoard board, int sourceRankNo, int toFileNo, int toRankNo, boolean isCapture)
			throws Exception {

		String key;
		boolean isWhite;
		if (board.getNextMoveBy() == 'w') {
			isWhite = true;
		} else {
			isWhite = false;
		}

		HashMap<String, Coordinate> pieceVSLocation = board.getPieceVSLocation();
		Move move = null;
		Move tmpMove = null;
		for (char ch = 'a'; ch <= 'h'; ch++) {
			if (tmpMove != null) {
				if (move == null) {
					move = tmpMove;
					tmpMove = null;
				} else {
					throw new Exception("Ambiguity");
				}
			}
			key = (isWhite ? 'P' : 'p') + "" + ch;
			Coordinate co = pieceVSLocation.get(key);
			if (co == null) {
				continue;
			}

			if (isCapture) {
				if (co.getRankNo() == sourceRankNo && co.getFileNo() - 1 == toFileNo) {
					tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
				}

				if (co.getRankNo() == sourceRankNo && co.getFileNo() + 1 == toFileNo) {
					tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
				}
			} else {
				if (co.getRankNo() == sourceRankNo && co.getFileNo() == toFileNo) {
					tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
				}
			}

		}
		return move;

	}

	private Move getMoveWithFile(ChessBoard board, int sourceFileNo, int toFileNo, int toRankNo, boolean isCapture)
			throws Exception {
		String key;
		boolean isWhite;
		if (board.getNextMoveBy() == 'w') {
			isWhite = true;
		} else {
			isWhite = false;
		}

		HashMap<String, Coordinate> pieceVSLocation = board.getPieceVSLocation();
		Move move = null;
		Move tmpMove = null;
		for (char ch = 'a'; ch <= 'h'; ch++) {
			if (tmpMove != null) {
				if (move == null) {
					move = tmpMove;
					tmpMove = null;
				} else {
					throw new Exception("Ambiguity");
				}
			}
			key = (isWhite ? 'P' : 'p') + "" + ch;
			Coordinate co = pieceVSLocation.get(key);
			if (co == null) {
				continue;
			}
			if (isWhite) {

				if (isCapture) {
					if (co.getRankNo() - 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}
					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}
				} else {
					if (co.getRankNo() - 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (tmpMove == null && co.getRankNo() == 6 && co.getRankNo() - 2 == toRankNo
							&& co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

				}

			} else {

				if (isCapture) {
					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}
				} else {
					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (tmpMove == null && co.getRankNo() == 1 && co.getRankNo() + 2 == toRankNo
							&& co.getFileNo() == sourceFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

				}

			}
		}
		return move;
	}

	private Move getMoveWithFileRank(ChessBoard board, int sourceFileNo, int sourceRankNo, int toFileNo, int toRankNo,
			boolean isCapture) {
		Piece[][] elements = board.getElements();
		Piece piece = elements[sourceFileNo][sourceRankNo];
		if (PieceUtil.getType(piece.getPiece()) == PieceType.P) {
			Move move = new Move();
			move.setFromFile(sourceFileNo);
			move.setFromRank(sourceRankNo);

			move.setToFile(toFileNo);
			move.setToRank(toRankNo);
			return move;
		}
		return null;
	}

	private static Move getMove(ChessBoard board, int toRankNo, int toFileNo, String to, boolean isCapture)
			throws Exception {
		String key;
		boolean isWhite;
		if (board.getNextMoveBy() == 'w') {
			isWhite = true;
		} else {
			isWhite = false;
		}

		HashMap<String, Coordinate> pieceVSLocation = board.getPieceVSLocation();
		Move move = null;
		Move tmpMove = null;
		for (char ch = 'a'; ch <= 'h'; ch++) {
			if (tmpMove != null) {
				if (move == null) {
					move = tmpMove;
					tmpMove = null;
				} else {
					throw new Exception("Ambiguity");
				}
			}
			key = (isWhite ? 'P' : 'p') + "" + ch;
			Coordinate co = pieceVSLocation.get(key);
			if (co == null) {
				continue;
			}
			if (isWhite) {

				if (isCapture) {

					if (co.getRankNo() - 1 == toRankNo && co.getFileNo() - 1 == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (co.getRankNo() - 1 == toRankNo && co.getFileNo() + 1 == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);

					}
				} else {
					if (co.getRankNo() - 1 == toRankNo && co.getFileNo() == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (tmpMove == null && co.getRankNo() == 6 && co.getRankNo() - 2 == toRankNo
							&& co.getFileNo() == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}
				}

			} else {

				if (isCapture) {
					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() - 1 == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() + 1 == toFileNo) {

						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);

					}
				} else {
					if (co.getRankNo() + 1 == toRankNo && co.getFileNo() == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

					if (tmpMove == null && co.getRankNo() == 1 && co.getRankNo() + 2 == toRankNo
							&& co.getFileNo() == toFileNo) {
						tmpMove = MoveUtil.getAsMove(toFileNo, toRankNo, co);
					}

				}

			}
		}
		return move;

	}

	@Override
	public String getEnPassant(Move move) {
		int fromFile = move.getFromFile();
		int fromRank = move.getFromRank();

		int toFile = move.getToFile();
		int toRank = move.getToRank();

		if (fromFile == toFile) {
			if (Math.abs(fromRank - toRank) == 2) {
				if (fromRank > toRank) {
					return ChessUtil.getAsFile(fromFile) + "" + ChessUtil.getAsRank(toRank + 1);
				} else {
					return ChessUtil.getAsFile(fromFile) + "" + ChessUtil.getAsRank(toRank - 1);
				}
			}
		}
		return "-";
	}

}

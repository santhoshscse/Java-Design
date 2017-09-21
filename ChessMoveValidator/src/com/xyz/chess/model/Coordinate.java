package com.xyz.chess.model;

/**
 * @author santhoshsrinivasan
 *
 */
public class Coordinate {
	private int rankNo;
	private int fileNo;

	public int getRankNo() {
		return rankNo;
	}

	public void setRankNo(int rankNo) {
		this.rankNo = rankNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coordinate [rankNo=");
		builder.append(rankNo);
		builder.append(", fileNo=");
		builder.append(fileNo);
		builder.append("]");
		return builder.toString();
	}

}

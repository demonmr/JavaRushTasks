package com.javarush.task.task35.task3513;

public class MoveEfficiency {
	private int numberOfEmptyTiles;
	private int scope;
	private Move move;

	public MoveEfficiency(int numberOfEmptyTiles, int scope, Move move) {
		this.numberOfEmptyTiles = numberOfEmptyTiles;
		this.scope = scope;
		this.move = move;
	}

	public Move getMove() {
		return move;
	}
}

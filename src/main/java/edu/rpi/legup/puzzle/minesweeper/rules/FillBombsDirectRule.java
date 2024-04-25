package edu.rpi.legup.puzzle.minesweeper.rules;

import edu.rpi.legup.model.gameboard.Board;
import edu.rpi.legup.model.gameboard.PuzzleElement;
import edu.rpi.legup.model.rules.DirectRule;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperBoard;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperCell;

abstract public class FillBombsDirectRule extends DirectRule{
    public FillBombsDirectRule() {
        super(
                "MINE-BASC-0001",
                "Fill Bombs",
                "Fill all blank places around a flag with bombs if that would satisfy the flag",
                "");
    }

    public String checkRuleRawAt(Board board, PuzzleElement puzzleElement) {
        MinesweeperBoard minesweeperBoard = (MinesweeperBoard) board;
        MinesweeperCell cell = (MinesweeperCell) minesweeperBoard.getPuzzleElement(puzzleElement);

        return null;
    }

}

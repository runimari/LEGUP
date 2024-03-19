package edu.rpi.legup.puzzle.minesweeper.rules;

import edu.rpi.legup.model.gameboard.Board;
import edu.rpi.legup.model.gameboard.CaseBoard;
import edu.rpi.legup.model.gameboard.PuzzleElement;
import edu.rpi.legup.model.rules.CaseRule;
import edu.rpi.legup.model.tree.TreeTransition;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperBoard;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperCell;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperTileData;

import java.util.ArrayList;
import java.util.List;

public class SatisfyFlagCaseRule extends CaseRule{
    public SatisfyFlagCaseRule() {
        super("MINE-CASE-0001", "Satisfy Flag",
                "There are different options for a flag to be satisfied.\n",
                "");
    }

    @Override
    public CaseBoard getCaseBoard(Board board) {
        return null;
    }

    @Override
    public List<Board> getCases(Board board, PuzzleElement puzzleElement) {
        return null;
    }

    @Override
    public String checkRuleRaw(TreeTransition transition) {
        return null;
    }

    @Override
    public String checkRuleRawAt(TreeTransition transition, PuzzleElement puzzleElement) {
        return null;
    }
}

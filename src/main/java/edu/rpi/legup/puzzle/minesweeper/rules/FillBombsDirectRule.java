package edu.rpi.legup.puzzle.minesweeper.rules;

import edu.rpi.legup.model.gameboard.Board;
import edu.rpi.legup.model.gameboard.PuzzleElement;
import edu.rpi.legup.model.rules.DirectRule;
import edu.rpi.legup.model.tree.TreeNode;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperBoard;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperCell;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperTileData;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperTileType;
import edu.rpi.legup.puzzle.minesweeper.MinesweeperUtilities;


public abstract class FillBombsDirectRule extends DirectRule {
    public FillBombsDirectRule() {
        super(
                "MINE-BASC-0001",
                "Fill Bombs",
                "Fill all blank places around a flag with bombs if that would satisfy the flag",
                "");
    }

    @Override
    public Board getDefaultBoard(TreeNode node) {
        return null;
    }

    public String checkRuleRawAt(Board board, PuzzleElement puzzleElement) {
        MinesweeperBoard minesweeperBoard = (MinesweeperBoard) board;
        MinesweeperCell cell = (MinesweeperCell) minesweeperBoard.getPuzzleElement(puzzleElement);

        // Check if the cell is a flag
        if (cell.getTileType() != MinesweeperTileType.FLAG) {
            return super.getInvalidUseOfRuleMessage() + ": The selected cell is not a flag.";
        }

        // Get the adjacent cells
        int numAdjacentBombs = 0;
        int numAdjacentEmpty = 0;
        for (MinesweeperCell adjacentCell : MinesweeperUtilities.getAdjacentCells(minesweeperBoard, cell)) {
            if (adjacentCell.getTileType() == MinesweeperTileType.BOMB) {
                numAdjacentBombs++;
            } else if (adjacentCell.getTileType() == MinesweeperTileType.UNSET) {
                numAdjacentEmpty++;
            }
        }

        // Check if placing bombs in empty cells would satisfy the flag's number
        int flagNumber = cell.getTileNumber();
        if (flagNumber > 0 && flagNumber <= 8 && numAdjacentEmpty >= flagNumber - numAdjacentBombs) {
            // Place bombs in the empty cells
            for (MinesweeperCell adjacentCell : MinesweeperUtilities.getAdjacentCells(minesweeperBoard, cell)) {
                if (adjacentCell.getTileType() == MinesweeperTileType.UNSET) {
                    adjacentCell.setData(MinesweeperTileData.bomb());
                    minesweeperBoard.addModifiedData(adjacentCell);
                }
            }
            return null;
        }

        return super.getInvalidUseOfRuleMessage() + ": Placing bombs in empty cells would not satisfy the flag.";
    }
}

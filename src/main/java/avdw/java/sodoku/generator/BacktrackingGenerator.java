package avdw.java.sodoku.generator;

import avdw.java.sodoku.mapper.CellMapper;
import avdw.java.sodoku.model.Block;
import avdw.java.sodoku.model.Cell;
import avdw.java.sodoku.model.CellType;
import avdw.java.sodoku.model.Grid;
import avdw.java.sodoku.validator.Validator;
import org.pmw.tinylog.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class BacktrackingGenerator implements Generator {
    private CellMapper cellMapper;
    private Validator validator;
    private Set<Block> blocks;

    @Inject
    BacktrackingGenerator(CellMapper cellMapper, Validator validator, Set<Block> blocks) {
        this.cellMapper = cellMapper;
        this.validator = validator;
        this.blocks = blocks;
    }

    public Grid generate() {
        Grid grid = new Grid(cellMapper);
        Stack<Cell> processing = new Stack();
        Stack<Cell> processed = new Stack();

        processing.addAll(grid.cells);
        while (!processing.empty()) {
            if (processing.peek().cellType == CellType.BLANK) {
                processing.peek().pickNextCellType();
            }

            Block selectedBlock = blocks.stream().filter(block -> block.contains(processing.peek())).findAny().get();
            List<Cell> rowCells = grid.cells.stream().filter(cell -> cell.y.equals(processing.peek().y)).collect(Collectors.toList());
            List<Cell> colCells = grid.cells.stream().filter(cell -> cell.x.equals(processing.peek().x)).collect(Collectors.toList());
            List<Cell> blockCells = grid.cells.stream().filter(selectedBlock::contains).collect(Collectors.toList());
            if (validator.isValid(rowCells) && validator.isValid(colCells) && validator.isValid(blockCells)) {
                processed.push(processing.pop());
            } else if (!processing.peek().pickNextCellType()) {
                processed.peek().pickNextCellType();
                processing.push(processed.pop());
            }
        }

        return grid;
    }
}

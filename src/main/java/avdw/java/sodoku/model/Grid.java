package avdw.java.sodoku.model;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    final public List<Cell> cells;
    final Integer xSize, ySize;

    public Grid() {
        this.cells = new ArrayList();
        xSize = ySize = CellType.values().length-1;

        IntStream.range(0, xSize).forEach(x -> {
            IntStream.range(0, ySize).forEach(y -> {
                this.cells.add(new Cell(x, y));
            });
        });
    }

    public Grid(Grid that) {
        this.cells = that.cells.stream().map(Cell::new).collect(Collectors.toList());
        this.xSize = that.xSize;
        this.ySize = that.ySize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, ySize).forEach(y -> {
            sb.append(this.cells.stream().filter(cell -> cell.y == y).map(cell -> cell.cellType).collect(Collectors.toList()));
            sb.append("\n");
        });
        return sb.toString();
    }
}

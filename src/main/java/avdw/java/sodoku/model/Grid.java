package avdw.java.sodoku.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    final public List<Cell> cells;
    final Integer xSize, ySize;

    public Grid(Set<CellType> cellTypes) {
        this.cells = new ArrayList();
        xSize = ySize = cellTypes.size();

        IntStream.range(0, xSize).forEach(x -> {
            IntStream.range(0, ySize).forEach(y -> {
                this.cells.add(new Cell(x, y, cellTypes));
            });
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, ySize).forEach(y -> {
            sb.append(this.cells.stream().filter(cell -> cell.y == y).map(cell -> cell.cellType).collect(Collectors.toList()));
            sb.append("\n");
        });
        return sb.toString();
    }
}

package avdw.java.sodoku.model;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Grid {
    final private List<Cell> cells;

    @Inject
    Grid(List<CellType> cellTypes) {
        this.cells = new ArrayList();
        Integer x, y;
        x = y = cellTypes.size();

        IntStream.range(0, x).forEach(i -> {
            IntStream.range(0, y).forEach(j->{
                this.cells.add(new Cell(i, j, cellTypes));
            });
        });
    }
}

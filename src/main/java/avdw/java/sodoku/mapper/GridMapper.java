package avdw.java.sodoku.mapper;

import avdw.java.sodoku.SodokuModule;
import avdw.java.sodoku.model.Cell;
import avdw.java.sodoku.model.Grid;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.util.stream.IntStream;

public class GridMapper {
    private CellMapper cellMapper;

    @Inject
    GridMapper(CellMapper cellMapper) {
        this.cellMapper = cellMapper;
    }

    public Grid toGrid(int[][] matrix) {
        Injector injector = Guice.createInjector(new SodokuModule());
        Grid grid = injector.getInstance(Grid.class);

        IntStream.range(0, matrix.length).forEach(y -> {
            IntStream.range(0, matrix[y].length).forEach(x -> {
                if (matrix[y][x] != 0) {
                    Cell cell = grid.cells.stream().filter(c -> c.y == y && c.x == x).findAny().get();
                    cell.cellType = cellMapper.toCellType((matrix[y][x]));
                    cell.isFixed = Boolean.TRUE;
                }
            });
        });

        return grid;
    }
}

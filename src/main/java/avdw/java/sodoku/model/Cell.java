package avdw.java.sodoku.model;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cell {
    final private Integer x;
    final private Integer y;
    private CellType cellType;
    final private List<CellType> cellTypePool;

    @Inject
    Cell(final Integer x, final Integer y, final List<CellType> cellTypePool) {
        this.x = x;
        this.y = y;
        this.cellType = CellType.BLANK;
        this.cellTypePool = new ArrayList();
        this.cellTypePool.addAll(cellTypePool);
        Collections.shuffle(this.cellTypePool);
    }

    Boolean pickNextCell() {
        if (cellTypePool.isEmpty()) {
            return Boolean.FALSE;
        }

        cellType = cellTypePool.remove(0);
        return Boolean.TRUE;
    }
}

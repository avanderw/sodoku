package avdw.java.sodoku.model;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cell {
    final public Integer x;
    final public Integer y;
    public CellType cellType;
    final private List<CellType> cellTypePool;

    @Inject
    Cell(final Integer x, final Integer y, final Set<CellType> cellTypePool) {
        this.x = x;
        this.y = y;
        this.cellType = CellType.BLANK;
        this.cellTypePool = new ArrayList();
        this.cellTypePool.addAll(cellTypePool);
        Collections.shuffle(this.cellTypePool);
    }

    public Boolean pickNextCellType() {
        if (cellTypePool.isEmpty()) {
            return Boolean.FALSE;
        }

        cellType = cellTypePool.remove(0);
        return Boolean.TRUE;
    }
}

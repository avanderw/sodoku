package avdw.java.sodoku.model;

import com.google.inject.Inject;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cell {
    final public Integer x;
    final public Integer y;
    public CellType cellType;
    final private Set<CellType> cellTypePool;
    final private List<CellType> cellTypePoolRemainder;

    @Inject
    Cell(final Integer x, final Integer y, final Set<CellType> cellTypePool) {
        this.x = x;
        this.y = y;
        this.cellTypePool = cellTypePool;
        this.cellType = CellType.BLANK;
        this.cellTypePoolRemainder = new ArrayList();
        resetPool();
    }

    public Boolean pickNextCellType() {
        if (cellTypePoolRemainder.isEmpty()) {
            cellType = CellType.BLANK;
            resetPool();
            return Boolean.FALSE;
        }

        cellType = cellTypePoolRemainder.remove(0);
        return Boolean.TRUE;
    }

    private void resetPool() {
        this.cellTypePoolRemainder.clear();
        this.cellTypePoolRemainder.addAll(cellTypePool);
        Collections.shuffle(this.cellTypePoolRemainder);
    }
}

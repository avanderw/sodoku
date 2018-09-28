package avdw.java.sodoku.model;

import com.google.inject.Inject;
import org.pmw.tinylog.Logger;

import java.util.*;

public class Cell {
    final public Integer x;
    final public Integer y;
    public CellType cellType;
    final private List<CellType> cellTypePoolRemainder;
    public Boolean isFixed = Boolean.FALSE;

    @Inject
    Cell(final Integer x, final Integer y) {
        this.x = x;
        this.y = y;
        this.cellType = CellType.BLANK;
        this.cellTypePoolRemainder = new ArrayList();
        resetPool();
    }

    Cell(Cell that) {
        this.x = that.x;
        this.y = that.y;
        this.cellType = that.cellType;
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
        this.cellTypePoolRemainder.addAll(CellType.usedValues());
        Collections.shuffle(this.cellTypePoolRemainder);
    }
}

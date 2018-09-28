package avdw.java.sodoku.model;

import com.google.common.collect.Range;

public class Block {
    public Range xRange;
    public Range yRange;

    public Block(Range<Integer> xRange, Range<Integer> yRange) {
        this.xRange = xRange;
        this.yRange = yRange;
    }

    public Boolean contains(Cell cell) {
        return xRange.contains(cell.x) && yRange.contains(cell.y);
    }
}

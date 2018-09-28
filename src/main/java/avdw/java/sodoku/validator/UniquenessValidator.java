package avdw.java.sodoku.validator;

import avdw.java.sodoku.model.Cell;
import avdw.java.sodoku.model.CellType;

import java.util.List;

public class UniquenessValidator implements Validator {
    @Override
    public Boolean isValid(List<Cell> cells) {
        return cells.stream().mapToLong(cell -> cells.stream()
                .filter(c -> c.cellType != CellType.BLANK)
                .filter(c -> c.cellType == cell.cellType)
                .count()
        ).allMatch(count -> count < 2);
    }
}

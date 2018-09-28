package avdw.java.sodoku.validator;

import avdw.java.sodoku.model.Cell;

import java.util.List;

public interface Validator {
    Boolean isValid(List<Cell> cells);
}

package avdw.java.sodoku.difficulty;

import avdw.java.sodoku.model.Grid;

public interface Difficulty {
    Grid apply(Grid grid);
}

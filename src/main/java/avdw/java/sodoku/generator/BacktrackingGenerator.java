package avdw.java.sodoku.generator;

import avdw.java.sodoku.model.Cell;
import avdw.java.sodoku.model.Grid;
import avdw.java.sodoku.validator.Validator;

import javax.inject.Inject;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BacktrackingGenerator implements Generator {
    private final Grid grid;
    private Validator validator;

    @Inject
    BacktrackingGenerator(Grid grid, Validator validator) {
        this.grid = grid;
        this.validator = validator;
    }

    public Grid generate() {
        Stack<Cell> visited = new Stack();
        IntStream.range(0, i).forEach(x->{
            IntStream.range(0, j).forEach(y->{

            });
        });
        return null;
    }
}

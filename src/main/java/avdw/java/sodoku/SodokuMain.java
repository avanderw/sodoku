package avdw.java.sodoku;

import avdw.java.sodoku.difficulty.Difficulty;
import avdw.java.sodoku.generator.Generator;
import avdw.java.sodoku.model.Grid;
import avdw.java.sodoku.solver.Solver;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.pmw.tinylog.Logger;

public class SodokuMain {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SodokuModule());
        Generator generator = injector.getInstance(Generator.class);
        Solver solver = injector.getInstance(Solver.class);
        Difficulty difficulty = injector.getInstance(Difficulty.class);

        Grid generatedGrid = generator.generate();
        Grid configuredGrid = difficulty.apply(generatedGrid);
        Grid solvedGrid = solver.solve(configuredGrid);

        Logger.info(String.format("generatedGrid.equals(solvedGrid)=%s", generatedGrid.equals(solvedGrid)));
    }
}

package avdw.java.sodoku;

import avdw.java.sodoku.difficulty.Difficulty;
import avdw.java.sodoku.generator.Generator;
import avdw.java.sodoku.model.Grid;
import avdw.java.sodoku.solver.Solver;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SodokuMain {
    public static void main(String[] args) {
        Configurator.currentConfig()
                .formatPattern("{date:yyyy-MM-dd HH:mm:ss} [{thread}] {class}.{method}() {level}: {message}")
                .activate();

        Injector injector = Guice.createInjector(new SodokuModule());
        Generator generator = injector.getInstance(Generator.class);
        Solver solver = injector.getInstance(Solver.class);
        Difficulty difficulty = injector.getInstance(Difficulty.class);

        Integer generationCount = 100;
        List<Grid> generatedGrids = new ArrayList();
        DescriptiveStatistics generationStats = new DescriptiveStatistics();
        Logger.info(String.format("Staring generation of a %s grids", generationCount));
        Long totalGridGenerationStart = System.currentTimeMillis();
        IntStream.range(0, generationCount).forEach(count -> {
            Long gridGenerationStart = System.currentTimeMillis();
            Grid grid = generator.generate();
            generationStats.addValue(System.currentTimeMillis() - gridGenerationStart);
            generatedGrids.add(grid);
        });
        Logger.info(String.format("Generation took %,dms", System.currentTimeMillis() - totalGridGenerationStart));
        Logger.info(generationStats);

        Grid generatedGrid = generator.generate();
        Grid configuredGrid = difficulty.apply(generatedGrid);
        Grid solvedGrid = solver.solve(configuredGrid);

        Logger.info(String.format("Generation example%n%s", generatedGrid));
        //Logger.info(String.format("generatedGrid.equals(solvedGrid)=%s", generatedGrid.equals(solvedGrid)));
    }
}

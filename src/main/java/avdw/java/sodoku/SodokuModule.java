package avdw.java.sodoku;

import avdw.java.sodoku.difficulty.DifficultyModule;
import avdw.java.sodoku.generator.GeneratorModule;
import avdw.java.sodoku.mapper.MapperModule;
import avdw.java.sodoku.model.Block;
import avdw.java.sodoku.model.CellType;
import avdw.java.sodoku.solver.SolverModule;
import avdw.java.sodoku.validator.ValidatorModule;
import com.google.common.collect.BiMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class SodokuModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ValidatorModule());
        install(new GeneratorModule());
        install(new DifficultyModule());
        install(new SolverModule());
        install(new MapperModule());

        Range xRange1 = (Range.range(0, BoundType.CLOSED, 2, BoundType.CLOSED));
        Range xRange2 = (Range.range(3, BoundType.CLOSED, 5, BoundType.CLOSED));
        Range xRange3 = (Range.range(6, BoundType.CLOSED, 8, BoundType.CLOSED));
        Range yRange1 = (Range.range(0, BoundType.CLOSED, 2, BoundType.CLOSED));
        Range yRange2 = (Range.range(3, BoundType.CLOSED, 5, BoundType.CLOSED));
        Range yRange3 = (Range.range(6, BoundType.CLOSED, 8, BoundType.CLOSED));
        Multibinder<Block> blockMultibinder = Multibinder.newSetBinder(binder(), Block.class);
        blockMultibinder.addBinding().toInstance(new Block(xRange1, yRange1));
        blockMultibinder.addBinding().toInstance(new Block(xRange2, yRange1));
        blockMultibinder.addBinding().toInstance(new Block(xRange3, yRange1));
        blockMultibinder.addBinding().toInstance(new Block(xRange1, yRange2));
        blockMultibinder.addBinding().toInstance(new Block(xRange2, yRange2));
        blockMultibinder.addBinding().toInstance(new Block(xRange3, yRange2));
        blockMultibinder.addBinding().toInstance(new Block(xRange1, yRange3));
        blockMultibinder.addBinding().toInstance(new Block(xRange2, yRange3));
        blockMultibinder.addBinding().toInstance(new Block(xRange3, yRange3));
    }
}

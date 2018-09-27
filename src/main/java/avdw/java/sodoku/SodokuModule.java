package avdw.java.sodoku;

import avdw.java.sodoku.difficulty.DifficultyModule;
import avdw.java.sodoku.generator.GeneratorModule;
import avdw.java.sodoku.model.CellType;
import avdw.java.sodoku.solver.SolverModule;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class SodokuModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new GeneratorModule());
        install(new DifficultyModule());
        install(new SolverModule());

        Multibinder<CellType> cellTypeMultibinder = Multibinder.newSetBinder(binder(), CellType.class);
        cellTypeMultibinder.addBinding().toInstance(CellType.A);
        cellTypeMultibinder.addBinding().toInstance(CellType.B);
        cellTypeMultibinder.addBinding().toInstance(CellType.C);
        cellTypeMultibinder.addBinding().toInstance(CellType.D);
        cellTypeMultibinder.addBinding().toInstance(CellType.E);
        cellTypeMultibinder.addBinding().toInstance(CellType.F);
        cellTypeMultibinder.addBinding().toInstance(CellType.G);
        cellTypeMultibinder.addBinding().toInstance(CellType.H);
        cellTypeMultibinder.addBinding().toInstance(CellType.I);
    }
}

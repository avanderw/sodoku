package avdw.java.sodoku;

import avdw.java.sodoku.generator.GeneratorModule;
import avdw.java.sodoku.solver.SolverModule;
import com.google.inject.AbstractModule;

public class SodokuModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new GeneratorModule());
        install(new SolverModule());
    }
}

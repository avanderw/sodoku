package avdw.java.sodoku.solver;

import com.google.inject.AbstractModule;

public class SolverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Solver.class).to(BacktrackingSolver.class);
    }
}

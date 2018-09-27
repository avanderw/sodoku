package avdw.java.sodoku.generator;

import com.google.inject.AbstractModule;

public class GeneratorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Generator.class).to(BacktrackingGenerator.class);
    }
}

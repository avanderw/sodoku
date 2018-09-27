package avdw.java.sodoku.difficulty;

import com.google.inject.AbstractModule;

public class DifficultyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Difficulty.class).to(EasyDifficulty.class);
    }
}

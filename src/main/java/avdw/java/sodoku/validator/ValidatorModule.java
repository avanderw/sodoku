package avdw.java.sodoku.validator;

import com.google.inject.AbstractModule;

public class ValidatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Validator.class).to(UniquenessValidator.class);
    }
}

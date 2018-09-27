package avdw.java.sodoku;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SodokuMain {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SodokuModule());
    }
}

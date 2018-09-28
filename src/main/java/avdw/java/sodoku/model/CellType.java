package avdw.java.sodoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CellType {
    A, B, C, D, E, F, G, H, I, BLANK;

    static List<CellType> usedValues;
    static List<CellType> usedValues() {
        if (usedValues == null) {
            usedValues = new ArrayList<>();
            usedValues.addAll(Arrays.asList(values()));
            usedValues.remove(BLANK);
        }

        return usedValues;
    }
}

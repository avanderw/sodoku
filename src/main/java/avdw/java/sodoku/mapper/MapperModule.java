package avdw.java.sodoku.mapper;

import avdw.java.sodoku.model.CellType;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class MapperModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Singleton
    @Provides
    BiMap<CellType, Integer> provideCellTypeIntegerBiMap() {
        BiMap<CellType, Integer> cellTypeIntegerBiMap = HashBiMap.create(9);
        cellTypeIntegerBiMap.put(CellType.BLANK, 0);
        cellTypeIntegerBiMap.put(CellType.A, 1);
        cellTypeIntegerBiMap.put(CellType.B, 2);
        cellTypeIntegerBiMap.put(CellType.C, 3);
        cellTypeIntegerBiMap.put(CellType.D, 4);
        cellTypeIntegerBiMap.put(CellType.E, 5);
        cellTypeIntegerBiMap.put(CellType.F, 6);
        cellTypeIntegerBiMap.put(CellType.G, 7);
        cellTypeIntegerBiMap.put(CellType.H, 8);
        cellTypeIntegerBiMap.put(CellType.I, 9);
        return cellTypeIntegerBiMap;
    }
}

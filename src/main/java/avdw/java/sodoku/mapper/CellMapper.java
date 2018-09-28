package avdw.java.sodoku.mapper;

import avdw.java.sodoku.model.CellType;
import com.google.common.collect.BiMap;
import com.google.inject.Inject;

public class CellMapper {
    private BiMap<CellType, Integer> cellTypeIntegerBiMap;

    @Inject
    CellMapper(BiMap<CellType, Integer> cellTypeIntegerBiMap) {
        this.cellTypeIntegerBiMap = cellTypeIntegerBiMap;
    }

    public CellType toCellType(Integer value) {
        return cellTypeIntegerBiMap.inverse().get(value);
    }

    public Integer toInteger(CellType cellType) {
        return cellTypeIntegerBiMap.get(cellType);
    }
}

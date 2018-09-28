package avdw.java.sodoku;

import avdw.java.sodoku.model.Grid;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.stream.IntStream;

public class SodokuConstant {
    public static final int[][] UNSOLVED_GRID1 =
            {
                    {8, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 6, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 9, 0, 2, 0, 0},
                    {0, 5, 0, 0, 0, 7, 0, 0, 0},
                    {0, 0, 0, 0, 4, 5, 7, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 3, 0},
                    {0, 0, 1, 0, 0, 0, 0, 6, 8},
                    {0, 0, 8, 5, 0, 0, 0, 1, 0},
                    {0, 9, 0, 0, 0, 0, 4, 0, 0},
            };


    public static final int[][] UNSOLVED_GRID2 =
            {
                    {1, 0, 0, 0, 0, 7, 0, 9, 0},
                    {0, 3, 0, 0, 2, 0, 0, 0, 8},
                    {0, 0, 9, 6, 0, 0, 5, 0, 0},
                    {0, 0, 5, 3, 0, 0, 9, 0, 0},
                    {0, 0, 0, 0, 4, 5, 7, 0, 0},
                    {0, 1, 0, 0, 8, 0, 0, 0, 2},
                    {3, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 4, 0, 0, 0, 0, 0, 0, 7},
                    {0, 0, 7, 0, 0, 0, 3, 0, 0},
            };

}

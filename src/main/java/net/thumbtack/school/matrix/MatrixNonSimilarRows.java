package net.thumbtack.school.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class MatrixNonSimilarRows {

    private Set<int[]> container = new HashSet<>();
    private Set<int[]> result = new HashSet<>();
    private int[][] matrix;


    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Set<Integer> setForNumbersPrevious = new HashSet<>();
        Set<Integer> setForNumbersCurrent = new HashSet<>();
        for (int i = 1; i < matrix.length; i++) {
            for (int value : matrix[i - 1])
                setForNumbersPrevious.add(value);
            for (int value : matrix[i])
                setForNumbersCurrent.add(value);
            if (!Arrays.equals(setForNumbersCurrent.toArray(), setForNumbersPrevious.toArray())) {
                if (!check(matrix[i - 1]))
                    result.add(matrix[i - 1]);
                if (!check(matrix[i]))
                    result.add(matrix[i]);
            }
            container.add(sortDistinct(matrix[i-1]));
            container.add(sortDistinct(matrix[i]));
            setForNumbersPrevious.clear();
            setForNumbersCurrent.clear();
        }
        return result;
    }

    private boolean check(int[] array) {
        return container.stream().anyMatch(row -> Arrays.equals(row, sortDistinct(array)));
    }

    private int[] sortDistinct(int[] array) {
        Arrays.sort(array);
        return IntStream.of(array).distinct().toArray();
    }
}

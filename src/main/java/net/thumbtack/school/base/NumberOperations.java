package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {


    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == value)
                return i;
        return null;
    }


    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++)
            if (array[i] <= value + eps && array[i] >= value - eps)
                return i;
        return null;
    }


    public static Double calculateDensity(double weight, double volume, double min, double max) {
        double destiny = weight / volume;
        if (destiny <= max && destiny >= min)
            return destiny;
        return null;
    }


    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(value))
                return i;
        return null;
    }


    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        BigDecimal p = weight.divide(volume);
        if (p.compareTo(max) <= 0 && p.compareTo(min) >= 0)
            return p;
        return null;
    }
}

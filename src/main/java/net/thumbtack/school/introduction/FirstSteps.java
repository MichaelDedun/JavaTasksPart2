package net.thumbtack.school.introduction;

public class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum;
    }

    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int mul = 1;
        for (int anArray : array) {
            mul *= anArray;
        }
        return mul;
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int anArray : array) {
            if (anArray < min) {
                min = anArray;
            }
        }
        return min;
    }


    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int anArray : array) {
            if (max < anArray) {
                max = anArray;
            }
        }
        return max;
    }


    public double average(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int x = array[i];
            array[i] *= x * x;
        }
    }

    public boolean find(int[] array, int value) {
        for (int anArray : array) {
            if (anArray == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] matrix1 : matrix) {
            sum += sum(matrix1);
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] matrix1 : matrix) {
            if (max(matrix1) > max) {
                max = max(matrix1);
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][i]) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            if (!isSortedDescendant(matrix1)) {
                return false;
            }
        }
        return true;
    }
}

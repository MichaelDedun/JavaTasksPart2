package net.thumbtack.school.base;

public class StringOperations {


    public static int getSummaryLength(String[] strings) {
        int length = 0;
        for (String string : strings) length += string.length();
        return length;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.charAt(0) + string.substring(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) == string2.endsWith(suffix);
    }


    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < Math.min(string1.length(), string2.length()); i++)
            if (string1.charAt(i) == string2.charAt(i))
                s.append(string1.charAt(i));
            else break;
        return s.toString();
    }

    public static String reverse(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }


    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }


    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }


    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String string = "";
        for (String s : strings)
            if (isPalindromeIgnoreCase(s) && s.length() > string.length())
                string = s;
        return string;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return string1.length() >= length+index && string2.length() >=
                length+index && string1.substring(index, index + length)
                .equals(string2.substring(index, index + length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1)
                .equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replaceAll(replaceInStr1, replaceByInStr1)
                .equals(string2.replaceAll(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replaceAll("\\s",""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        String result = "";
        if (array.length != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int s: array) {
                stringBuilder.append(s).append(",");
            }
            result = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        }
        return result;
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        String result = "";
        if (array.length != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (double s: array) {
                stringBuilder.append(String.format("%.2f",s)).append(",");
            }
            result = stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
        }
        return result;
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return  new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return  new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            sb.deleteCharAt(positions[i]);
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--)
            sb.insert(positions[i], characters[i]);
        return sb;
    }
}

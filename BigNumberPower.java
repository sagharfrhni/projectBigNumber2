import java.util.Scanner;

public class BigNumberPower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a big number:");
        String base = scanner.nextLine();

        System.out.print("enter exponent:");
        int exponent = scanner.nextInt();

        String result = power(base, exponent);
        System.out.println(result);
    }

    public static String power(String base, int exponent) {
        boolean isNegativeBase = base.startsWith("-");
        if (isNegativeBase) {
            base = base.substring(1);
            if (exponent % 2 == 1) {
                System.out.print("-");
            }
        }

        if (exponent < 0) {
            throw new IllegalArgumentException("It should not be negative!!!");
        }

        if (exponent == 0) {
            return "1";
        }

        int[] baseArray = stringToArray(base);
        int[] result = {1};

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiply(result, baseArray);
            }
            baseArray = multiply(baseArray, baseArray);
            exponent /= 2;
        }

        String resultString = arrayToString(result);
        return resultString;
    }

    private static int[] stringToArray(String str) {
        int[] array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(str.length() - 1 - i) - '0';//reverse
        }
        return array;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(array[i]);
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }

    private static int[] multiply(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += a[i] * b[j];
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }
        return result;
    }
}

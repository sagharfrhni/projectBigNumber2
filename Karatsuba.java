import java.math.BigInteger;

class Karatsuba {

    public BigInteger multiply(BigInteger x, BigInteger y) {

        if (x.equals(BigInteger.ZERO) || y.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        if (x.compareTo(BigInteger.TEN) < 0 || y.compareTo(BigInteger.TEN) < 0) {
            return x.multiply(y);
        }

        int n = Math.max(x.toString().length(), y.toString().length());
        int halfN = n / 2;

        BigInteger high1 = x.divide(BigInteger.TEN.pow(halfN));
        BigInteger low1 = x.subtract(high1.multiply(BigInteger.TEN.pow(halfN)));
        BigInteger high2 = y.divide(BigInteger.TEN.pow(halfN));
        BigInteger low2 = y.subtract(high2.multiply(BigInteger.TEN.pow(halfN)));

        BigInteger z0 = multiply(low1, low2); // low1 * low2
        BigInteger z1 = multiply(low1.add(high1), low2.add(high2)); // (low1 + high1) * (low2 + high2)
        BigInteger z2 = multiply(high1, high2); // high1 * high2
        //result
        return z2.multiply(BigInteger.TEN.pow(2 * halfN)).add(
                z1.subtract(z2).subtract(z0).multiply(BigInteger.TEN.pow(halfN))).add(z0);
    }
}


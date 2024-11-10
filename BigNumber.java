import java.math.BigInteger;
import java.util.Scanner;

class BigNumber {
    private BigInteger value;
    private boolean isNegative;

    public BigNumber(String value) {
        if (value.startsWith("-")) {
            this.isNegative = true;
            this.value = new BigInteger(value.substring(1));
        } else {
            this.isNegative = false;
            this.value = new BigInteger(value);
        }
    }

    public BigNumber multiply(BigNumber other) {

        BigInteger productValue = this.value.multiply(other.value);
        boolean productIsNegative = this.isNegative ^ other.isNegative;
        return new BigNumber((productIsNegative ? "-" : "") + productValue.toString());
    }

    public BigNumber divide(BigNumber other) {
        if (other.value.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }

        BigInteger quotientValue = this.value.divide(other.value);
        boolean quotientIsNegative = this.isNegative ^ other.isNegative;
        return new BigNumber((quotientIsNegative ? "-" : "") + quotientValue.toString());
    }

    @Override
    public String toString() {
        return (isNegative ? "-" : "") + value.toString();
    }
}

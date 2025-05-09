import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class RationalTest {

    // Helper methods

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-15;

    private void assertDoublesEqual(double x, double y) {
        assertThat(x).isEqualTo(y, within(DOUBLE_EQUALITY_TOLERANCE));
    }

    // Tests

    @Test
    public void testAddTwoPositiveRationalNumbers() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).add(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAddAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).add(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAddTwoNegativeRationalNumbers() {
        Rational expected = new Rational(-7, 6);
        Rational actual = new Rational(-1, 2).add(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAddARationalNumberToItsAdditiveInverse() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).add(new Rational(-1, 2));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSubtractTwoPositiveRationalNumbers() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSubtractAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSubtractTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 6);
        Rational actual = new Rational(-1, 2).subtract(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSubtractARationalNumberFromItself() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).subtract(new Rational(1, 2));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyTwoPositiveRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyANegativeRationalNumberByAPositiveRationalNumber() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyARationalNumberByItsReciprocal() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).multiply(new Rational(1, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiplyARationalNumberByZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(0, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivideTwoPositiveRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivideAPositiveRationalNumberByANegativeRationalNumber() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivideTwoNegativeRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(-1, 2).divide(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivideARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).divide(new Rational(1, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAbsoluteValueOfAPositiveRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAbsoluteValueOfAPositiveRationalNumberWithNegativeNumeratorAndDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, -2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAbsoluteValueOfANegativeRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, 2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAbsoluteValueOfANegativeRationalNumberWithNegativeDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, -2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAbsoluteValueOfZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).abs();
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testAbsoluteValueOfARationalNumberIsReducedToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseAPositiveRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(1, 8);
        Rational actual = new Rational(1, 2).pow(3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseANegativeRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(-1, 8);
        Rational actual = new Rational(-1, 2).pow(3);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testRaiseAPositiveRationalNumberToANegativeIntegerPower() {
        Rational expected = new Rational(25, 9);
        Rational actual = new Rational(3, 5).pow(-2);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testRaiseANegativeRationalNumberToAnEvenNegativeIntegerPower() {
        Rational expected = new Rational(25, 9);
        Rational actual = new Rational(-3, 5).pow(-2);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testRaiseANegativeRationalNumberToAnOddNegativeIntegerPower() {
        Rational expected = new Rational(-125, 27);
        Rational actual = new Rational(-3, 5).pow(-3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseZeroToAnIntegerPower() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).pow(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseOneToAnIntegerPower() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 1).pow(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseAPositiveRationalNumberToThePowerOfZero() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(-1, 2).pow(0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testRaiseARealNumberToAPositiveRationalNumber() {
        double expected = 16.0;
        double actual = new Rational(4, 3).exp(8.0);
        assertDoublesEqual(expected, actual);
    }

    @Test
    public void testRaiseARealNumberToANegativeRationalNumber() {
        double expected = 1.0 / 3;
        double actual = new Rational(-1, 2).exp(9);
        assertDoublesEqual(expected, actual);
    }

    @Test
    public void testReduceAPositiveRationalNumberToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testReducePlacesTheMinusSignOnTheNumerator() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(3, -4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReduceANegativeRationalNumberToLowestTerms() {
        Rational expected = new Rational(-2, 3);
        Rational actual = new Rational(-4, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReduceARationalNumberWithANegativeDenominatorToLowestTerms() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(3, -9);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReduceZeroToLowestTerms() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReduceAnIntegerToLowestTerms() {
        Rational expected = new Rational(-2, 1);
        Rational actual = new Rational(-14, 7);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReduceOneToLowestTerms() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(13, 13);
        assertThat(actual).isEqualTo(expected);
    }
}

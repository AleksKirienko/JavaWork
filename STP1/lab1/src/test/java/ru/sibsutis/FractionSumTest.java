package ru.sibsutis;

import junit.framework.TestCase;
import org.junit.Test;

public class FractionSumTest extends TestCase {

    @Test
    public void testSum1() {
        Fraction fr1 = new Fraction(3, 5);
        Fraction fr2 = new Fraction(2, 5);
        int actual = fr1.sum(fr2).compare(new Fraction(1, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSum2() {
        Fraction fr1 = new Fraction(2, 1);
        Fraction fr2 = new Fraction(1, 1);
        int actual = fr1.sum(fr2).compare(new Fraction(3, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSum3() {
        Fraction fr1 = new Fraction(5, 2);
        Fraction fr2 = new Fraction(1, 4);
        int actual = fr1.sum(fr2).compare(new Fraction(11, 4));
        int expected = 0;
        assertEquals(expected, actual);
    }

    public void testSum4() {
        Fraction fr1 = new Fraction(4, 3);
        Fraction fr2 = new Fraction(8, 4);
        int actual = fr1.sum(fr2).compare(new Fraction(10, 3));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSum5() {
        Fraction fr1 = new Fraction(15, 6);
        Fraction fr2 = new Fraction(3, 2);
        int actual = fr1.sum(fr2).compare(new Fraction(4, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
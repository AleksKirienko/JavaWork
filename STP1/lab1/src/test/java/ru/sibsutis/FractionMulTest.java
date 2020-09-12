package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionMulTest {

    @Test
    public void testMul1() {
        Fraction fr1 = new Fraction(-1, 3);
        Fraction fr2 = new Fraction(2, 3);

        int actual = fr1.mul(fr2).compare(new Fraction(-2, 9));
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void testMul2() {
        Fraction fr1 = new Fraction (0, 1);
        Fraction fr2 = new Fraction (3, 1);

        int actual = fr1.mul(fr2).compare(new Fraction(0, 0));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul3() {
        Fraction fr1 = new Fraction (2, 3);
        Fraction fr2 = new Fraction (3, 1);

        int actual = fr1.mul(fr2).compare(new Fraction(2));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul4() {
        Fraction fr1 = new Fraction (-1, 3);
        Fraction fr2 = new Fraction (2, 3);

        int actual = fr1.mul(fr2).compare(new Fraction(-2,9));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul5() {
        Fraction fr1 = new Fraction (0);
        Fraction fr2 = new Fraction (3);

        int actual = fr1.mul(fr2).compare(new Fraction(0));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
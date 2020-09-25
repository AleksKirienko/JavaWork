package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class TFractMulTest {

    @Test
    public void testMul1() {
        Fraction fr1 = new TFract(-1, 3);
        Fraction fr2 = new TFract(2, 3);

        int actual = fr1.mul(fr2).compare(new TFract(-2, 9));
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void testMul2() {
        Fraction fr1 = new TFract (0, 1);
        Fraction fr2 = new TFract (3, 1);

        int actual = fr1.mul(fr2).compare(new TFract(0, 0));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul3() {
        Fraction fr1 = new TFract (2, 3);
        Fraction fr2 = new TFract (3, 1);

        int actual = fr1.mul(fr2).compare(new TFract(2));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul4() {
        Fraction fr1 = new TFract (-1, 3);
        Fraction fr2 = new TFract (2, 3);

        int actual = fr1.mul(fr2).compare(new TFract(-2,9));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMul5() {
        Fraction fr1 = new TFract (0);
        Fraction fr2 = new TFract (3);

        int actual = fr1.mul(fr2).compare(new TFract(0));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
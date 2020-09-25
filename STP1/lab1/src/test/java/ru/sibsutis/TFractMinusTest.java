package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class TFractMinusTest {

    @Test
    public void testMinus1() {
        Fraction fr1 = new TFract(-1, 3);

        int actual = fr1.minus().compare(new TFract(1, 3));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMinus2() {
        Fraction fr1 = new TFract(1, 2);

        int actual = fr1.minus().compare(new TFract(-1, 2));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMinus3() {
        Fraction fr1 = new TFract(0, 1);

        int actual = fr1.minus().compare(new TFract(0, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
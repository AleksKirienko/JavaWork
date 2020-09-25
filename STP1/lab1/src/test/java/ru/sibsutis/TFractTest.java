package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class TFractTest {

    @Test
    public void testSq1() {
        Fraction fr1 = new TFract(-1, 3);

        int actual = fr1.square().compare(new TFract(1, 9));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSq2() {
        Fraction fr1 = new TFract(3, 2);

        int actual = fr1.square().compare(new TFract(9, 4));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSq3() {
        Fraction fr1 = new TFract(0, 1);

        int actual = fr1.square().compare(new TFract(0, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
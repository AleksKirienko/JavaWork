package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class TFractReverseTest {

    @Test
    public void testReverse1() {
        Fraction fr1 = new TFract(-1, 3);

        int actual = fr1.reverse().compare(new TFract(-3, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testReverse2() {
        Fraction fr1 = new TFract(2, 1);

        int actual = fr1.reverse().compare(new TFract(1, 2));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testReverse3() {
        Fraction fr1 = new TFract(1, 2);

        int actual = fr1.reverse().compare(new TFract(2, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
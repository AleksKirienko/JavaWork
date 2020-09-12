package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionDivTest {

    @Test
    public void testDiv1() {
        Fraction fr1 = new Fraction(-1, 3);
        Fraction fr2 = new Fraction(2, 3);

        int actual = fr1.div(fr2).compare(new Fraction(-1, 2));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testDiv2() {
        Fraction fr1 = new Fraction(0, 1);
        Fraction fr2 = new Fraction(-1, 3);

        int actual = fr1.div(fr2).compare(new Fraction(0));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testDiv3() {
        Fraction fr1 = new Fraction(2, 3);
        Fraction fr2 = new Fraction(3, 1);

        int actual = fr1.div(fr2).compare(new Fraction(2, 9));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
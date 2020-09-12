package ru.sibsutis;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionSubTest {

    @Test
    public void testSub1() {
        Fraction fr1 = new Fraction(-1, 3);
        Fraction fr2 = new Fraction(2, 3);

        int actual = fr1.sub(fr2).compare(new Fraction(-1));
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void testSub2() {
        Fraction fr1 = new Fraction(0, 1);
        Fraction fr2 = new Fraction(3, 1);

        int actual = fr1.sub(fr2).compare(new Fraction(-3, 1));
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSub3() {
        Fraction fr1 = new Fraction(2, 3);
        Fraction fr2 = new Fraction(3, 1);

        int actual = fr1.sub(fr2).compare(new Fraction(-7, 3));
        int expected = 0;
        assertEquals(expected, actual);
    }
}
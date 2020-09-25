package ru.sibsutis;

abstract public class Fraction {
    protected int denominator;
    protected int numerator;

    Fraction(int a, int b) {
        construct(a, b);
    }

    Fraction(String str) {
        String[] subStr = str.split("[/ ]");
        try {
            int a = Integer.parseInt(subStr[0]);
            int b = Integer.parseInt(subStr[1]);

            construct(a, b);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Failed to create Fraction with given string " + str, e);
        }
    }

    Fraction(int a) {
        denominator = 1;
        numerator = a;
    }

    Fraction() {
        denominator = 1;
        numerator = 0;
    }

    private int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private void construct(int a, int b) {
        int tmp = 1;
        if (a != 0 && b != 0) {
            tmp = gcd(Math.abs(a), Math.abs(b));
        }
        denominator = b / tmp;
        numerator = a / tmp;
        if (denominator < 0) {
            numerator *= (-1);
            denominator *= (-1);
        }
    }

    abstract public Fraction copy();

    abstract public Fraction square();

    abstract public Fraction reverse();

    abstract public Fraction minus();

    abstract public int getNumerator();

    abstract public int getDenominator();

    abstract public String getStr();

    abstract public Fraction sum(Fraction b);

    abstract public Fraction sub(Fraction b);

    abstract public Fraction mul(Fraction b);

    abstract public Fraction div(Fraction b);

    abstract public int compare(Fraction b);

}
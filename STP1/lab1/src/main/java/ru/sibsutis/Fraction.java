package ru.sibsutis;

public class Fraction {
    private int denominator;
    private int numerator;

    Fraction(int a, int b) {

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

    public int getNumerator() {
        return numerator;
    }

    public Fraction sum(Fraction b) {
        Fraction res = new Fraction(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
        return res;
    }

    public Fraction sub(Fraction b) {
        Fraction res = new Fraction(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
        return res;
    }

    public Fraction mul(Fraction b) {
        Fraction res = new Fraction(numerator * b.numerator, denominator * b.denominator);
        return res;
    }

    public Fraction div(Fraction b) {
        Fraction res = new Fraction(numerator * b.denominator, denominator * b.numerator);

        return res;
    }

    public void print() {
        if (denominator != 1 && numerator != 0) {
            System.out.print(numerator + "/" + denominator + "\t");
        } else {
            System.out.print(numerator + "\t");
        }

    }

    public int compare(Fraction b) {
        if (denominator * b.numerator < numerator * b.denominator) {
            return 1;
        } else if (denominator * b.numerator == numerator * b.denominator) {
            return 0;
        }
        return -1;
    }

    public Fraction absolute() {
        return new Fraction(Math.abs(numerator), Math.abs(denominator));
    }
}

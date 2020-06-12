package ru.sibsutis;

class Fraction {
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

    public int getDenominator() {
        return denominator;
    }

    public Fraction sum(Fraction a, Fraction b) {
        Fraction res = new Fraction(a.numerator * b.denominator + b.numerator * a.denominator, a.denominator * b.denominator);
        return res;
    }

    public Fraction sub(Fraction a, Fraction b) {
        int numerator = a.numerator * b.denominator - b.numerator * a.denominator;
        int denominator = a.denominator * b.denominator;
        denominator = numerator == 0 ? 1 : denominator;
        Fraction res = new Fraction(numerator, denominator);
        return res;
    }

    public Fraction mul(Fraction a, Fraction b) {
        Fraction res = new Fraction(a.numerator * b.numerator, a.denominator * b.denominator);
        return res;
    }

    public Fraction div(Fraction a, Fraction b) {
        Fraction res = new Fraction(a.numerator * b.denominator, a.denominator * b.numerator);

        return res;
    }

    public void print(Fraction a) {
        if (a.denominator != 1 && a.numerator != 0) {
            System.out.print(a.numerator + "/" + a.denominator + "\t");
        } else {
            System.out.print(a.numerator + "\t");
        }
    }

    public int compare(Fraction a, Fraction b) {
        if (a.denominator * b.numerator < a.numerator * b.denominator) {
            return 1;
        } else if (a.denominator * b.numerator == a.numerator * b.denominator) {
            return 0;
        }
        return -1;
    }

    public Fraction absolute(Fraction a) {
        return new Fraction(Math.abs(a.numerator), Math.abs(a.denominator));
    }
}

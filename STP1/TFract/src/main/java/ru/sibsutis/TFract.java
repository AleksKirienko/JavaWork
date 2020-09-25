package ru.sibsutis;

public class TFract extends Fraction {
    TFract(int a, int b) {
        super(a, b);
    }

    TFract(String str) {
        super(str);
    }

    TFract(int a) {
        super(a);
    }

    TFract() {
        super();
    }

    public Fraction copy() {
        return new TFract(numerator, denominator);
    }

    public Fraction square() {
        return new TFract(numerator * numerator, denominator * denominator);
    }

    public Fraction reverse() {
        return new TFract(denominator, numerator);
    }

    public Fraction minus() {
        return new TFract(numerator * (-1), denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getStr() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }

    public Fraction sum(Fraction b) {
        return new TFract(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
    }

    public Fraction sub(Fraction b) {
        return new TFract(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
    }

    public Fraction mul(Fraction b) {
        return new TFract(numerator * b.numerator, denominator * b.denominator);
    }

    public Fraction div(Fraction b) {
        if (b.numerator == 0) {
            throw new RuntimeException("Failed to division by 0 ");
        }
        return new TFract(numerator * b.denominator, denominator * b.numerator);
    }

    public int compare(Fraction b) {
        if (denominator * b.numerator < numerator * b.denominator) {
            return 1;
        } else if (denominator * b.numerator == numerator * b.denominator) {
            return 0;
        }
        return -1;
    }
}

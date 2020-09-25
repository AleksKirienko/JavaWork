package ru.sibsutis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("First fraction: ");
            String str = br.readLine();

            Fraction fr1 = new TFract(str);

            System.out.println("Second fraction: ");
            str = br.readLine();

            Fraction fr2 = new TFract(str);

            System.out.println("\nSum = " + fr1.sum(fr2).getStr());

            System.out.println("Sub = " + fr1.sub(fr2).getStr());

            System.out.println("Mul = " + fr1.mul(fr2).getStr());

            System.out.println("Div = " + fr1.div(fr2).getStr());

        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
        }
    }
}

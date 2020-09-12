package ru.sibsutis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            int a, b;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String delimeter = "/"; // Разделитель
            System.out.println("First fraction: ");
            String str = br.readLine();
            String[] subStr = str.split(delimeter);
            a = Integer.parseInt(subStr[0]);
            b = Integer.parseInt(subStr[1]);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            Fraction fr1 = new Fraction(a, b);

            System.out.println("Second fraction: ");
            str = br.readLine();
            subStr = str.split(delimeter);
            a = Integer.parseInt(subStr[0]);
            b = Integer.parseInt(subStr[1]);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            br.close();
//            System.out.println(new String(str).toLowerCase());
            Fraction fr2 = new Fraction(a, b);

            System.out.print("\nSum = ");
            fr1.sum(fr2).print();
            System.out.println();

            System.out.print("Sub = ");
            fr1.sub(fr2).print();
            System.out.println();

            System.out.print("Mul = ");
            fr1.mul(fr2).print();
            System.out.println();

            System.out.print("Div = ");
            fr1.div(fr2).print();
            System.out.println();


        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException: " + ex.getMessage());
        }
    }
}

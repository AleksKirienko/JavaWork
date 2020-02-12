package ru.sibsutis;

import java.util.InputMismatchException;
import java.util.Scanner;

class Calculchik {
	public static void main(String[] args) {
		var scn = new Scanner(System.in);
        Integer first, second, result;
        String operator;

        System.out.println("first=");
        first = scn.nextInt();
        System.out.println("\nperator=");
        operator = scn.next();
        System.out.println("\nsecond=");
        second = scn.nextInt();
        
        switch (operator) {
            case ("+"):
                result = first + second;
                break;
            case ("-"):
                result = first - second;
                break;
            case ("*"):
                result = first * second;
                break;
            case ("/"):
                result = first / second;
                break;
            default:
                System.out.println("Wrong input operator");
                return;
        }
        System.out.printf("%d %s %d = %d", first, operator, second, result);
	}
}

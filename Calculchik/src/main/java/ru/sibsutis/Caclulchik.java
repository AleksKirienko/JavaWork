package ru.sibsutis;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Caclulchik {
	public static void main(String[] args) {
		var scn = new Scanner(System.in);
        Integer first, second, result;
        String operator;

        first = scn.nextInt();
        operator = scn.next();
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

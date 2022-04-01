package by.jonline.pr02.decomposition;

import java.util.Scanner;

/*
 * Программа для нахождения наибольшего общего делителя и наименьшего общего кратного
 * двух чисел: НОК(А,В) = (А*В) / НОД(А,В)
 */

public class Task01 {

	public static void main(String[] args) {

		int a;
		int b;

		a = intFromKeyboard("First natural number a");
		b = intFromKeyboard("Second natural number b");

		if (a != 0 && b != 0) {
			System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a, b));
			System.out.print("LCM(" + a + ", " + b + ") = " + lcm(a, b));
		} else {
			System.out.println("GCD & LCM(" + a + ", " + b + ") doesn't exist");
		}
	}

	public static int intFromKeyboard(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message + " >> ");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.print(message + " >> ");
		}
		return sc.nextInt();
	}

	public static int gcd(int a, int b) { // Greatest Common Divisor (НОД с помощью алгоритма Евклида)

		int gcd = a >= b ? b : a;
		int tempA = a >= b ? a : b;
		int tempB = gcd;

		boolean decide = false;

		while (!decide) {
			if ((tempA % gcd == 0) && (tempB % gcd == 0)) {
				decide = true;
			} else {
				gcd = tempA % tempB;
				tempA = tempB;
				tempB = gcd;
			}
		}

		return gcd;

	}

	public static int lcm(int a, int b) { // Least Common Multiple (НОК)

		return (a * b) / (gcd(a, b));
	}

}

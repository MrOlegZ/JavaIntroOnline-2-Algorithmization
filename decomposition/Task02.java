package by.jonline.pr02.decomposition;

import java.util.Scanner;

/*
 * Программа для нахождения наибольшего общего делителя
 * четырех чисел: НОД(A,B,C,D)
 */

public class Task02 {

	public static void main(String[] args) {

		int a;
		int b;
		int c;
		int d;

		a = intFromKeyboard("1 natural number a");
		b = intFromKeyboard("2 natural number b");
		c = intFromKeyboard("3 natural number c");
		d = intFromKeyboard("4 natural number d");

		if (a != 0 && b != 0 && c != 0 && d != 0) {
			System.out.println("GCD(" + a + ", " + b + ", " + c + ", " + d + ") = " + gcd4(a, b, c, d));
		} else {
			System.out.println("GCD(" + a + ", " + b + ", " + c + ", " + d + ") doesn't exist");
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

	public static int gcd4(int a, int b, int c, int d) {

		return gcd(gcd(gcd(a, b), c), d);

	}

}

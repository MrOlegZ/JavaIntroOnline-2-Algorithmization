package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Написать метод (методы), проверяющий, являются ли данные 3 числа взаимно простыми
 */

public class Task06 {

	public static void main(String[] args) {
		
		int number1;
		int number2;
		int number3;
		int gcdThree;
		
		number1 = intFromScanner("Введите первое число", "");
		number2 = intFromScanner("Введите второе число", "");
		number3 = intFromScanner("Введите третье число", "");
		
		gcdThree = gcd(number1, gcd(number2, number3));
		
		if (gcdThree == 1) {
			System.out.printf("Числа %d, %d, %d - взаимнопростые", number1, number2, number3);
		} else {
			System.out.printf("Числа %d, %d, %d - не взаимнопростые", number1, number2, number3);
		}
	}
	
	public static int intFromScanner(String message, String numberSign) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int res;
		boolean decide; // Число удовлетворяет условиям

		System.out.print(message + " >> ");

		do {
			decide = false;
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Введено не целое число. ");
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();

			switch (numberSign) {
			case "Positive":
				if (res > 0) {
					decide = true;
				} else if (res == 0) {
					decide = false;
					System.out.print("Введен нуль. ");
					System.out.print(message + " >> ");
				} else {
					decide = false;
					System.out.print("Введено отрицательное число. ");
					System.out.print(message + " >> ");
				}
				break;

			case "Negative":
				if (res < 0) {
					decide = true;
				} else if (res == 0) {
					decide = false;
					System.out.print("Введен нуль. ");
					System.out.print(message + " >> ");
				} else {
					decide = false;
					System.out.print("Введено положительное число. ");
					System.out.print(message + " >> ");
				}
				break;

			default:
				decide = true;
			}

		} while (!decide);

		return res;
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

}

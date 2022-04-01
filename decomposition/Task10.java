package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Дано натуральное число N. Написать метод (методы) для формирования массива,
 * элементами которого являются цифры числа N
 */

public class Task10 {

	public static void main(String[] args) {

		long n;
		int numberOfDigit;

		n = longFromScanner("Введите натуральное число N", "Positive");
		numberOfDigit = countNumberOfDigit(n);

		long[] numberArray = new long[numberOfDigit];

		genArrayFromNumber(n, numberArray);
		printArrayLong(numberArray, "Массив, полученный из числа " + n + ":");
	}

	public static long longFromScanner(String message, String numberSign) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		long res;
		boolean decide; // Число удовлетворяет условиям

		System.out.print(message + " >> ");

		do {
			decide = false;
			while (!sc.hasNextLong()) {
				sc.nextLine();
				System.out.print("Введено не целое число. ");
				System.out.print(message + " >> ");
			}

			res = sc.nextLong();

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

	public static int countNumberOfDigit(long n) {
		int result = 0;
		n = Math.abs(n);

		while (n > 0) {
			result++;
			n /= 10;
		}
		return result;
	}

	public static void genArrayFromNumber(long n, long[] mas) {
		if (mas == null) {
			return;
		}

		int i = mas.length - 1;
		while (n > 0) {
			mas[i] = n % 10;
			i--;
			n /= 10;
		}

	}

	public static void printArrayLong(long[] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (long i : mas) {
			System.out.printf("%d;\t", i);
		}
		System.out.println();
	}
}

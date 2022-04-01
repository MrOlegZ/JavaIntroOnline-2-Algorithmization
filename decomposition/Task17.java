package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр
 * и т.д. Сколько таких действий надо произвести, чтобы получился 0. Для решения
 * Задачи использовать декомпозицию
 */

public class Task17 {

	public static void main(String[] args) {

		long number;
		number = longFromScanner("Введите целое число", "Positive");

		System.out.println("Для того, чтобы из заданного числа вычесть сумму его цифр, и далее");
		System.out.println("из результата снова вычесть сумму цифр и т.д. необходимо провести");
		System.out.printf("%d операций, чтобы получился 0", countToZero(number));
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

	public static int sumOfDigit(long number) {
		int sum = 0;

		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	public static int countToZero(long number) {
		int count = 0;
		while (number != 0) {
			count++;
			number -= sumOfDigit(number);
		}
		return count;
	}
}
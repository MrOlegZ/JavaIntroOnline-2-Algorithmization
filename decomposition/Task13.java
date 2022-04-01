package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Два простых числа называются "близнецами", если они отличаются друг от друга на 2
 * (например, 41 и 43). Найти и напечатать все пары "близнецов" из отрезка [n, 2n],
 * где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.
 */

public class Task13 {

	public static void main(String[] args) {

		int n;

		n = intFromScanner("Введите натуральное число n", "Positive");

		System.out.printf("На интервале %d, %d следующие цифры-близнецы:\n", n, 2 * n);
		findAllTwin(n);
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

	public static void findAllTwin(int n) {

		for (int i = n; i <= 2 * n - 2; i++) {
			if (isSimple(i) && isSimple(i + 2)) {
				System.out.printf("Пара близнецов: %d и %d\n", i, i + 2);
			}
		}
	}

	public static boolean isSimple(int number) {

		boolean result = true;

		switch (number) {
		case 0:
		case 1:
			result = false;
			break;
		default:
			int i = 2;
			while (i <= Math.sqrt(number)) {
				if (number % i == 0) {
					return false;
				}
				i++;
			}
			break;
		}
		return result;
	}
}

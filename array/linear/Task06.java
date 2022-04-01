package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Задана последовательность N вещественных чисел.
 * Вычислить сумму чисел, порядковые номера которых являются простыми числами.
 */

public class Task06 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений
		double sum = 0;

		n = intFromScanner("Введите размерность последовательности", true);

		double[] mas = new double[n];

		range = intFromScanner("Введите диапазон значений последовательности (± целое)", false);

		genArrayDouble(mas, range);

		printArrayDouble(mas, "Исходная последовательность:", "%.03f; ");

		System.out.printf("Простые числа при длине последовательности %d:\n", n);
		for (int i = 1; i < mas.length + 1; i++) {
			if (checkPrimeNumber(i)) {
				sum += mas[i - 1];
				System.out.print(i + "; ");
			}
		}

		System.out.printf(
				"\nСумма чисел последовательности, порядковые номера которых являются простыми числами, равна %.03f",
				sum);

	}

	public static int intFromScanner(String message, boolean mark) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// mark - метка положительного целого ненулевого числа

		int res;
		boolean decide = false;

		do {

			System.out.print(message + " >> ");

			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print(message + " >> ");
			}

			res = sc.nextInt();
			decide = ((mark) && (res <= 0)) ? true : false;

		} while (decide);

		return res;
	}

	public static void genArrayDouble(double[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = range * (rand.nextDouble() * 2d - 1d);
		}
	}

	public static void printArrayDouble(double[] mas, String message, String format) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.printf(format, mas[i]);
		}

		System.out.println();
	}

	public static boolean checkPrimeNumber(int n) {

		if (n <= 1) {
			return false;
		}
		// Перебор до корня из проверяемого числа
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Даны действительные числа а1, а2, ..., аn.
 * Поменять местами наибольший и наименьший элементы.
 */

public class Task04 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений последовательности

		n = intFromScanner("Введите размерность последовательности", true);

		double[] mas = new double[n];

		range = intFromScanner("Введите диапазон значений (± целое число)", false);

		genArrayDouble(mas, range);

		printArray(mas, "Исходная последовательность", "%.03f; ");

		swapMinMaxArray(mas);

		printArray(mas, "Итоговая последовательность", "%.03f; ");

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

	public static void printArray(double[] mas, String message, String format) {
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.printf(format, mas[i]);
		}

		System.out.println();
	}

	public static void swapMinMaxArray(double[] mas) {
		if (mas == null) {
			return;
		}
		double min = mas[0];
		double max = mas[0];

		int minI = 0;
		int maxI = 0;

		for (int i = 1; i < mas.length; i++) {
			if (mas[i] < min) {
				min = mas[i];
				minI = i;
			}
			if (mas[i] > max) {
				max = mas[i];
				maxI = i;
			}
		}
		mas[minI] = max;
		mas[maxI] = min;
	}
}

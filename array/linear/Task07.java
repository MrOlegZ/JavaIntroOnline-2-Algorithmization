package by.jonline.pr02.array.linear;

import java.util.Random;
import java.util.Scanner;

/* Даны действительные числа a1, a2,..., a2n. Найти
 * max(a1 + a2n, a2 + a2n-1,..., an + an+1).
 */

public class Task07 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений

		n = intFromScanner("Введите размер последовательности (целое число)", true);

		double[] masLong = new double[n * 2];
		double[] masShort = new double[n];

		range = intFromScanner("Введите диапазон значений последовательности (± целое)", false);

		genArrayDouble(masLong, range);
		createSmallArray(masLong, masShort);

		printArray(masLong, "Исходная последовательность", "%.03f; ");
		printArray(masShort, "Итоговая последовательность", "%.03f; ");

		System.out.printf("Максимальный элемент итоговой последовательности равен %.03f", maxElement(masShort));
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

	public static void createSmallArray(double[] masLong, double[] masShort) {
		if ((masLong == null) || (masShort == null)) {
			return;
		}
		for (int i = 0; i < masShort.length; i++) {
			masShort[i] = masLong[i] + masLong[masLong.length - 1 - i];
		}
	}

	public static double maxElement(double[] mas) {
		if (mas == null) {
			return 0;
		}

		double max = mas[0];
		for (int i = 1; i < mas.length; i++) {
			if (max <= mas[i]) {
				max = mas[i];
			}
		}
		return max;
	}

	public static void printArray(double[] mas, String message, String format) {
		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.printf(format, mas[i]);
		}

		System.out.println();
	}

}

package by.jonline.pr02.array.sorting;

import java.util.Random;
import java.util.Scanner;

/* Сортировка Шелла.
 * Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и a(i+1).
 * Если ai <= a(i+1), то продвигаются на один элемент вперед.
 * Если ai > a(i+1), то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */

public class Task06 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int range; // Диапазон значений массива

		n = intFromScanner("Введите размер массива", "Positive");
		range = intFromScanner("Введите диапазон значений массива", "");

		int[] mas = new int[n];

		genArrayInt(mas, range);
		printArrayInt(mas, "Исходный массив:");

		shellSort(mas);
		printArrayInt(mas, "Отсортированный массив:");

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

	public static void genArrayInt(int[] mas, int range) {
		if (mas == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {
			mas[i] = rand.nextInt(2 * Math.abs(range) + 1) - Math.abs(range);
		}
	}

	public static void printArrayInt(int[] mas, String message) {
		if (mas == null) {
			return;
		}

		System.out.println(message);

		for (int i = 0; i < mas.length; i++) {
			System.out.print(mas[i] + ";\t");
		}

		System.out.println();
	}

	public static void shellSort(int[] mas) {
		if (mas == null) {
			return;
		}

		int step = mas.length / 2; // Реализована сортировка Шеллаа при длине промежутков di = d(i-1) / 2
		// Наилучший результат достигается при выборе промежутков из множества
		// [1, 4, 10, 23, 57, 132, 301, 701, 1750]
		int temp;

		while (step > 0) {
			for (int i = step; i < mas.length; i++) {
				for (int j = i - step; j >= 0 && mas[j] > mas[j + step]; j -= step) {
					temp = mas[j];
					mas[j] = mas[j + step];
					mas[j + step] = temp;
				}
			}

			step /= 2; // См. примечание выше
		}

	}
}

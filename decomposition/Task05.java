package by.jonline.pr02.decomposition;

import java.util.Random;
import java.util.Scanner;

/* Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива,
 * но больше всех других элементов)
 * 
 */

public class Task05 {

	public static void main(String[] args) {

		int n; // Размерность массива
		int range; // Диапазон значений массива

		n = intFromScanner("Введите размерность массива", "Positive");
		range = intFromScanner("Введите диапазон значений", "Positive");

		int[] a = new int[n];

		genArray(a, range);
		printArrayInt(a, "Исходный массив:");
		findSecondLargest(a);

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

	public static void genArray(int[] mas, int range) {
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

		for (int i : mas) {
			System.out.printf("%d;\t", i);
		}
		System.out.println();
	}

	public static int maxElement(int[] mas) {
		if (mas == null) {
			return 0;
		}

		int max = mas[0];

		for (int i : mas) {
			max = i > max ? i : max;
		}
		return max;
	}

	public static void findSecondLargest(int[] mas) {
		if (mas == null) {
			return;
		}

		int max; // Максимальный элемент
		int secondLargest; // Второй по величине элемент

		max = maxElement(mas);
		secondLargest = max;

		if (mas.length >= 3) {

			int temp = 0;
			boolean decide = false;

			// Определяем первый элемент, отличный от максимального
			while (!decide && (temp < mas.length)) {
				if (mas[temp] != max) {
					secondLargest = mas[temp];
					decide = true;
				} else {
					temp++;
				}
			}

			if (secondLargest != max) {
				for (int i = 0; i < mas.length; i++) {
					if ((mas[i] > secondLargest) && (mas[i] < max)) {
						secondLargest = mas[i];
					}
				}
				System.out.printf("Второе по величине число массива: %d\n", secondLargest);
			} else {
				System.out.println("Все элементы массива равны");
			}

		} else if (mas.length == 2) {
			if (mas[0] < mas[1]) {
				secondLargest = mas[0];
				System.out.printf("Второе по величине число равно %d\n", secondLargest);
			} else if (mas[0] > mas[1]) {
				secondLargest = mas[1];
				System.out.printf("Второе по величине число равно %d\n", secondLargest);
			} else {
				System.out.println("Оба элемента равны между собой");
			}
		} else {
			System.out.println("В массиве недостаточно элементов для определения значения второго по величине");
		}
	}
}

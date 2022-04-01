package by.jonline.pr02.array.sorting;

import java.util.Random;
import java.util.Scanner;

/* Сортировка вставками.
 * Дана последовательность чисел a1, a2, ..., an.
 * Требуется переставить числа в порядке возрастания.
 * Делается это следующим образом. Пусть a1, a2, ..., ai - упорядоченная последовательность,
 * т.е. a1 <= a2 <= ... <= ai. Берется следующее число a(i+1) и вставляется в последовательность так,
 * чтобы новая последовательность была тоже возрастающей. Процесс проводится до тех пор, пока все
 * элементы от i+1 до n не будут перебраны.
 * Примечание. Месть помещения очередного элемента в отсортированную часть производить
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class Task05 {

	public static void main(String[] args) {

		int n; // Размерность последовательности
		int range; // Диапазон значений последовательности

		n = intFromScanner("Введите размер последовательности", "Positive");
		range = intFromScanner("Введите диапазон значений последовательности", "");

//		int[] sequenceA = new int[] { 8, -69, 55, -81, 13 };
		int[] sequenceA = new int[n];

		genArrayInt(sequenceA, range);
		printArrayInt(sequenceA, "Исходная последовательность:");

		insertionSort(sequenceA);
		printArrayInt(sequenceA, "Отсортированная последовательность:");

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

	public static void insertionSort(int[] mas) {
		if (mas == null) {
			return;
		}

		int position; // номер позиции, на которую надо вставить отсортированный элемент
		int temp;

		for (int i = 1; i < mas.length; i++) {
			position = binarySearchInsert(mas, i, mas[i]);

			// циклический сдвиг элементов массива вправо от номера позиции и вставка
			// сортируемого элемента
			temp = mas[i];
			for (int j = i - 1; j >= position; j--) {
				mas[j + 1] = mas[j];
			}
			mas[position] = temp;

		}
	}

	public static int binarySearchInsert(int[] mas, int rightBound, int number) {
		if (mas == null) {
			return 0;
		}

		int leftBound = 0;
		int position = 0;
		int middle;
		boolean positionFound = false;

		while (!positionFound) {
			middle = leftBound + (rightBound - leftBound) / 2;
			// равносильно (rightBound + leftBound) / 2, но без
			// возможного переполнения
			// еще один возможный вариант: middle = (leftBound + rightBound) >>> 1;

			if (leftBound <= rightBound) {
				if (mas[middle] < number) {
					leftBound = middle + 1;
					position = leftBound;
				} else if (mas[middle] > number) {
					rightBound = middle - 1;
					position = rightBound;
				} else if (mas[middle] == number) {
					position = middle;
					positionFound = true;
				}
			} else {
				position = position == -1 ? 0 : middle;
				// position = -1 соответствует тому, что искомого элемента (number) нет в
				// массиве mas[], поэтому найденную среднюю позицию и берем в качестве места
				// вставки
				positionFound = true;
			}
		}

		return position;
	}
}

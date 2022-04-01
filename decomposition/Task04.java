package by.jonline.pr02.decomposition;

import java.util.Random;
import java.util.Scanner;

/*
 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие,
 * между какими из пар точек самое большое расстояние.
 * Указание. Координаты точек занести в массив.
 */

public class Task04 {

	public static void main(String[] args) {

		int n; // Количество точек
		int range; // Диапазон значений координат точек

		n = intFromScanner("Введите колчиество точек", "Positive");
		range = intFromScanner("Введите диапазон значений координат точек", "Positive");

		int[][] pointArray = new int[2][n]; // Массив точек. [0][] - координаты X; [1][] - координаты Y;

//		int[][] pointArray = new int[][] {{-10, 0, -10, -10}, {3, 0, 3, 3}};
//		n = 4;
		
		// Количество разных расстояний k при количестве точек n определяется по
		// формуле: k = n*(n-1)/2. Т.е. фактически все разные расстояния можно
		// представить в виде матрицы размером [n x n], в которой все элементы,
		// находящиеся НА и НИЖЕ главной диагонали равны 0.
		// Либо в виде матрицы размером [n-1 x n-1], в которой элементы НИЖЕ главной
		// диагонали равны 0.
		// Для оценки расстояния между точками нет необходимости вычислять sqrt,
		// т.к. если подкоренное выражение больше, то и само значение корня больше
		// Квадрат искомого расстояния между точками Pi(Xi,Yi) и Pj(Xj, Yj) будет
		// находится в ячейке D[i, j-1]

		long[][] squareDistanceArray = new long[n - 1][n - 1]; // Массив квадратов расстояний

		genPointArray(pointArray, range);
		printPointArray(pointArray, "Заданные точки");
		findSquareDistance(pointArray, squareDistanceArray);
		printMaxDistance(squareDistanceArray);
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

	public static void genPointArray(int[][] pointArray, int range) {
		if ((pointArray == null) || (pointArray.length >= 3)) {
			return;
		}

		Random rand = new Random();

		// Генерация случайных значений координат точек
		for (int i = 0; i < pointArray[0].length; i++) {
			for (int j = 0; j < pointArray.length; j++) {
				pointArray[j][i] = rand.nextInt(2 * Math.abs(range) + 1) - Math.abs(range);
			}
		}
	}

	public static void printPointArray(int[][] pointArray, String message) {
		if ((pointArray == null) || (pointArray.length >= 3)) {
			return;
		}
		System.out.println(message);

		for (int i = 0; i < pointArray[0].length; i++) {
			System.out.printf("(%d; %d)   ", pointArray[0][i], pointArray[1][i]);
		}
		System.out.println();
	}

	public static long estimateDistance(int coordX1, int coordY1, int coordX2, int coordY2) {

		long result = 0L;

		result = (long) Math.pow(coordX2 - coordX1, 2) + (long) Math.pow(coordY2 - coordY1, 2);

		return result;
	}

	public static void findSquareDistance(int[][] pointArray, long[][] squareDistanceArray) {
		if ((pointArray == null) || (squareDistanceArray == null) || (pointArray.length >= 3)) {
			return;
		}

		for (int i = 0; i < squareDistanceArray.length; i++) {
			for (int j = 0; j < squareDistanceArray[i].length; j++) {
				if (j >= i) {
					squareDistanceArray[i][j] = estimateDistance(pointArray[0][i], pointArray[1][i],
							pointArray[0][j + 1], pointArray[1][j + 1]);
				} else {
					squareDistanceArray[i][j] = 0L;
				}
			}
		}
	}

	public static void printMaxDistance(long[][] squareDistanceArray) {
		if (squareDistanceArray == null) {
			return;
		}

		long max = 0L;
		int posMaxI = 0; // Номер строки ячейки с максимальным значением
		int posMaxJ = 0; // Номер столбца ячейки с максимальным значением
		int countMax = 1; // Количество максимальных расстояний

		// Находим максимальное значение в матрице квадратов расстояний
		// либо определяем количество максимальных расстояний
		for (int i = 0; i < squareDistanceArray.length; i++) {
			for (int j = i; j < squareDistanceArray[i].length; j++) {
				if (squareDistanceArray[i][j] > max) {
					max = squareDistanceArray[i][j];
					posMaxI = i;
					posMaxJ = j;
					countMax = 1;
				} else if (squareDistanceArray[i][j] == max) {
					countMax++;
				}
			}
		}

		if (countMax == 1) {
			System.out.printf("Максимальное расстояние между %d и %d точками\n", posMaxI, posMaxJ + 1);
			// Добавляем 1 к posMaxJ, т.к. на главной диагонали находятся квадраты
			// расстояний, а НЕ
			// квадрат расстояния между "самой собой" (аналогия с таблицей результатов
			// соревнований, где на главной диагонали заштрихованные квадраты).
			// 1 можно было бы не добавлять, если бы массив квадратов расстояний
			// был бы [n x n], а на главной диагонали стояли бы 0
		} else {
			System.out.printf("Максимальных расстояний - %d:\n", countMax);
			// Начинаем поиск всех максимальных значений (начинаем с первого максимального)
			for (int i = posMaxI, c = countMax; i < squareDistanceArray.length; i++) {
				for (int j = posMaxJ; j < squareDistanceArray[i].length; j++) {
					if ((c >= 1) && (squareDistanceArray[i][j] == max)) {
						System.out.printf("Между %d и %d точкой\n", i, j + 1);
						c--;
					} else if (c == 0) {
						break;
					}
				}
				if (c == 0) {
					break;
				}
			}
		}
	}

}

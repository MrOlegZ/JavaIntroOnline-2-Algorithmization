package by.jonline.pr02.decomposition;

import java.util.Scanner;

/* Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод (методы)
 * вычисления его площади, если угол между сторонами длиной X и Y - прямой.
 */

public class Task09 {

	public static void main(String[] args) {

		int x;
		int y;
		int z;
		int t;
		double square;

		x = intFromScanner("Введите сторону X четырехугольника", "Positive");
		y = intFromScanner("Введите сторону Y четырехугольника", "Positive");
		z = intFromScanner("Введите сторону Z четырехугольника", "Positive");
		t = intFromScanner("Введите сторону T четырехугольника", "Positive");

		square = findQuadrangleSquare(x, y, z, t);
		if (square != -1.0) {
			System.out.printf("Площадь выпуклого четырехугольника равна %f\n", square);
		} else {
			System.out.printf("Четырехугольника со сторонами %d, %d, %d, %d не существует", x, y, z, t);
		}

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

	public static boolean isQuadrangleExist(int x, int y, int z, int t) {

		double hypotenuse;
		boolean result;

		hypotenuse = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
		if ((z + t >= hypotenuse) && (t + hypotenuse >= z) && (z + hypotenuse >= t)) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	public static double findQuadrangleSquare(int x, int y, int z, int t) {

		// Алгоритм.
		// 1. Проверка существования четырехугольника
		// 2. Разбивка четырехугольника на 2 треугольника. Т.к. по условиям задачи один
		// угол равен 90°, то
		// одна из сторон составляющего треугольника равна гипотенузе между x и y
		// 3. Найти площадь каждого из треугольников (прямоугольного и произвольного по
		// формуле Герона)
		// 4. Просуммировать площади

		double square; // Площадь

		if (isQuadrangleExist(x, y, z, t)) {
			double xy; // Новая сторона разбитого треугольника
			double p; // Полупериметр для формулы Герона
			double squareRectTriangle; // Площадь прямоугольного треугольника
			double squareGeron; // Площадь по формуле Герона

			xy = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
			p = (double) (xy + z + t) / 2.0;
			squareRectTriangle = (double) (x * y) / 2.0;
			squareGeron = Math.sqrt(p * (p - xy) * (p - z) * (p - t));
			square = squareRectTriangle + squareGeron;
		} else {
			square = -1.0;
		}
		return square;
	}
}

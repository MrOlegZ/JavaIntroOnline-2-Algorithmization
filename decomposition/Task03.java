package by.jonline.pr02.decomposition;

import java.util.Scanner;

/*
 * Вычислить площадь правильного шестиугольника со стороной а,
 * используя метод вычисления площади треугольника
 */

public class Task03 {

	public static void main(String[] args) {

		double a;
		double s;

		a = doubleFromKeyboard("Enter hexagon's side a");
		s = 6.0 * sTriangle(a, a * (Math.sqrt(3.0) / 2.0));
		
		System.out.println("Square of hexagon with side " + a + " is " + s);
	}

	public static double doubleFromKeyboard(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print(message + " >> ");
		while (!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.print(message + " >> ");
		}
		return sc.nextDouble();
	}

	public static double sTriangle(double a, double h) {

		return (1.0 / 2.0) * a * h;
	}

}

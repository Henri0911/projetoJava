package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Triangulo;

public class ProgramaTriangulo {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Triangulo x, y;
		x = new Triangulo();
		y = new Triangulo();

		System.out.println("Insira a medida do triângulo X: ");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();

		System.out.println("Insira a medida do triângulo Y: ");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();

		double areaX = x.area();
		double areaY = y.area();
		
		System.out.printf("Área do Triângulo X: %.4f\n", areaX);
		System.out.printf("Área do Triângulo Y: %.4f\n", areaY);
		
		if(areaX > areaY) {
			System.out.println("Maior Área X");
		}
		else {
			System.out.println("Maior Área Y");
		}

		sc.close();
	}

}

package entidade;

public class Triangulo {
	
	//Atributos
	public double a;
	public double b;
	public double c;

	
	
	//metodo
	public double area() {
		double p = (a + b + c) / 2.0;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c)); /*double resultado*/
		//return resultado;
		
	}
}

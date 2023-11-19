package meusProjetos;

import java.util.Random;

public class GeradorNumeros {

	public static void main(String[] args) {
		
		int[] numerosSorteados = new int[6];
		
		Random random = new Random();
		
		for(int i = 0; i < 6; i++) {
			int numeroAleatorio;
			do {
				numeroAleatorio = random.nextInt(60) + 1; //Gera numero de 1 a 60
			} while (contemNumero(numerosSorteados, numeroAleatorio));
			
			numerosSorteados[i] = numeroAleatorio;
		}
		
		System.out.println("Números sorteados: ");
		for(int numero : numerosSorteados) {
			System.out.println(numero + " ");
		}
	}
	
	private static boolean contemNumero(int[] array, int numero) {
		for(int i : array) {
			if (i == numero) {
				return true;
			}
		}
		return false;
	}
	

}

package cpf;

import java.util.Scanner;

public class ValidadorCPF {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        String cpf = sc.next() ; // Substitua pelo CPF que deseja validar "123.456.789-09"
        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
        }
    }

    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular e verificar os dígitos verificadores
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }

        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : (11 - resto);

        if (digito1 != digitos[9]) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }

        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : (11 - resto);

        return digito2 == digitos[10];
    }
}


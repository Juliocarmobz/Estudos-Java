package br.com.vainaweb;

import java.util.Random;
import java.util.Scanner;

public class MegaSena {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		
		int vetorNumeros = 7;
		int[] numeros = new int[vetorNumeros];
		int[] numerosSorteados = new int[vetorNumeros];
		
		System.out.println("MEGA-SENA JAVA \nLOTERIAS VNW");
		
		for (int i = 0; i < vetorNumeros; i++) {
			System.out.println("Escolha o " + (i+1) + "o número");
			
			while (!sc.hasNextInt()) {
				System.out.println("Numero inválido, digite um número inteiro");
				sc.next();
			}
			
			int numeroEscolhido = sc.nextInt();
			
			if (numeroEscolhido < 0 || numeroEscolhido > 100) {
			     System.out.println("Número inválido, digite um número entre 0 e 100");
			     i--;
			} else if (numeroEscolhido(numeros, numeroEscolhido)) {
				System.out.println("Você já escolheu esse número, digite outro número diferente ");
				i--;
			} else {
				numeros[i] = numeroEscolhido;
			}	 
		}
		
		for (int i = 0; i < vetorNumeros; i++) {
			numerosSorteados[i] = random.nextInt(101);
		}
		
		
		System.out.println("Números sorteados: ");
		for (int num : numerosSorteados) {
			System.out.print(num + "  ");
		}
		System.out.println();
		
		
		System.out.println("Seus números: ");
		for (int num : numeros) {
			System.out.print(num + "  ");
		}
		System.out.println();
		
		
		int numerosCorretos = 0;
		for (int i = 0; i < vetorNumeros; i++) {
			for (int j = 0; j < vetorNumeros; j++) {
				if (numeros[i] == numerosSorteados[j]) {
					numerosCorretos++;
					break;
				}
			}
		}
			
		
		if (numerosCorretos < 5) {
			System.out.println("Não foi dessa vez... Tente na próxima");
		} else if (numerosCorretos == 5) {
			System.out.println("Parabéns! Você recebeu o prêmio de 10 mil Reais!!!");
		} else if (numerosCorretos == 6){
			System.out.println("Parabéns! Você recebeu o prêmio de 50 mil Reais!!!");
		} else {
			System.out.println("Parabéns! Você recebeu o prêmio de 2000 mil Reais!!!");
		}
		
		
		
		sc.close();
	}
	
	//verifica se o número escolhido está repetido (método auxiliar)
	public static boolean numeroEscolhido(int[] array, int numero) {
		for (int num: array) {
			if (num == numero) {
				return true;
			}
		}
		return false;
	}

}

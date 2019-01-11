package br.com.guacom.data.structure.teste;

import java.util.Scanner;

public class valor {

	public static void main(String[] args) {
		int[] num = new int[3];
		int aux = 0;
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Insira o " + (i + 1) + "° número:");
			aux = input.nextInt();
			if (i > 0) {
				for (int j = 0; j < i; j++) {
					while (aux == num[j]) {
						System.out.println("Valor repetido.");
						aux = input.nextInt();
					}
				}
			}
			num[i] = aux;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = num.length - 1; j > 0; j--) {
				if (num[j] > num[j - 1]) {
					aux = num[j];
					num[j] = num[j - 1];
					num[j - 1] = aux;
				}
			}
		}

		for (int i = 0; i < 3; i++)
			System.out.println(num[i]);
	}
}
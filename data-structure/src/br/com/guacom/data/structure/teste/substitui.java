package br.com.guacom.data.structure.teste;

import java.util.Scanner;

public class substitui {
	
	public static void main(String[] args) {
		int a = 0, b = 0, aux = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o 1° e o 2° valor");
		a = input.nextInt();
		b = input.nextInt();
		System.out.println("Valor de a: " + a + ", Valor de b: " + b);
		
		aux = a;
		a = b;
		b = aux;
		
		System.out.println("Valor de a: " + a + ", Valor de b: " + b);
	}
}

package br.com.guacom.data.structure.teste;

import java.util.Scanner;

public class carro {
	
	public static void main(String[] args) {
		
		final double percen = 0.28;
		final double tax = 0.45;
		double carroV;
		
		System.out.println("Insira o valor do carro");
		carroV = new Scanner(System.in).nextDouble();
		
		double total = carroV + (carroV * percen * tax);
		
		System.out.println("Valor total R$" + total);
	}
}

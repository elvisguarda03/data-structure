package br.com.guacom.data.structure.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basquete {
	
	public static void main(String[] args) {
		List<Jogador> jogadores = new ArrayList<>(12);
		Scanner input = new Scanner(System.in);
		Jogador maior = null;
		double avg = 0;
		
		for(int i = 0; i < 5; i++) {
			input.nextLine();
			System.out.println("Insira o nome do jogador");
			String name = input.nextLine();
			
			System.out.println("Insira a altura");
			double altura = input.nextDouble();
			
			jogadores.add(new Jogador(name, altura));
			if(i == 0)
				maior = jogadores.get(0);
			else if(maior.getAltura() < jogadores.get(i).getAltura())
				maior = jogadores.get(i);
		}
		
		for(Jogador j : jogadores) {
			avg += j.getAltura();
		}
		avg /= jogadores.size();
	
		System.out.println("Média: " + avg);
		for(Jogador j : jogadores) {
			if(j.getAltura() > avg)
				System.out.println("Jogador acima da média - " + j.status());
		}
		System.out.println("Maior jogador\n" + maior.status());
	}
}

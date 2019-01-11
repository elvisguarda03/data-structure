package br.com.guacom.data.structure.teste;

import br.com.guacom.data.structure.model.ArrayList;
import br.com.guacom.data.structure.model.LinkedList;

public class Teste {
	public static void main(String[] args) {

		ArrayList<String> vetor = new ArrayList<String>();
		LinkedList<String> lista = new LinkedList<String>();
		int numeroDeElementos = 100000;
		// ADICIONADO NO COMEÇO
		long inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos; i++) {
			vetor.add(0, "" + i);
		}
		long fim = System.currentTimeMillis();
		System.out.println("Vetor adiciona no começo: " + (fim - inicio) / 1000.0);
		inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos; i++) {
			lista.add(0, "" + i);
		}
		fim = System.currentTimeMillis();
		System.out.println("Lista Ligada adiciona no começo: " + (fim - inicio) / 1000.0);
		// PERCORRENDO
		inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos; i++) {
			vetor.get(i);
		}
		fim = System.currentTimeMillis();
		System.out.println("Vetor percorrendo: " + (fim - inicio) / 1000.0);

		inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos; i++) {
			lista.get(i);
		}
		fim = System.currentTimeMillis();
		System.out.println("Lista Ligada percorrendo: " + (fim - inicio) / 1000.0);
		// REMOVENDO DO COMEÇO

		inicio = System.currentTimeMillis();
		lista.remove(lista.size() / 2 - 1);
		fim = System.currentTimeMillis();
		System.out.println("Lista Ligada remove do meio: " + (fim - inicio) / 1000.0);

		inicio = System.currentTimeMillis();
		vetor.remove(vetor.size() / 2 - 1);
		fim = System.currentTimeMillis();
		System.out.println("Vetor remove do meio: " + (fim - inicio) / 1000.0);

		inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos - 1; i++) {
			vetor.remove(0);
		}
		fim = System.currentTimeMillis();
		System.out.println("Vetor remove do começo: " + (fim - inicio) / 1000.0);
		inicio = System.currentTimeMillis();
		for (int i = 0; i < numeroDeElementos - 1; i++) {
			lista.remove(0);
		}
		fim = System.currentTimeMillis();
		System.out.println("Lista Ligada remove do começo: " + (fim - inicio) / 1000.0);
	}
}
package br.com.guacom.data.structure.teste;

import br.com.guacom.data.structure.model.LinkedList;

public class TesteDoublyLinked {
	
	public static void main(String[] args) {
		LinkedList<String> lista = new LinkedList<>();
		
		System.out.println(lista);
		
		lista.addFirst("Elvis");
		System.out.println(lista);
		
		lista.addLast("Bruna");
		System.out.println(lista);
		
		lista.addLast("João");
		System.out.println(lista);
	
		lista.add(1, "Carlos");
		System.out.println(lista);
		System.out.println("Lista " + (lista.isEmpty() ? "vázia" : "não está vázia"));
		System.out.println("Item " + (lista.contains("Elvis") ? "existe" : "não existe"));
		System.out.println(lista.indexOf("Carlos"));
		
		lista.addLast("Elvis");
		lista.add(lista.size() - 1, "Bianca");
		System.out.println(lista.lastIndexOf("Bruna"));
		lista.clear();
		System.out.println(lista);
	}
}
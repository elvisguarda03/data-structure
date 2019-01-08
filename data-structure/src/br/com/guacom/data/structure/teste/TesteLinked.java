package br.com.guacom.data.structure.teste;

import br.com.guacom.data.structure.model.ArrayList;
import br.com.guacom.data.structure.model.LinkedList;

public class TesteLinked {

	public static void main(String[] args) {
		LinkedList<String> string = new LinkedList<>();
		ArrayList<String> list = new ArrayList<>();
		long ini = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			string.addLast("Elvis");
		}
		long fim = System.currentTimeMillis();
		System.out.println("Inserção LinkedList - " + (fim - ini) );
		
		ini = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			list.add("Elvis");
		}
		fim = System.currentTimeMillis();
		System.out.println("Inserção ArrayList - " + (fim - ini) );
		
		ini = System.currentTimeMillis();
		string.add( (string.size() / 2) - 1, "B");
		fim = System.currentTimeMillis();
		System.out.println("Inserção no meio LinkedList - " + (fim - ini) );
		
		ini = System.currentTimeMillis();
		string.add( (list.size() / 2) - 1, "B");
		fim = System.currentTimeMillis();
		System.out.println("Inserção no meio ArrayList - " + (fim - ini) );
		
		ini = System.currentTimeMillis();
		string.remove(list.size() / 2 - 1);
		fim = System.currentTimeMillis();
		System.out.println("Remoção de um elemento no meio LinkedList - " + (fim - ini));
		
		ini = System.currentTimeMillis();
		list.remove(list.size() / 2 - 1);
		fim = System.currentTimeMillis();
		System.out.println("Remoção de um elemento no meio ArrayList - " + (fim - ini));
		
		ini = System.currentTimeMillis();
		list.get(list.size() / 2 -1);
		fim = System.currentTimeMillis();
		System.out.println("Pegando um elemento do meio - LinkedList - " + (fim - ini));
		
		
		ini = System.currentTimeMillis();
		string.get(string.size() / 2 -1);
		fim = System.currentTimeMillis();
		System.out.println("Pegando um elemento do meio - ArrayList - " + (fim - ini));
		
//		System.out.println(string);
//		string.add(0, "Messias");
//		System.out.println(string);
//		string.addFirst("Elvis");
//		System.out.println(string);
//		string.add(1, "Eloah");
//		System.out.println(string);
//		string.addLast("Bianca");
//		System.out.println(string);
//		string.addFirst("Marcia");
//		System.out.println(string);
//		System.out.println(string.equals("Bianca"));
//		System.out.println("-----------------------");
//		string.addFirst("Marcia");
//		while (string.hasNext())
//			System.out.println(string.get());
//		System.out.println(string.size());
//		System.out.println("------------");
//		
//		System.out.println("último indice - " + string.lastIndexOf("Marcia"));
//		
//		while(string.hasNext())
//			System.out.println(string.get());
//		System.out.println(string.size());
//		string.clear();
//		System.out.println(string.size());
//		System.out.println(string);
	}
}

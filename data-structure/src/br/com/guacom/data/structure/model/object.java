package br.com.guacom.data.structure.model;

public class object {
	public static void main(String[] args) {
		
		for(int i = 0; i > 9; i--) {
			for(int j = i; j < i; j++) {
				System.out.print("*");
			}
			if(i != 0)
				System.out.println();
		}
	}
}

package br.com.guacom.data.structure.teste;

public class Jogador {
	private String name;
	private double altura;
	
	public Jogador(String name, double altura) {
		this.name = name;
		this.altura = altura;
	}
	
	public String getName() {
		return name;
	}
	public double getAltura() {
		return altura;
	}
	
	public String status() {
		return String.format("Nome:%s - Altura:%.2f", name, altura);
	}
}

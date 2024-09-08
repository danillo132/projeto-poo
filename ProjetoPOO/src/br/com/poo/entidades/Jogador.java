package br.com.poo.entidades;

import java.util.List;
import java.util.Scanner;

public class Jogador {

	
	private String nomeJogador;
	private List<Peça> peças;
	private int numPeçasAtivas;
	
	public Jogador() {
	}
	
	public Jogador(String nomeJogador, List<Peça> peças) {
		this.nomeJogador = nomeJogador;
		this.peças = peças;
		this.numPeçasAtivas = peças.size();
	}
	
	
	public String informaJogada() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a jogada ou 'parar' para interromper: ");
		return scanner.nextLine();
	}
	
	
	public String pecasCapturadas() {
		StringBuilder pecasCapturadas = new StringBuilder();
		if(peças != null) {
			for (int i =0; i < peças.size(); i++) {
				Peça peça = peças.get(i);
				if(!peça.isInGame()) {
					pecasCapturadas.append(peça.getTipo());
					if(i < peças.size() -1) {
						pecasCapturadas.append(" ");
					}
				}
			}
		}
		
		return pecasCapturadas.toString();
	}
	
	public List<Peça> getPeças() {
		return peças;
	}
	
}

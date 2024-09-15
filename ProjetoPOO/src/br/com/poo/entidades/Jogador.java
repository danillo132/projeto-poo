package br.com.poo.entidades;

import java.util.List;
import java.util.Scanner;

/**
 * Classe que representa os jogadores
 */
public class Jogador {

	private String nomeJogador;
	private List<Peça> peças;
	private int numPeçasAtivas;

	/**
	 * Construtor que define o nome do jogador e suas peças
	 * 
	 * @param nomeJogador Nome do jogador
	 * @param peças       peças do jogador
	 */
	public Jogador(String nomeJogador, List<Peça> peças) {
		this.nomeJogador = nomeJogador;
		this.peças = peças;
		this.numPeçasAtivas = peças.size();
	}

	/**
	 * Método responsável por receber a entrada da jogada sendo os dados a casa
	 * inicial e a casa final
	 * 
	 * @return Retorna os dados lidos da entrada
	 */
	public String informaJogada() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a jogada ou 'parar' para interromper: ");
		return scanner.nextLine();
	}

	/**
	 * Método que retorna quais peças do jogador foram capturadas
	 * 
	 * @return retorna o tipo da peça separada por espaço
	 */
	public String pecasCapturadas() {
		StringBuilder pecasCapturadas = new StringBuilder();
		if (peças != null) {
			for (int i = 0; i < peças.size(); i++) {
				Peça peça = peças.get(i);
				if (!peça.isInGame()) {
					pecasCapturadas.append(peça.getTipo());
					if (i < peças.size() - 1) {
						pecasCapturadas.append(" ");
					}
				}
			}
		}

		return pecasCapturadas.toString();
	}

	/**
	 * Método que retorna a lista de peças do jogador
	 * @return Lista contendo as peças do jogador
	 */
	public List<Peça> getPeças() {
		return peças;
	}

	/**
	 * Método que retorna o nome do jogador
	 * @return nome do jogador 
	 */
	public String getNomeJogador() {
		return nomeJogador;
	}

	public void peçasDe() {
		System.out.println("Nome: " + nomeJogador);
		System.out.println("Peças ativas: " + numPeçasAtivas);
		for (int i = 0; i < peças.size(); i++) {
			System.out.print(peças.get(i).desenho() + " ");
		}
		System.err.print("\n\n");
	}

}

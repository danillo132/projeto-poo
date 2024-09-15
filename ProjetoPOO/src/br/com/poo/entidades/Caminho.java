package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por criar o caminho fornecido pela peça em sequência de casas
 */
public class Caminho {

	private Casa posicaoInicial;
	private Casa posicaoFinal;
	private List<Casa> sequenciaDeCasas;

	/**
	 * Construtor que recebe a casa inicial e a casa final do caminho a ser criado
	 * @param posicaoInicial casa inicial
	 * @param posicaoFinal casa final 
	 */
	public Caminho(Casa posicaoInicial, Casa posicaoFinal) {
		sequenciaDeCasas = new ArrayList<>();

		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
		this.sequenciaDeCasas.add(posicaoInicial);
		this.sequenciaDeCasas.add(posicaoFinal);

	}

	/**
	 * Método que transforma o caminho fornecido da peça na casa inicial em uma sequência de casas até a casa final
	 * @param tabuleiro 
	 */
	public void populaCaminho(Tabuleiro tabuleiro) {
		String caminhoDaPeca = posicaoInicial.getPeça().caminho(posicaoInicial.getLinha(), posicaoInicial.getColuna(),
				posicaoFinal.getLinha(), posicaoFinal.getColuna());
		if (!caminhoDaPeca.isEmpty()) {
			String[] partesCaminho = caminhoDaPeca.split("");
			for (int i = 0; i < partesCaminho.length; i += 2) {
				if (partesCaminho[i] != null && partesCaminho[i + 1] != null) {
					int linha = Integer.parseInt(partesCaminho[i]);
					int coluna = partesCaminho[i + 1].charAt(0) - 'a';
					if (tabuleiro.getTabuleiro()[linha][coluna] != null) {
						Casa casaNoTabuleiro = tabuleiro.getCasa(linha, coluna);

//						Casa novaCasa = new Casa(casaNoTabuleiro.getCor(), linha,(char) (coluna + 'a'), casaNoTabuleiro.isOcupada(),
//								casaNoTabuleiro.getPeça());
						if(!sequenciaDeCasas.contains(casaNoTabuleiro)) {
							sequenciaDeCasas.add(casaNoTabuleiro);
						}
						
					}

				}
			}
		}
	}

	/**
	 * Método que verifica se o caminho fornecido pela peça está livre
	 * @return retorna true se estiver livre e false caso tenha uma peça na casa
	 */
	public boolean estaLivre() {

		if (sequenciaDeCasas != null) {

			for (int i = 2; i < sequenciaDeCasas.size(); i++) {
				if (sequenciaDeCasas.get(i).isOcupada()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Método que retorna a casa inicial 
	 * @return Casa inicial
	 */
	public Casa casaInicial() {
		if (sequenciaDeCasas != null) {
			return sequenciaDeCasas.get(0);
		}
		return null;
	}

	/**
	 * Método que retorna a casa final
	 * @return Casa final
	 */
	public Casa casaFinal() {
		if (sequenciaDeCasas != null) {
			return sequenciaDeCasas.get(1);
		}
		return null;
	}

}

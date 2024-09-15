package br.com.poo.entidades;

/**
 * Classe derivada de Peça que representa a peça de xadrez bispo
 */
public class Torre extends Peça {

	/**
	 * Construtor que recebe a cor da peça e faz a chamada ao construtor da classe Base para iniciar os atributos tipo, cor e inGame
	 * @param cor
	 */
	public Torre(String cor) {
		super("T", cor, true);
	}

	/**
	 * Implementação do método desenho que retorna o tipo de peça (torre)
	 */
	@Override
	String desenho() {
		return this.tipo;
	}

	/**
	 * Implementação do método que verifica se o movimento é válido para a torre
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 */
	@Override
	protected boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);

		return (diferencaColuna == 0) ^ (diferencaLinha == 0);
	}

	/**
	 * Implementação do método caminho que chama verificação de movimento válido e monta o caminho com base na posição inicial e final
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 */
	@Override
	protected String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
		if (this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {

			StringBuilder caminho = new StringBuilder();

			if (colunaO < colunaD) {
				for (int i = colunaO; i <= colunaD; i++) {
					caminho.append(linhaO).append((char) i);
				}
			}

			if (linhaO < linhaD) {

				for (int i = linhaO; i <= linhaD; i++) {
					caminho.append(i).append(colunaO);
				}
			}

			return caminho.toString();
		} else {
			return "";
		}
	}
}

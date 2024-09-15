package br.com.poo.entidades;

/**
 * Classe derivada de Peça que representa a peça de xadrez peão
 */
public class Peão extends Peça {

	/**
	 * Construtor que recebe a cor da peça e faz a chamada ao construtor da classe Base para iniciar os atributos tipo, cor e inGame
	 * @param cor
	 */
	public Peão(String cor) {
		super("P", cor, true);
	}

	/**
	 * Implementação do método desenho que retorna o tipo de peça (peão)
	 */
	@Override
	String desenho() {
		return this.tipo;
	}

	/**
	 * Implementação do método que verifica se o movimento é válido para o peão
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 */
	@Override
	protected boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int difColuna = Math.abs(colunaO - colunaD);
		int difLinha = Math.abs(linhaO - linhaD);

		boolean movimentoNormal = (colunaO == colunaD) && (difLinha == 1 || (difLinha == 2 && linhaO == 6) || (difLinha ==2 && linhaO == 1));

		boolean captura = (difColuna == 1 && difLinha == 1);

		boolean sentidoCorreto = (!getCor().equalsIgnoreCase("preta") ? linhaD < linhaO : linhaD > linhaO);

		return (movimentoNormal || captura) && sentidoCorreto;
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
			caminho.append(linhaO).append(colunaO);
			caminho.append(linhaD).append(colunaD);
			return caminho.toString();
		}
		return "";
	}

}

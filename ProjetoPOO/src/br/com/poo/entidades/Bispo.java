package br.com.poo.entidades;

/**
 * Classe derivada de Peça que representa a peça de xadrez bispo
 */
public class Bispo extends Peça {

	/**
	 * Construtor que recebe a cor da peça e faz a chamada ao construtor da classe Base para iniciar os atributos tipo, cor e inGame
	 * @param cor
	 */
	public Bispo(String cor) {
		super("B", cor, true);
	}

	/**
	 * Implementação do método desenho que retorna o tipo de peça (bispo)
	 */
	@Override
	String desenho() {
		return this.tipo;
	}

	/**
	 * Implementação do método que verifica se o movimento é válido para o bispo
     * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 */
	@Override
	protected boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);

		return diferencaColuna == diferencaLinha;
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
			int linhaAtual = linhaO;
			int colunaAtual = colunaO;

			int colunaAtualInt = colunaAtual - 'a';
			int colunaDestinoInt = colunaD - 'a';

			while (linhaAtual != linhaD || colunaAtualInt != colunaDestinoInt) {
				caminho.append(linhaAtual).append((char) (colunaAtualInt + 'a'));

				if (linhaAtual < linhaD)
					linhaAtual++;
				else
					linhaAtual--;

				if (colunaAtualInt < colunaDestinoInt)
					colunaAtualInt++;
				else
					colunaAtualInt--;

				colunaAtual = (char) (colunaAtualInt + 'a');
			}

			caminho.append(linhaD).append(colunaD);

			return caminho.toString();
		} else {
			return "";
		}
	}
	
	

}

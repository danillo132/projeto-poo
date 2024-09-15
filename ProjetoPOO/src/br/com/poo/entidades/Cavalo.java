package br.com.poo.entidades;

/**
 * Classe derivada de Peça que representa a peça de xadrez cavalo
 */
public class Cavalo extends Peça {

	/**
	 * Construtor que recebe a cor da peça e faz a chamada ao construtor da classe Base para iniciar os atributos tipo, cor e inGame
	 * @param cor
	 */
	public Cavalo(String cor) {
		super("C", cor, true);
	}

	/**
	 * Implementação do método desenho que retorna o tipo de peça (cavalo)
	 */
	@Override
	String desenho() {
	return this.tipo;
	}

	/**
	 * Implementação do método que verifica se o movimento é válido para o cavalo
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 */
	@Override
	protected boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);
		return (diferencaColuna == 2 && diferencaLinha == 1) || (diferencaColuna == 1 && diferencaLinha == 2);
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
			int diferencaColuna = Math.abs(colunaO - colunaD);
			int diferencaLinha = Math.abs(linhaO - linhaD);
			if (diferencaColuna == 2 && diferencaLinha == 1) {
				if (colunaO < colunaD) {

					int colunaAtual = colunaO;
					while (colunaAtual <= colunaD) {
						caminho.append(linhaO).append((char) colunaAtual);
						colunaAtual++;
					}
					if (linhaD > linhaO) {
						caminho.append(linhaO + 1).append((char) (colunaAtual - 1));
					} else if (linhaD < linhaO) {
						caminho.append(linhaO - 1).append((char) (colunaAtual - 1));
					}
				}

				if (colunaO > colunaD) {
					int colunaAtual = colunaO;
					while (colunaAtual >= colunaD) {
						caminho.append(linhaO).append((char) colunaAtual);
						colunaAtual--;
					}
					if (linhaD > linhaO) {
						caminho.append(linhaO + 1).append((char) (colunaAtual + 1));
					} else if (linhaD < linhaO) {
						caminho.append(linhaO - 1).append((char) (colunaAtual + 1));
					}
				}

				return caminho.toString();
			}

			if (diferencaColuna == 1 && diferencaLinha == 2) {
				if (linhaO < linhaD) {
					int linhaAtual = linhaO;
					while (linhaAtual <= linhaD) {
						caminho.append(linhaAtual).append(colunaO);
						linhaAtual++;
					}
					if (colunaD > colunaO) {
						caminho.append(linhaO + 2).append((char) (colunaO + 1));
					} else if (colunaD < colunaO) {
						caminho.append(linhaO + 2).append((char) (colunaO - 1));
					}
				}

				if (linhaO > linhaD) {
					int linhaAtual = linhaO;
					while (linhaAtual >= linhaD) {
						caminho.append(linhaAtual).append(colunaO);
						linhaAtual--;
					}
					if (colunaD > colunaO) {
						caminho.append(linhaO - 2).append((char) (colunaD));
					} else if (colunaD < colunaO) {
						caminho.append(linhaO - 2).append((char) (colunaD));
					}
				}
				return caminho.toString();
			}

		} else {
			return "";
		}
		return "";
	}

}

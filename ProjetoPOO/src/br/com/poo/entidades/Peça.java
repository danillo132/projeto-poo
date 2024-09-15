package br.com.poo.entidades;

/**
 * Classe Base abstrata Peça que contém os atributos genéricos das peças do xadrez
 */
public abstract class Peça {

	private String cor;
	protected String tipo;
	private boolean inGame; // Se true, está no jogo. Se false, foi comida;

	public String getTipo() {
		return this.tipo;
	}

	public String getCor() {
		return this.cor;
	}

	public boolean isInGame() {
		return inGame;
	}

	/**
	 *  Construtor que faz a montagem  dos atributos da Peça que foi criada polimorficamente
	 *  
	 * @param tipo   Letra que define o tipo da peça (R,D,B,P,C,T)
	 * @param cor    cor da peça (Branca ou preta)
	 * @param inGame Atributo que diz se a peça ainda está no jogo (false ou true)
	 */
	public Peça(String tipo, String cor, boolean inGame) {
		if (cor.equals("preta")) {
			this.tipo = "\u001B[31m" + tipo + "\u001B[0m";
		} else {
			this.tipo = tipo;
		}

		this.cor = cor;
		this.inGame = inGame;
	}
	
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	/**
	 * Declaração da assinatura do método desenho da peça
	 * 
	 * @return String referente ao tipo da peça e da cor correspondente
	 */
	abstract String desenho();

	/**
	 * Declaração da assinatura do método de movimento válido que verifica se o
	 * movimento passado é permitido de acordo com a peça
	 * 
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 * @return
	 */
	abstract protected boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD);

	/**
	 * Declaração do método responsável pela escrita do caminho válido da peça 
	 * @param linhaO   Linha correspondente a posição inicial
	 * @param colunaO Coluna correspondente a posição inicial 
	 * @param linhaD Linha correspondente a posição final
	 * @param colunaD Coluna correspondente a posição final
	 * @return
	 */
	abstract protected String caminho(int linhaO, char colunaO, int linhaD, char colunaD);
}

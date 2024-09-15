package br.com.poo.entidades;

/**
 * Classe que representa a casa do tabuleiro 
 */
public class Casa {
	private String cor;
	private int linha;
	private char coluna;
	private boolean ocupada;
	private Peça peça;

	/**
	 * Construtor da casa
	 * @param cor cor da casa (branca ou preta)
	 * @param linha linha referente a casa
	 * @param coluna coluna referente a casa
	 * @param ocupada se a casa está com uma peça ou não
	 * @param peça peça que está na casa
	 */
	public Casa(String cor, int linha, char coluna, boolean ocupada, Peça peça) {
		this.cor = cor;
		this.linha = linha;
		this.coluna = coluna;
		this.ocupada = ocupada;
		this.peça = peça;
	}

	/**
	 * Método que retorna a cor da casa
	 * @return cor da casa
	 */
	public String getCor() {
		return this.cor;
	}

	/**
	 * Método que retorna a peça que está na casa
	 * @return peça da casa
	 */
	public Peça getPeça() {
		return this.peça;
	}

	/**
	 * Método que retorna se a casa está ocupada por uma peça
	 * @return true ou false 
	 */
	public boolean isOcupada() {
		return ocupada;
	}
	public void ocuparCasa() {
		this.ocupada = true;
	}
	public void desocuparCasa() {
		this.ocupada = false;
	}

	/**
	 * Método que realiza a adição da peça à casa de forma direta
	 * @param peça
	 */
	public void setPeça(Peça peça) {
		this.peça = peça;
	}

	/**
	 * Método que retorna a linha da casa
	 * @return linha da casa
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * Método que retorna a coluna da casa
	 * @return coluna da casa
	 */
	public char getColuna() {
		return coluna;
	}

}

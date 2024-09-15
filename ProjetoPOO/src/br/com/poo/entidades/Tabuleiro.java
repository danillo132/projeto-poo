package br.com.poo.entidades;

/**
 * Classe que define o tabuleiro do jogo
 */
public class Tabuleiro {

	private Casa[][] tabuleiro;
	private String desenho;

	/**
	 * Construtor que realiza a construção de um tabuleiro 8x8 com linhas númericas e colunas alfabéticas
	 */
	public Tabuleiro() {
		this.tabuleiro = new Casa[8][8];

		char colunas[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		// Configuração das cores das casas
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					tabuleiro[i][j] = new Casa("B", i, colunas[j], false, null);
				} else {
					tabuleiro[i][j] = new Casa("P", i, colunas[j], false, null);
				}
			}
		}
	}

	/**
	 * Método responsável por adicionar manualmente uma peça em uma casa do tabuleiro
	 * @param linha
	 * @param coluna
	 * @param peça
	 */
	public void setPeça(int linha, int coluna, Peça peça) {
		this.tabuleiro[linha][coluna].setPeça(peça);
		this.tabuleiro[linha][coluna].ocuparCasa();
	}

	/**
	 * Método responsável por verificar se a linha e a coluna fornecida ultrapassa as definições do tabuleiro
	 * @param linha  
	 * @param coluna
	 * @return
	 */
	public boolean noLimite(int linha, char coluna) {
		return (coluna >= 'a' && coluna <= 'h') && (linha >= 1 && linha <= 8);
	}

	/**
	 * Método responsável por desenhar o tabuleiro com cores e as peças 
	 * @return tabuleiro desenhado 
	 */
	public String desenho() {
		String ANSI_YELLOW = "\u001B[33m";
		String ANSI_RESET = "\u001B[0m";

		StringBuilder desenho = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			desenho.append(ANSI_YELLOW + (8 - i) + ANSI_RESET + " ");
			for (int j = 0; j < 8; j++) {
				Peça peça = tabuleiro[i][j].getPeça();
				if (peça == null) {
					desenho.append("- ");
				} else {
					desenho.append(peça.desenho() + " ");
				}
			}
			desenho.append("\n");
		}
		desenho.append("  ");
		char colunas[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		for (int i = 0; i < 8; i++) {
			desenho.append(ANSI_YELLOW + colunas[i] + ANSI_RESET + " ");
		}
		return desenho.toString();
	}

	/**
	 * Método responsável por retornar todas as casas do tabuleiro 
	 * @return matriz de casas do tabuleiro
	 */
	public Casa[][] getTabuleiro() {
		return tabuleiro;
	}

	/**
	 * Método responsável por retornar uma casa específica do tabuleiro
	 * @param linha linha da casa
	 * @param coluna coluna da casa
	 * @return
	 */
	public Casa getCasa(int linha, int coluna) {
		return tabuleiro[linha][coluna];
	}
	/*
	 * public static void main(String[] args) { Tabuleiro board1 = new Tabuleiro();
	 * System.out.println("\n" + board1.desenho()); }
	 */
}

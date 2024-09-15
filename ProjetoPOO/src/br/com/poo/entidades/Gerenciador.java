package br.com.poo.entidades;

import java.util.Scanner;

/**
 * Classe onde deve-se criar e disparar o jogo bem como carregar um jogo através
 * de arquivo
 */
public class Gerenciador {

	public static void main(String[] args) {
		testesDesenvolvimento();
		Gerenciador gerenciador = new Gerenciador();
		gerenciador.menu();
	}

	private Jogo jogo;
	Scanner ler = new Scanner(System.in);

	public void menu() {

		while (true) {
			System.out.println("Bem vindo!");
			System.out.println("Escolha uma das opcoes abaixo:");
			System.out.println("1 - iniciar novo jogo");
			System.out.println("2 - Carregar um jogo salvo");
			System.out.println("3 - Sair");

			int opcao = ler.nextInt();

			if (opcao == 1) {
				Jogo jogo1 = new Jogo();
				jogo.iniciarJogo();
			}
			if (opcao == 2) {
				carregarJogo();
			}
			if (opcao == 3) {
				System.err.println("Encerrando...\n");
				return;
			}
		}

	}

	/**
	 * Método responsável pelos testes exaustivos durante o desenvolvimento
	 */
	private static void testesDesenvolvimento() {

		

		System.out.println("=======Peças Brancas======");
		Peça torreB = new Torre("white");
		System.out.println("Peça: " + torreB.desenho() + " caminho: " + torreB.caminho(4, 'b', 4, 'g'));

		Peça reiB = new Rei("white");
		System.out.println("Peça: " + reiB.desenho() + " caminho: " + reiB.caminho(2, 'd', 3, 'e'));

		Peça bispoB = new Bispo("white");
		System.out.println("Peça: " + bispoB.desenho() + " caminho: " + bispoB.caminho(3, 'c', 5, 'a'));

		Peça damaB = new Dama("white");
		System.out.println("Peça: " + damaB.desenho() + " caminho: " + damaB.caminho(2, 'c', 6, 'g'));

		Peça peaoB = new Peão("white");
		System.out.println("Peça: " + peaoB.desenho() + " caminho: " + peaoB.caminho(2, 'c', 3, 'b'));

		Peça cavaloB = new Cavalo("white");
		System.out.println("Peça: " + cavaloB.desenho() + " caminho: " + cavaloB.caminho(2, 'a', 1, 'c'));
		System.out.println("============================");

		System.out.println("=======Peças Pretas======");
		Peça torreP = new Torre("preto");
		System.out.println("Peça: " + torreP.desenho() + " caminho: " + torreP.caminho(4, 'b', 4, 'g'));

		Peça reiP = new Rei("preto");
		System.out.println("Peça: " + reiP.desenho() + " caminho: " + reiP.caminho(2, 'd', 3, 'e'));

		Peça bispoP = new Bispo("preto");
		System.out.println("Peça: " + bispoP.desenho() + " caminho: " + bispoP.caminho(3, 'c', 5, 'a'));

		Peça damaP = new Dama("preto");
		System.out.println("Peça: " + damaP.desenho() + " caminho: " + damaP.caminho(2, 'c', 6, 'g'));

		Peça peaoP = new Peão("preto");
		System.out.println("Peça: " + peaoP.desenho() + " caminho: " + peaoP.caminho(2, 'c', 3, 'h'));

		Peça cavaloP = new Cavalo("preto");
		System.out.println("Peça: " + cavaloP.desenho() + " caminho: " + cavaloP.caminho(2, 'a', 1, 'y'));
		System.out.println("============================");

	}

	/*
	 * public void novoJogo() { jogo = new Jogo(); jogo.iniciarJogo(); }
	 */

	public void carregarJogo() {

	}

}

package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe onde deve-se criar e disparar o jogo bem como carregar um jogo através
 * de arquivo
 */
public class Gerenciador {

	public static void main(String[] args) {
//		testesDesenvolvimento();
		Gerenciador gerenciador = new Gerenciador();
		gerenciador.menu();
	}

	private Jogo jogo;
	Scanner ler = new Scanner(System.in);

	public void menu() {
		int opcao = 0;
		do {
			System.out.println("Bem vindo!");
			System.out.println("Escolha uma das opcoes abaixo:");
			System.out.println("1 - iniciar novo jogo");
			System.out.println("2 - Carregar um jogo salvo");
			System.out.println("3 - Sair");

			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite um número inteiro válido.");
				ler.next();
				continue;
			}

			if (opcao >= 1 && opcao <= 3) {
				switch (opcao) {
				case 1:
					jogo = new Jogo();
					jogo.iniciarJogo();
					break;
				case 2:
					carregarJogo();
					break;
				case 3:
					System.out.println("Encerrando...\n");
					return;
				}
			} else {
				System.out.println("Opção inválida.Digite um número entre 1 e 3");
			}
		} while (opcao != 3);

	}

	/**
	 * Método responsável pelos testes exaustivos durante o desenvolvimento
	 */
	private static void testesDesenvolvimento() {
		List<Peça> pecasJogador1 = new ArrayList<>();

		List<Peça> pecasJogador2 = new ArrayList<>();

		System.out.println("=======Peças Brancas======");
		Peça torreB = new Torre("white");
		System.out.println("Peça: " + torreB.desenho() + " caminho: " + torreB.caminho(4, 'b', 4, 'g'));
		torreB.setInGame(false);

		Peça reiB = new Rei("white");
		System.out.println("Peça: " + reiB.desenho() + " caminho: " + reiB.caminho(2, 'd', 3, 'e'));

		Peça bispoB = new Bispo("white");
		System.out.println("Peça: " + bispoB.desenho() + " caminho: " + bispoB.caminho(3, 'c', 5, 'a'));
		bispoB.setInGame(false);
		Peça damaB = new Dama("white");
		System.out.println("Peça: " + damaB.desenho() + " caminho: " + damaB.caminho(2, 'c', 6, 'g'));

		Peça peaoB = new Peão("white");
		System.out.println("Peça: " + peaoB.desenho() + " caminho: " + peaoB.caminho(2, 'c', 3, 'b'));

		Peça cavaloB = new Cavalo("white");
		System.out.println("Peça: " + cavaloB.desenho() + " caminho: " + cavaloB.caminho(2, 'a', 1, 'c'));
		pecasJogador1.add(torreB);
		pecasJogador1.add(reiB);
		pecasJogador1.add(cavaloB);
		pecasJogador1.add(bispoB);
		pecasJogador1.add(damaB);
		pecasJogador1.add(peaoB);

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
		cavaloP.setInGame(false);
		;
		pecasJogador2.add(torreP);
		pecasJogador2.add(reiP);
		pecasJogador2.add(cavaloP);
		pecasJogador2.add(bispoP);
		pecasJogador2.add(damaP);
		pecasJogador2.add(peaoP);
		System.out.println("============================");

		Jogador jogador1 = new Jogador("Marcos", pecasJogador1);
		System.out.println("Nome jogador 1: " + jogador1.getNomeJogador());
		System.out.println("Peças capturadas: " + jogador1.pecasCapturadas());

		Jogador jogador2 = new Jogador("Pedro", pecasJogador2);
		String jogada1 = jogador1.informaJogada();

		String[] formatarJogada = jogada1.split("");
		for (int i = 0; i < formatarJogada.length; i += 2) {
			if (formatarJogada[i] != null && formatarJogada[i + 1] != null) {
				int linha = Integer.parseInt(formatarJogada[i]);
				char coluna = formatarJogada[i + 1].charAt(0);
				Casa posicaoInicial = new Casa(bispoB.getCor(), linha, coluna, true, bispoB);
				Casa posicaoFinal = new Casa(bispoB.getCor(), linha, coluna, true, bispoB);
			}
		}

		System.out.println("Nome jogador 2: " + jogador1.getNomeJogador());
		System.out.println("Peças capturadas: " + jogador1.pecasCapturadas());

		Jogada jogada = new Jogada(jogador1, jogador2, null, null);

	}

	public void carregarJogo() {

	}

}

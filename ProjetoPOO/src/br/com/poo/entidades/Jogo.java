package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que manipula todo o jogo
 */
public class Jogo {

	Scanner ler = new Scanner(System.in);

	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
	private List<Peça> peçasBrancas;
	private List<Peça> peçasPretas;
	private Jogador jogadorAtual;
	private Jogador jogadorAdversario;
	private List<String> historicoJogadas;
	private List<Jogada> jogadas;
	private boolean jogoFinalizado;

	/**
	 * Construtor responsável por criar os dois jogadores da partida e o tabuleiro contendo as peças em formação inicial
	 */
	public Jogo() {
		// Cria dois jogadores
		// Cria um tabuleiro
		// Cria todas as peças

		this.tabuleiro = new Tabuleiro();

		this.peçasBrancas = new ArrayList<>();
		this.peçasPretas = new ArrayList<>();
		this. jogadas = new ArrayList<>();

		inicializarPeças();

		System.out.println("Insira do nome do jogador 1 - peças brancas");
		String nomeJogador1 = ler.nextLine();
		this.jogador1 = new Jogador(nomeJogador1, this.peçasBrancas);

		System.err.println("");

		System.out.println("Insira do nome do jogador 2 - peças pretas");
		String nomeJogador2 = ler.nextLine();
		this.jogador2 = new Jogador(nomeJogador2, this.peçasPretas);

		jogoFinalizado = false;
		jogadorAtual = jogador1;
		jogadorAdversario = jogador2;
		jogador1.peçasDe();
		jogador2.peçasDe();

		iniciarJogo();

	}

	/**
	 * Método que realiza a formação inicial das peças brancas e pretas do tabuleiro 
	 */
	public void inicializarPeças() {

		peçasBrancas.add(new Torre("branca"));
		peçasBrancas.add(new Cavalo("branca"));
		peçasBrancas.add(new Bispo("branca"));
		peçasBrancas.add(new Dama("branca"));
		peçasBrancas.add(new Rei("branca"));
		peçasBrancas.add(new Bispo("branca"));
		peçasBrancas.add(new Cavalo("branca"));
		peçasBrancas.add(new Torre("branca"));

		for (int i = 0; i < 8; i++) {
			peçasBrancas.add(new Peão("branco"));
		}

		for (int i = 0; i < 8; i++) {
			tabuleiro.setPeça(7, i, peçasBrancas.get(i));
			tabuleiro.setPeça(6, i, peçasBrancas.get(i + 8));
		}

		peçasPretas.add(new Torre("preta"));
		peçasPretas.add(new Cavalo("preta"));
		peçasPretas.add(new Bispo("preta"));
		peçasPretas.add(new Dama("preta"));
		peçasPretas.add(new Rei("preta"));
		peçasPretas.add(new Bispo("preta"));
		peçasPretas.add(new Cavalo("preta"));
		peçasPretas.add(new Torre("preta"));

		for (int i = 0; i < 8; i++) {
			peçasPretas.add(new Peão("preta"));
		}

		for (int i = 0; i < 8; i++) {
			tabuleiro.setPeça(0, i, peçasPretas.get(i));
			tabuleiro.setPeça(1, i, peçasPretas.get(i + 8));
		}

	}

	// public boolean jogadaValida(int linhaO, int colunaO, int linhaD, int
	// colunaD){}
	// public void realizaJogada(int linhaO, int colunaO, int linhaD, int colunaD){}
	// public String registroJogo();
	
	/**
	 * Método que realiza a inicialização do jogo
	 */
	public void iniciarJogo() {
		while (!jogoFinalizado) {
			System.out.println(this.tabuleiro.desenho()); 
			System.out.println("Vez do jogador: " + jogadorAtual.getNomeJogador());
			System.out.println("Digite sua jogada ou salvar (para salvar e sair)");

			String entrada = jogadorAtual.informaJogada();

			if (entrada.equals("salvar")) {

				jogoFinalizado = true;
			} else {
				int linhaO = 8 - Character.getNumericValue(entrada.charAt(0));
				int colunaO = entrada.charAt(1) - 'a';

				int linhaD = 8- Character.getNumericValue(entrada.charAt(2));
				int colunaD = entrada.charAt(3) - 'a';
				

				Jogada jogada = new Jogada(jogadorAtual, jogadorAdversario, tabuleiro.getCasa(linhaO, colunaO),
						tabuleiro.getCasa(linhaD, colunaD));

				System.out.println(linhaO + " ");
				System.out.println(colunaO + " ");
				System.out.println(linhaD + " ");
				System.out.println(colunaD + " ");

				if (jogadorAtual.getNomeJogador().equals(jogador1.getNomeJogador())) {
					jogadorAtual = jogador2;
					jogadorAdversario = jogador1;
				} else {
					jogadorAtual = jogador1;
					jogadorAdversario = jogador2;
				}
			}

			/*
			 * if (jogada.equals("salvar")) { //salvarJogo(); return; } else {
			 * 
			 * 
			 * //Casa casaO = new Casa(jogada, 0, 0, jogoFinalizado, null) //Jogada jogada =
			 * new Jogada(jogadorAtual, linha, coluna) }
			 */
		}
		System.err.println("Jogo finalizado");

	}

	/**
	 * Método que chama a validação da jogada 
	 * @param linhaO
	 * @param colunaO
	 * @param linhaD
	 * @param colunaD
	 * @return
	 */
	public boolean jogadaValida(int linhaO, int colunaO, int linhaD, int colunaD, Jogada jogada) {
		char colunas[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

		if (!(tabuleiro.noLimite(linhaO, colunas[colunaO - 1]) && tabuleiro.noLimite(linhaD, colunas[colunaD - 1]))) {
			return false;
		} else {
			Casa origem = tabuleiro.getCasa(linhaO, colunaO);
			Casa destino = tabuleiro.getCasa(linhaD, colunaD);

			if (origem == destino) {
				return false;
			}
			// Verifica se há uma casa na origem
			if (!origem.isOcupada()) {
				return false;
			}

			// Verifica se a peça é do adversário, não do jogador atual
			if (origem.getCor().equals(destino.getCor())) {
				return false;
			}

			// vcerifica se o movimento é valido para o tipo de peça
			if (!origem.getPeça().movimentoValido(linhaO, colunas[colunaO - 1], linhaD, colunas[colunaD - 1])) {
				return false;
			}
			// Verificar se o caminho está livre, exceto para cavalos

		}
		
		
		return true;
	}
}

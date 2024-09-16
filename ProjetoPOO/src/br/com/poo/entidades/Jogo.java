package br.com.poo.entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	private boolean jogoFinalizado;

	/**
	 * Construtor responsável por criar os dois jogadores da partida e o tabuleiro
	 * contendo as peças em formação inicial
	 */
	public Jogo() {
		// Cria dois jogadores
		// Cria um tabuleiro
		// Cria todas as peças

		this.tabuleiro = new Tabuleiro();

		this.peçasBrancas = new ArrayList<>();
		this.peçasPretas = new ArrayList<>();
		this.historicoJogadas = new ArrayList<>();

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
			peçasBrancas.add(new Peão("branca"));
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

	/**
	 * Método que realiza a inicialização do jogo
	 */
	public void iniciarJogo() {
		while (!jogoFinalizado) {
			System.out.println(this.tabuleiro.desenho());
			System.out.println("Vez do jogador: " + jogadorAtual.getNomeJogador());
			System.out.println("Digite sua jogada ou salvar (para salvar e sair)");
			String entrada = "";
			boolean entradaValida = false;
			boolean jogadaValida = false;

			while (!entradaValida) {
				try {
					entrada = jogadorAtual.informaJogada();
					entradaValida = validarEntrada(entrada);
					if (!entradaValida) {
						throw new IllegalArgumentException(
								"Entrada inválida. Por favor, insira uma coordenada válida no formato XXYY (onde X e Y são números entre 1 e 8, e XY são letras entre a e h).");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

			if (entrada.equalsIgnoreCase("salvar")) {

				jogoFinalizado = true;
				registroJogo();
			} else if (entrada.equalsIgnoreCase("parar")) {
				jogoFinalizado = true;
			} else {

				int linhaO = 8 - Character.getNumericValue(entrada.charAt(0));
				int colunaO = entrada.charAt(1) - 'a';

				int linhaD = 8 - Character.getNumericValue(entrada.charAt(2));
				int colunaD = entrada.charAt(3) - 'a';

				Jogada jogada = new Jogada(jogadorAtual, jogadorAdversario, tabuleiro.getCasa(linhaO, colunaO),
						tabuleiro.getCasa(linhaD, colunaD));
				try {
					jogadaValida = jogada.ehValida(tabuleiro, jogadorAtual, tabuleiro.getCasa(linhaO, colunaO),
							tabuleiro.getCasa(linhaD, colunaD));
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}

				if (jogadaValida) {
					realizarJogada(linhaO, colunaO, linhaD, colunaD);
					if (jogada.ehXeque(tabuleiro)) {
						System.out.println("O Rei está em xeque!");
						if (jogada.ehXequeMate(tabuleiro)) {
							System.out.println("Xeque-mate!");
						}
					}

				}

				if (jogadorAtual.getNomeJogador().equalsIgnoreCase(jogador1.getNomeJogador())) {
					jogadorAtual = jogador2;
					jogadorAdversario = jogador1;
				} else {
					jogadorAtual = jogador1;
					jogadorAdversario = jogador2;
				}
				System.out.println(jogadorAtual.pecasCapturadas());
			}
			historicoJogadas.add(entrada);

		}
		System.out.println("Jogo finalizado");

	}

	private void realizarJogada(int linhaO, int colunaO, int linhaD, int colunaD) {
		Casa casaDestino = tabuleiro.getCasa(linhaD, colunaD);
		if (casaDestino.getPeça() != null) {

			if (casaDestino.getPeça().getTipo().equalsIgnoreCase("R")) {
				System.out.println("O rei foi capturado!");
				jogoFinalizado = true;
				return;
			}
			this.capturarPeca(tabuleiro, casaDestino.getPeça(), jogadorAdversario);
		}
		casaDestino.setPeça(tabuleiro.getCasa(linhaO, colunaO).getPeça());
		casaDestino.ocuparCasa();
		Casa casaOrigem = tabuleiro.getCasa(linhaO, colunaO);
		casaOrigem.setPeça(null);
		casaOrigem.desocuparCasa();

		tabuleiro.desenho();
	}

	private void registroJogo() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("jogosalvo.txt"))) {
			for (String jogada : historicoJogadas) {
				writer.println(jogada);
			}
			System.out.println("Histórico de jogo salvo com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao salvar o histórico de jogo: " + e.getMessage());
		}
	}

	public void capturarPeca(Tabuleiro tabuleiro, Peça peca, Jogador jogadorAdversario) {
		if (peca != null) {
			if (peca.getCor().equalsIgnoreCase(jogadorAdversario.getPeças().get(0).getCor())) {
				jogadorAdversario.getPeças().remove(peca);
				peca.setInGame(false);
				jogadorAdversario.getPeças().add(peca);

				jogadorAdversario.setNumPeçasAtivas(jogadorAdversario.getPeças().size());
			}
		}
	}

	/**
	 * Método que chama a validação da jogada
	 * 
	 * @param linhaO
	 * @param colunaO
	 * @param linhaD
	 * @param colunaD
	 * @return
	 */
	public boolean jogadaValida(int linhaO, int colunaO, int linhaD, int colunaD) {
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

	private boolean validarEntrada(String entrada) {
		if (entrada.equalsIgnoreCase("salvar") || entrada.equalsIgnoreCase("parar")) {
			return true;
		} else {
			if (entrada.length() != 4) {
				return false;
			}

			if (!Character.isDigit(entrada.charAt(0))) {
				return false;
			}

			if (!Character.isLetter(entrada.charAt(1))) {
				return false;
			}

			if (!Character.isDigit(entrada.charAt(2))) {
				return false;
			}

			if (!Character.isLetter(entrada.charAt(3))) {
				return false;
			}

			if (entrada.charAt(0) < '1' || entrada.charAt(0) > '8') {
				return false;
			}

			if (entrada.charAt(2) < '1' || entrada.charAt(2) > '8') {
				return false;
			}

			if (entrada.charAt(1) > 'h' || entrada.charAt(3) > 'h') {
				return false;
			}
		}

		return true;
	}
}

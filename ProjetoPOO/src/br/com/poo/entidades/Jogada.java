package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase referente a jogada que é realizada por um dos jogadores
 */
public class Jogada {

	private Jogador jogador;
	private Jogador jogadorAdversario;
	private Caminho caminho;

	/**
	 * Construtor que adiciona o jogador atual, o jogador adversário, a casa inicial da jogada e a casa final da jogada
	 * @param jogador jogador atual
	 * @param jogadorAdversario jogador adversário
	 * @param posicaoInicial casa inicial da jogada
	 * @param posicaoFinal casa final da jogada
	 */
	public Jogada(Jogador jogador, Jogador jogadorAdversario, Casa posicaoInicial, Casa posicaoFinal) {
		this.jogador = jogador;
		this.jogadorAdversario = jogadorAdversario;
		caminho = new Caminho(posicaoInicial, posicaoFinal);
	}

	/**
	 * Método que realiza validações da jogada para verificar se é válida 
	 * @param tabuleiro tabuleiro do jogo
	 * @param jogadorDoTurno Jogador que está realizando a jogada nesse turno
	 * @return true se a jogada pode ser feita ou false caso não seja válida
	 */
	public boolean ehValida(Tabuleiro tabuleiro, Jogador jogadorDoTurno, Casa casaInicial, Casa casaFinal) {
		caminho.populaCaminho(tabuleiro);
		String corPeçasJogador = jogadorDoTurno.getPeças().get(0).getCor();
		if (tabuleiro.noLimite(casaInicial.getLinha(), casaInicial.getColuna())
				&& tabuleiro.noLimite(casaFinal.getLinha(), casaFinal.getColuna())) {
			if (caminho.casaInicial().getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
				if (casaFinal.getPeça() == null
						|| !caminho.casaFinal().getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
					if (caminho.estaLivre() || casaInicial.getPeça().getTipo().equalsIgnoreCase("C")) {
						if (casaInicial.getPeça().movimentoValido(casaInicial.getLinha(),
								casaInicial.getColuna(), casaFinal.getLinha(), casaFinal.getColuna())) {
							return true;
						}
						return false;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	/**
	 * Método que verifica se o Rei do jogador do turno está em situação de xeque
	 * @param tabuleiro tabuleiro do jogo
	 * @return retorna true se o rei está em xeque ou false caso não esteja 
	 */
	public boolean ehXeque(Tabuleiro tabuleiro) {
		boolean reiEmXeque = estaReiEmXeque(tabuleiro);
		if (!reiEmXeque) {
			return false;
		}
		return reiEmXeque;
	}

	/**
	 * Método que verifica se  o rei do jogador do turno está em situação de xeque-mate
	 * @param tabuleiro tabuleiro do jogo
	 * @return abuleiro tabuleiro do jogo
	 * @return retorna true se o rei está em xeque-mate ou false caso não esteja 
	 */
	public boolean ehXequeMate(Tabuleiro tabuleiro) {

		boolean reiEmXeque = estaReiEmXeque(tabuleiro);

		if (!reiEmXeque) {
			return false;
		}
		Peça rei = encontrarCasaDoRei(tabuleiro).getPeça();
		boolean xequeMate = getPossiveisJogadas(rei, tabuleiro);
		return xequeMate;
	}

	/**
	 * Método privado que simula as jogadas com todas as peças adversárias que podem deixar o rei do jogador do turno em xeque
	 * @param tabuleiro tabuleiro do jogo
	 * @return retorna true se alguma jogada deixou o rei em xeque ou não caso não tenha jogada que o deixou em xeque
	 */
	private boolean estaReiEmXeque(Tabuleiro tabuleiro) {
		Casa casaDoRei = encontrarCasaDoRei(tabuleiro);
		if (casaDoRei == null) {
			return false;
		}

		for (Casa casaComPeçaAdversaria : getCasasComPeçasAdversarias(tabuleiro)) {
			Jogada jogadaHipotetica = new Jogada(jogador, jogadorAdversario, casaComPeçaAdversaria, casaDoRei);
			if (jogadaHipotetica.ehValida(tabuleiro, jogadorAdversario, casaComPeçaAdversaria, casaDoRei)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Método responsável pela busca da casa do rei do jogador do turno no tabuleiro
	 * @param tabuleiro tabuleiro do jog
	 * @return casa em que o rei se encontra
	 */
	private Casa encontrarCasaDoRei(Tabuleiro tabuleiro) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Peça Peça = tabuleiro.getTabuleiro()[i][j].getPeça();
				if (Peça instanceof Rei && Peça.getCor().equals(jogador.getPeças().get(0).getCor())) {
					return tabuleiro.getTabuleiro()[i][j];
				}
			}
		}
		return null;
	}

	/*
	 * Método que simula as possíveis jogadas que o jogador do turno pode fazer com o seu rei para tirá-lo da situação de xeque
	 */
	private boolean getPossiveisJogadas(Peça peça, Tabuleiro tabuleiro) {
		if (peça == null) {
			return false;
		}

		Casa casaDoRei = encontrarCasaDoRei(tabuleiro);
		if (casaDoRei == null) {
			return false;
		}

		int[] direcoes = { -1, 0, 1 };
		for (int horizontal : direcoes) {
			for (int vertical : direcoes) {
				if (horizontal == 0 && vertical == 0) {
					continue;
				}

				int novaLinha = casaDoRei.getLinha() + horizontal;
				int novaColuna = (casaDoRei.getColuna() - vertical) - 'a';

				if (!tabuleiro.noLimite(novaLinha, (char) novaColuna)) {
					continue;
				}

				Casa novaCasa = tabuleiro.getTabuleiro()[novaLinha][novaColuna];
				Jogada jogadaHipotetica = new Jogada(jogador, jogadorAdversario, casaDoRei, novaCasa);

				if (jogadaHipotetica.ehValida(tabuleiro, jogador, casaDoRei, novaCasa)) {

					Peça rei = casaDoRei.getPeça();
					novaCasa.setPeça(rei);
					casaDoRei.setPeça(null);

					boolean reiAindaEmXeque = estaReiEmXeque(tabuleiro);
					if (!reiAindaEmXeque) {
						return false;
					}
					casaDoRei.setPeça(rei);
					novaCasa.setPeça(null);
				}
			}
		}

		return true;
	}

	/**
	 * Método que retorna todas as casas que estão preenchidas com peças adversárias
	 * @param tabuleiro tabuleiro do jogo
	 * @return Lista de casas com peças adversárias 
	 */
	private List<Casa> getCasasComPeçasAdversarias(Tabuleiro tabuleiro) {
		List<Casa> adversarios = new ArrayList<>();
		String corPeçasJogador = jogador.getPeças().get(0).getCor();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Casa casa = tabuleiro.getTabuleiro()[i][j];
				if (casa != null && casa.getPeça() != null && !casa.getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
					adversarios.add(casa);
				}
			}
		}
		return adversarios;
	}
	

}

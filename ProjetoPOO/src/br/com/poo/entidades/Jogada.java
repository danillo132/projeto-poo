package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Jogada {

	private Jogador jogador;
	private Casa posicaoInicial;
	private Casa posicaoFinal;
	private Caminho caminho;

	public Jogada() {
	}

	public Jogada(Jogador jogador, Casa posicaoInicial, Casa posicaoFinal) {
		this.jogador = jogador;
		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
		caminho = new Caminho(posicaoInicial, posicaoFinal);
	}

	public boolean ehValida(Tabuleiro tabuleiro) {
		if (tabuleiro.noLimite(posicaoInicial.getLinha(), posicaoInicial.getColuna())
				&& tabuleiro.noLimite(posicaoFinal.getLinha(), posicaoFinal.getColuna())) {
			if (jogador.getPeças().contains(caminho.casaInicial().getPeça())) {
				if (posicaoFinal.getPeça() == null || !jogador.getPeças().contains(caminho.casaInicial().getPeça())) {
					if (caminho.estaLivre() || posicaoInicial.getPeça().getTipo().equalsIgnoreCase("C")) {
						if (posicaoInicial.getPeça().movimentoValido(posicaoInicial.getColuna(),
								posicaoInicial.getColuna(), posicaoFinal.getColuna(), posicaoFinal.getColuna())) {
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
	}

	public boolean ehXeque(Tabuleiro tabuleiro) {
		// Implementar método
		return true;
	}

	public boolean ehXequeMate(Tabuleiro tabuleiro) {

		boolean reiEmXeque = estaReiEmXeque(tabuleiro);

		if (!reiEmXeque) {
			return false;
		}
		return true;
	}

	private boolean estaReiEmXeque(Tabuleiro tabuleiro, Jogador adversario) {
		Casa casaDoRei = encontrarCasaDoRei(tabuleiro);
		if (casaDoRei == null) {
			return false;
		}

		for (Casa casaComPeçaAdversaria : getCasasComPeçasAdversarias(tabuleiro)) {
			Jogada jogadaHipotetica = new Jogada(adversario, casaComPeçaAdversaria, casaDoRei);
			if (jogadaHipotetica.ehValida(tabuleiro)) {
				return true;
			}
		}

		return false;
	}

	private Casa encontrarCasaDoRei(Tabuleiro tabuleiro) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Peça peca = tabuleiro.getTabuleiro()[i][j].getPeça();
				if (peca instanceof Rei && peca.getCor().equals(jogador.getPeças().get(0).getCor())) {
					return tabuleiro.getTabuleiro()[i][j];
				}
			}
		}
		return null;
	}

	private List<Casa> getCasasComPeçasAdversarias(Tabuleiro tabuleiro) {
		List<Casa> adversarios = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Casa casa = tabuleiro.getTabuleiro()[i][j];
				if (casa != null && !casa.getPeça().getCor().equals(jogador.getPeças().get(0).getCor())) {
					adversarios.add(casa);
				}
			}
		}
		return adversarios;
	}
}

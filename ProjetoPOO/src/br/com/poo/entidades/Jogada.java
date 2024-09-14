package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Jogada {

	private Jogador jogador;
	private Jogador jogadorAdversario;
	private Casa posicaoInicial;
	private Casa posicaoFinal;
	private Caminho caminho;



	public Jogada(Jogador jogador,Jogador jogadorAdversario, Casa posicaoInicial, Casa posicaoFinal) {
		this.jogador = jogador;
		this.jogadorAdversario = jogadorAdversario;
		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
		caminho = new Caminho(posicaoInicial, posicaoFinal);
	}


	public boolean ehValida(Tabuleiro tabuleiro, Jogador jogadorDoTurno) {
		String corPeçasJogador = jogadorDoTurno.getPeças().get(0).getCor();
		if (tabuleiro.noLimite(posicaoInicial.getLinha(), posicaoInicial.getColuna())
				&& tabuleiro.noLimite(posicaoFinal.getLinha(), posicaoFinal.getColuna())) {
			if (caminho.casaInicial().getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
				if (posicaoFinal.getPeça() == null || !caminho.casaFinal().getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
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
		return false;
	}

	public boolean ehXeque(Tabuleiro tabuleiro) {
		  boolean reiEmXeque = estaReiEmXeque(tabuleiro);
		    if (!reiEmXeque) {
		        return false;
		    }
		    return reiEmXeque;
	}

	public boolean ehXequeMate(Tabuleiro tabuleiro) {

		boolean reiEmXeque = estaReiEmXeque(tabuleiro);

		if (!reiEmXeque) {
			return false;
		}
		  Peça rei = encontrarCasaDoRei(tabuleiro).getPeça();
		    boolean xequeMate = getPossiveisJogadas(rei, tabuleiro);
		return xequeMate;
	}

	private boolean estaReiEmXeque(Tabuleiro tabuleiro) {
		Casa casaDoRei = encontrarCasaDoRei(tabuleiro);
		if (casaDoRei == null) {
			return false;
		}

		for (Casa casaComPeçaAdversaria : getCasasComPeçasAdversarias(tabuleiro)) {
			Jogada jogadaHipotetica = new Jogada(jogador, jogadorAdversario, casaComPeçaAdversaria, casaDoRei);
			if (jogadaHipotetica.ehValida(tabuleiro, jogadorAdversario)) {
				return true;
			}
		}

		return false;
	}

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
	
	private boolean getPossiveisJogadas(Peça peça, Tabuleiro tabuleiro) {
	    if (peça == null) {
	        return false; 
	    }

	    Casa casaDoRei = encontrarCasaDoRei(tabuleiro);
	    if (casaDoRei == null) {
	        return false;
	    }

	    int[] direcoes = {-1, 0, 1};
	    for (int dx : direcoes) {
	        for (int dy : direcoes) {
	            if (dx == 0 && dy == 0) {
	            	continue;
	            }

	            int novaLinha = casaDoRei.getLinha() + dx;
	            int novaColuna = casaDoRei.getColuna() - dy;

	            if (!tabuleiro.noLimite(novaLinha, (char) novaColuna)) {
	                continue;
	            }

	            Casa novaCasa = tabuleiro.getTabuleiro()[novaLinha][novaColuna];
	            Jogada jogadaHipotetica = new Jogada(jogador, jogadorAdversario, casaDoRei, novaCasa);

	            if (jogadaHipotetica.ehValida(tabuleiro, jogador)) {
	
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

	private List<Casa> getCasasComPeçasAdversarias(Tabuleiro tabuleiro) {
		List<Casa> adversarios = new ArrayList<>();
		String corPeçasJogador = jogador.getPeças().get(0).getCor();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Casa casa = tabuleiro.getTabuleiro()[i][j];
				if (casa != null && !casa.getPeça().getCor().equalsIgnoreCase(corPeçasJogador)) {
					adversarios.add(casa);
				}
			}
		}
		return adversarios;
	}
}

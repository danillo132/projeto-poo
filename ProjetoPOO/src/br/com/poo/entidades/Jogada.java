package br.com.poo.entidades;

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
				if(jogador.getPeças().contains(caminho.casaInicial().getPeça())) {
					if(posicaoFinal.getPeça() == null || !jogador.getPeças().contains(caminho.casaInicial().getPeça())) {
						if(caminho.estaLivre() || posicaoInicial.getPeça().getTipo().equalsIgnoreCase("C")) {
							if(posicaoInicial.get.movimentoValido()) {
								
							}
						}
					}
				}
		}
	}
}

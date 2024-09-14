package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private Casa posicaoInicial;
	private Casa posicaoFinal;
	private List<Casa> sequenciaDeCasas;
	
	
	public Caminho(Casa posicaoInicial, Casa posicaoFinal)  {
		sequenciaDeCasas = new ArrayList<>();
		
		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
		this.sequenciaDeCasas.add(posicaoInicial);
		this.sequenciaDeCasas.add(posicaoFinal);
		
		
	}
	
	
	public void populaCaminho(Tabuleiro tabuleiro) {
		String caminhoDaPeca = posicaoInicial.getPeça().caminho(posicaoInicial.getLinha(), posicaoInicial.getColuna(), posicaoFinal.getLinha(), posicaoFinal.getColuna());
		  if (!caminhoDaPeca.isEmpty()) {
		        String[] partesCaminho = caminhoDaPeca.split("");
		        for (int i = 0; i < partesCaminho.length; i += 2) {
		            if (partesCaminho[i] != null && partesCaminho[i+1] != null) {
		                int linha = Integer.parseInt(partesCaminho[i]);
		                char coluna = partesCaminho[i+1].charAt(0);
		                if(tabuleiro.getTabuleiro()[linha][coluna] != null) {
		                	Casa casaNoTabuleiro = tabuleiro.getTabuleiro()[linha][coluna];
		                	
		                	  Casa novaCasa = new Casa(casaNoTabuleiro.getCor(), linha,coluna, casaNoTabuleiro.isOcupada(), casaNoTabuleiro.getPeça());
				                sequenciaDeCasas.add(novaCasa);
		                }
		              
		            }
		        }
		    }
	}

	
	public boolean estaLivre() {
		
		if(sequenciaDeCasas != null) {
			
	
		for(int i = 2; i < sequenciaDeCasas.size();i++) {
			if(sequenciaDeCasas.get(i).isOcupada()) {
				return false;
			}
		}
		}
		return true;
	}
	
	
	public Casa casaInicial() {
		if(sequenciaDeCasas != null) {
			return sequenciaDeCasas.get(0);
		}
		return null;
	}
	
	public Casa casaFinal() {
		if(sequenciaDeCasas != null) {
			return sequenciaDeCasas.get(1);
		}
		return null;
	}
	
	
	
}

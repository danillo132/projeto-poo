package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;

public class Caminho {

	private Casa posicaoInicial;
	private Casa posicaoFinal;
	private List<Casa> sequenciaDeCasas;
	
	
	public Caminho(Casa posicaoInicial, Casa posicaoFinal) {
		sequenciaDeCasas = new ArrayList<>();
		
		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
		this.sequenciaDeCasas.add(posicaoInicial);
		
	}

	
	public boolean estaLivre() {
		if(sequenciaDeCasas != null) {
			
	
		for(int i = 1; i < sequenciaDeCasas.size();i++) {
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
			return sequenciaDeCasas.get(sequenciaDeCasas.size() - 1);
		}
		return null;
	}
	
	
	
}

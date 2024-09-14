package br.com.poo.entidades;

public class Torre extends Peça {

	public Torre(String cor) {
		super("T", cor, true);
	}

	@Override
	public String desenho() {
		if (this.getCor().equals("preto"))
			return "\u001B[31m" + "T" + "\u001B[0m";
		else
			return "T";
	}

	@Override
	boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);

		return (diferencaColuna == 0) ^ (diferencaLinha == 0);
	}

	@Override
	String caminho( int linhaO, char colunaO, int  linhaD, char colunaD) {
		 if(this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
			
	            StringBuilder caminho = new StringBuilder();
	            
	            if (colunaO < colunaD) {
	                for (int i = colunaO; i <= colunaD; i++) {
	                    caminho.append(linhaO).append((char)i);
	                }
	            } 
	            
	            if(linhaO < linhaD) {
	            	
	            	  for (int i = linhaO; i <= linhaD; i++) {
		                    caminho.append(i).append(colunaO);
		                }
		            } 
	            
	         
	            
	            return caminho.toString();
	        } else {
	            return "";
	        }
	}
}

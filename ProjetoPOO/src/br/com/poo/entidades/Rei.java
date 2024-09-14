package br.com.poo.entidades;

public class Rei extends Peça {

    public Rei(String cor) {
        super("R", cor, true);
    }

    @Override
    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "R" + "\u001B[0m";
        else
            return "R"; 
    }

	@Override
	boolean movimentoValido( int linhaO, char colunaO, int  linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
        int diferencaLinha = Math.abs(linhaO - linhaD);
        return (diferencaColuna <= 1 && diferencaLinha <= 1) && !(diferencaColuna == 0 && diferencaLinha == 0);
	}

	@Override
	String caminho( int linhaO, char colunaO, int  linhaD, char colunaD) {
		if(this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
			 StringBuilder caminho = new StringBuilder();
		        
		        caminho.append(linhaO).append(colunaO);
		        
		        caminho.append(linhaD).append(colunaD);
		        
		        return caminho.toString();
		}else {
			return "";
		}
	}
}

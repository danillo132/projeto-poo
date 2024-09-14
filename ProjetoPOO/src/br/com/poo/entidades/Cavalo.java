package br.com.poo.entidades;

public class Cavalo extends Peça {

    public Cavalo(String cor) {
        super("C", cor, true);
    }

    @Override
    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "C" + "\u001B[0m";
        else
            return "C"; 
    }

	@Override
	boolean movimentoValido( int linhaO, char colunaO, int  linhaD, char colunaD) {
		  int diferencaColuna = Math.abs(colunaO - colunaD);
	        int diferencaLinha = Math.abs(linhaO - linhaD);
	        return (diferencaColuna == 2 && diferencaLinha == 1) || (diferencaColuna == 1 && diferencaLinha == 2);
	}

	@Override
	String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
	    if(this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
	        StringBuilder caminho = new StringBuilder();
	     
	        
	    } else {
	        return "";
	    }
	}

 
}

package br.com.poo.entidades;
public class Casa {
    private String cor;
    private int linha;
    private char coluna;
    private boolean ocupada;
    private Peça peça;

    public Casa(String cor, int linha, char coluna, boolean ocupada, Peça peça) {
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.ocupada = ocupada;
        this.peça = peça;
    }

    public String getCor(){
        return this.cor;
    }

    public Peça getPeça(){
        return this.peça;
    }

    public boolean isOcupada() {
		return ocupada;
	}
    public void setPeça(Peça peça){
        this.peça = peça;
    }

    
    public int getLinha() {
		return linha;
	}
    public char getColuna() {
		return coluna;
	}
    
    
}

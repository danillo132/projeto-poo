package br.com.poo.entidades;

public class Cavalo extends Peça {

    public Cavalo(String cor) {
        super("C", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "C" + "\u001B[0m";
        else
            return "C"; 
    }

    //abstract String desenho();
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD);
}

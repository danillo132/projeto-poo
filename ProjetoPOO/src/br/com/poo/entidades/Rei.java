package br.com.poo.entidades;

public class Rei extends Peça {

    public Rei(String cor) {
        super("R", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "R" + "\u001B[0m";
        else
            return "R"; 
    }
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD); 
}

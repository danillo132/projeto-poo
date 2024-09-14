
public class Bispo extends Peça {

    public Bispo(String cor) {
        super("B", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "B" + "\u001B[0m";
        else
            return "B"; 
    }

    //abstract String desenho();
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD);
}

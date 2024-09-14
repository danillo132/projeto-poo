
public class Torre extends Peça {

    public Torre(String cor) {
        super("T", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "T" + "\u001B[0m";
        else
            return "T"; 
    }
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD);
}

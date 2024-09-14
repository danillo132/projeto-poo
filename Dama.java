
public class Dama extends Peça {

    public Dama(String cor) {
        super("D", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "D" + "\u001B[0m";
        else
            return "D"; 
    }
    //abstract String desenho();
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD); 
}

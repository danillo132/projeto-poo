
public class Peão extends Peça {

    public Peão(String cor) {
        super("P", cor, true);
    }

    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "P" + "\u001B[0m";
        else
            return "P"; 
    }
  
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD); 
}

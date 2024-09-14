
/**
 * Peça
 */
public abstract class Peça {

    private String cor;
    private String tipo;
    private boolean inGame; //Se true, está no jogo. Se false, foi comida;

    public String getTipo() {
        return this.tipo;
    }

    public String getCor(){
        return this.cor;
    }

    public Peça(String tipo, String cor, boolean inGame) {
        if (cor.equals("black")){
            this.tipo = "\u001B[31m" + tipo + "\u001B[0m";
        } else {
            this.tipo = tipo;
        }

        this.cor = cor;
        this.inGame = inGame;
    }

     
    abstract public String desenho();
  /* 
    abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);

    abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD);
     */
}

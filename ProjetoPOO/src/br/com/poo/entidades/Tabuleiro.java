package br.com.poo.entidades;

/*
 Tabuleiro
 */
public class Tabuleiro {

    private Casa[][] tabuleiro;
    private String desenho;

    public Tabuleiro() {
        this.tabuleiro = new Casa[8][8];

        char colunas[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Configuração das cores das casas
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    tabuleiro[i][j] = new Casa("B", i, colunas[i], false, null);
                } else {
                    tabuleiro[i][j] = new Casa("P", i, colunas[i], false, null);
                }
            }
        }
    }

    public void setPeça(int linha, int coluna, Peça peça){
        this.tabuleiro[linha][coluna].setPeça(peça);
    }

    public boolean noLimite(int linha, char coluna) {
        return (coluna >= 'a' && coluna <= 'h') && (linha >= 1 && linha <= 8);
    }

    public String desenho() {
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        StringBuilder desenho = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            desenho.append(ANSI_YELLOW + (8 - i) + ANSI_RESET + " ");
            for (int j = 0; j < 8; j++) {
                Peça peça = tabuleiro[i][j].getPeça();
                if (peça == null) {
                    desenho.append("- ");
                } else {
                    desenho.append(peça.desenho() + " ");
                }
            }
            desenho.append("\n");
        }
        desenho.append("  ");
        char colunas[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        for (int i = 0; i < 8; i++) {
            desenho.append(ANSI_YELLOW + colunas[i] + ANSI_RESET + " ");
        }
        return desenho.toString();
    }

    public Casa[][] getTabuleiro() {
        return tabuleiro;
    }

    public static void main(String[] args) {
        Tabuleiro board1 = new Tabuleiro();
        System.out.println("\n" + board1.desenho());
    }
}

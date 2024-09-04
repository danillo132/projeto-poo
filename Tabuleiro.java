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

        // Configuração inicial das peças pretas
// Rei preto
        Peça auxPeça = new Rei("preto");
        tabuleiro[0][4].setPeça(auxPeça); // O Rei preto vai na casa e4 (0, 4)

// Dama preta
        auxPeça = new Dama("preto");
        tabuleiro[0][3].setPeça(auxPeça); // A Dama preta vai na casa d4 (0, 3)

// Cavalos pretos
        auxPeça = new Cavalo("preto");
        tabuleiro[0][1].setPeça(auxPeça); // Cavalo preto na casa b8 (0, 1)
        auxPeça = new Cavalo("preto");
        tabuleiro[0][6].setPeça(auxPeça); // Cavalo preto na casa g8 (0, 6)

// Bispos pretos
        auxPeça = new Bispo("preto");
        tabuleiro[0][2].setPeça(auxPeça); // Bispo preto na casa c8 (0, 2)
        auxPeça = new Bispo("preto");
        tabuleiro[0][5].setPeça(auxPeça); // Bispo preto na casa f8 (0, 5)

// Torres pretas
        auxPeça = new Torre("preto");
        tabuleiro[0][0].setPeça(auxPeça); // Torre preta na casa a8 (0, 0)
        auxPeça = new Torre("preto");
        tabuleiro[0][7].setPeça(auxPeça); // Torre preta na casa h8 (0, 7)

// Peões pretos
        for (int i = 0; i < 8; i++) {
            tabuleiro[1][i].setPeça(new Peão("preto"));
        }

// Configuração inicial das peças brancas
// Rei branco
        auxPeça = new Rei("branco");
        tabuleiro[7][4].setPeça(auxPeça); // O Rei branco vai na casa e1 (7, 4)

// Dama branca
        auxPeça = new Dama("branco");
        tabuleiro[7][3].setPeça(auxPeça); // A Dama branca vai na casa d1 (7, 3)

// Cavalos brancos
        auxPeça = new Cavalo("branco");
        tabuleiro[7][1].setPeça(auxPeça); // Cavalo branco na casa b1 (7, 1)
        auxPeça = new Cavalo("branco");
        tabuleiro[7][6].setPeça(auxPeça); // Cavalo branco na casa g1 (7, 6)

// Bispos brancos
        auxPeça = new Bispo("branco");
        tabuleiro[7][2].setPeça(auxPeça); // Bispo branco na casa c1 (7, 2)
        auxPeça = new Bispo("branco");
        tabuleiro[7][5].setPeça(auxPeça); // Bispo branco na casa f1 (7, 5)

// Torres brancas
        auxPeça = new Torre("branco");
        tabuleiro[7][0].setPeça(auxPeça); // Torre branca na casa a1 (7, 0)
        auxPeça = new Torre("branco");
        tabuleiro[7][7].setPeça(auxPeça); // Torre branca na casa h1 (7, 7)

// Peões brancos
        for (int i = 0; i < 8; i++) {
            tabuleiro[6][i].setPeça(new Peão("branco")); // Peões brancos na linha 2 (6, 0-7)
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j].getCor() + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean noLimite(int linha, char coluna) {
        return false;
    }

    public String desenho() {
        StringBuilder desenho = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            desenho.append(8 - i + " ");
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
            desenho.append(colunas[i] + " ");
        }
        return desenho.toString();
    }

    public static void main(String[] args) {
        Tabuleiro board1 = new Tabuleiro();
        System.out.println("\n" + board1.desenho());
    }
}

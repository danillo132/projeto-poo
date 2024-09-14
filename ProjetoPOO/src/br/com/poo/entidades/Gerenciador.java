package br.com.poo.entidades;

import java.util.Scanner;

/**
 * Classe onde deve-se criar e disparar o jogo bem como carregar um jogo através
 * de arquivo
 */
public class Gerenciador {

    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.menu();        
    }

    private Jogo jogo;
    Scanner ler = new Scanner(System.in);

    public void menu() {

        while (true) {
            System.out.println("Bem vindo!");
            System.out.println("Escolha uma das opcoes abaixo:");
            System.out.println("1 - iniciar novo jogo");
            System.out.println("2 - Carregar um jogo salvo");
            System.out.println("3 - Sair");

            int opcao = ler.nextInt();

            if (opcao == 1) {
                Jogo jogo1 = new Jogo();
                jogo.iniciarJogo();               
            }
            if (opcao == 2) {
                carregarJogo();
            }
            if (opcao == 3) {
                System.err.println("Encerrando...\n");
                return;
            }
        }

    }



    private static void testesDesenvolvimento() {

        /**
         * Método responsável pelos testes exaustivos durante o desenvolvimento
         */
    	
    	Peça torre = new Torre("white");
    	System.out.println( torre.caminho(4, 'b', 4, 'g'));
    	
    	Peça rei = new Rei("white");
    	System.out.println( rei.caminho(2, 'd', 3, 'e'));
    	
    	Peça bispo = new Bispo("white");
    	System.out.println( bispo.caminho(3, 'c', 5, 'a'));
    	
    	Peça dama = new Dama("white");
    	System.out.println( dama.caminho(2, 'c', 6, 'g'));
    	
//    	Peça peao = new Peão("white");
//    	System.out.println( peao.caminho(2, 'c', 3, 'b'));
//    	
    	Peça cavalo = new Cavalo("white");
    	System.out.println( cavalo.caminho(2, 'a', 1, 'c'));
    	


    }

/* 
    public void novoJogo() {
        jogo = new Jogo();
        jogo.iniciarJogo();
    }
*/

    public void carregarJogo() {

    }

}

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

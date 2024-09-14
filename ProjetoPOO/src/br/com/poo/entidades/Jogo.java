package br.com.poo.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    Scanner ler = new Scanner(System.in);

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private List<Peça> peçasBrancas;
    private List<Peça> peçasPretas;
    private Jogador jogadorAtual;
    private List<String> historicoJogadas;
    private boolean jogoFinalizado;

    public Jogo() {
        //Cria dois jogadores
        //Cria um tabuleiro
        //Cria todas as peças        

        this.tabuleiro = new Tabuleiro();

        this.peçasBrancas = new ArrayList<>();
        this.peçasPretas = new ArrayList<>();

        inicializarPeças();

        System.out.println("Insira do nome do jogador 1 - peças brancas");
        String nomeJogador1 = ler.nextLine();
        this.jogador1 = new Jogador(nomeJogador1, this.peçasBrancas);

        System.err.println("");

        System.out.println("Insira do nome do jogador 2 - peças pretas");
        String nomeJogador2 = ler.nextLine();
        this.jogador2 = new Jogador(nomeJogador2, this.peçasPretas);

        jogoFinalizado = false;
        jogadorAtual = jogador1;

        jogador1.peçasDe();
        jogador2.peçasDe();

        iniciarJogo();

    }

    public void inicializarPeças() {

        peçasBrancas.add(new Torre("branca"));
        peçasBrancas.add(new Cavalo("branca"));
        peçasBrancas.add(new Bispo("branca"));
        peçasBrancas.add(new Dama("branca"));
        peçasBrancas.add(new Rei("branca"));
        peçasBrancas.add(new Bispo("branca"));
        peçasBrancas.add(new Cavalo("branca"));
        peçasBrancas.add(new Torre("branca"));

        for (int i = 0; i < 8; i++) {
            peçasBrancas.add(new Peão("branco"));
        }

        for (int i = 0; i < 8; i++) {
            tabuleiro.setPeça(7, i, peçasBrancas.get(i));
            tabuleiro.setPeça(6, i, peçasBrancas.get(i + 8));
        }

        peçasPretas.add(new Torre("preta"));
        peçasPretas.add(new Cavalo("preta"));
        peçasPretas.add(new Bispo("preta"));
        peçasPretas.add(new Dama("preta"));
        peçasPretas.add(new Rei("preta"));
        peçasPretas.add(new Bispo("preta"));
        peçasPretas.add(new Cavalo("preta"));
        peçasPretas.add(new Torre("preta"));

        for (int i = 0; i < 8; i++) {
            peçasPretas.add(new Peão("branco"));
        }

        for (int i = 0; i < 8; i++) {
            tabuleiro.setPeça(0, i, peçasPretas.get(i));
            tabuleiro.setPeça(1, i, peçasPretas.get(i + 8));
        }

    }

    //public boolean jogadaValida(int linhaO, int colunaO, int linhaD, int colunaD){}
    //public void realizaJogada(int linhaO, int colunaO, int linhaD, int colunaD){}
    //public String registroJogo();
    public void iniciarJogo() {
        while (!jogoFinalizado) {
            System.out.println("Vez do jogador: " + jogadorAtual.getNome());
            System.out.println("Digite sua jogada ou salvar (para salvar e sair)");

            String entrada = ler.nextLine();

            if (entrada.equals("salvar")) {
                
                jogoFinalizado = true;
            } else {
                int linhaO = Character.getNumericValue(entrada.charAt(0))-1;
                int colunaO = entrada.charAt(1) - 'a';

                int linhaD = Character.getNumericValue(entrada.charAt(2))-1;
                int colunaD = entrada.charAt(3) - 'a';

                Jogada jogada = new Jogada(jogadorAtual, tabuleiro.getCasa(linhaO, colunaO), tabuleiro.getCasa(linhaD, colunaD));

                System.out.println(linhaO + " ");
                System.out.println(colunaO + " ");
                System.out.println(linhaD + " ");
                System.out.println(colunaD + " ");

                if (jogadorAtual.getNome().equals(jogador1.getNome())) {
                    jogadorAtual = jogador2;
                } else {
                    jogadorAtual = jogador1;
                }
            }

            /* 
            if (jogada.equals("salvar")) {
                //salvarJogo();
                return;
            } else {
                

                //Casa casaO = new Casa(jogada, 0, 0, jogoFinalizado, null)
                //Jogada jogada = new Jogada(jogadorAtual, linha, coluna)
           }
             */
        }
        System.err.println("Jogo finalizado");

    }
}

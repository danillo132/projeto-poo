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

        this.peçasPretas = new ArrayList<>();
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

        System.out.println("Insira do nome do jogador 1 - peças brancas");
        String nomeJogador1 = ler.nextLine();
        this.jogador1 = new Jogador(nomeJogador1, this.peçasBrancas);

        System.out.println("Insira do nome do jogador 2 - peças pretas");
        String nomeJogador2 = ler.nextLine();
        this.jogador2 = new Jogador(nomeJogador2, this.peçasPretas);

    }
    /* 
    public void iniciarJogo() {
        while (!jogoFinalizado) {
            System.out.println("Vez do jogador: " + jogadorAtual);
            System.out.println("Digite sua jogada ou salvar - para salvar e sair");
            String jogada = ler.nextLine();

            if (jogada.equals("salvar")) {
                salvarJogo();
                return;
            }

            if (ehValida(jogada)) {
                
            } else {
                System.out.println("Jogada inválida");
            }
        }
        System.err.println("Jogo finalizado");
    }
     */
}

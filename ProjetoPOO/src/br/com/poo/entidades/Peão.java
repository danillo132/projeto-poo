package br.com.poo.entidades;

public class Peão extends Peça {

	public Peão(String cor) {
		super("P", cor, true);
	}

	@Override
	public String desenho() {
		if (this.getCor().equals("preto"))
			return "\u001B[31m" + "P" + "\u001B[0m";
		else
			return "P";
	}

	@Override
	boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int difColuna = Math.abs(colunaO - colunaD);
		int difLinha = Math.abs(linhaO - linhaD);

		boolean movimentoNormal = (colunaO == colunaD) && (difLinha == 1 || (difLinha == 2 && linhaO == 2));

		boolean captura = (difColuna == 1 && difLinha == 1);

		boolean sentidoCorreto = (!getCor().equalsIgnoreCase("black") ? linhaO < linhaD : linhaO > linhaD);

		return (movimentoNormal || captura) && sentidoCorreto;
	}

	@Override
	String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
		if (this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
			StringBuilder caminho = new StringBuilder();
			caminho.append(linhaO).append(colunaO);
			caminho.append(linhaD).append(colunaD);
			return caminho.toString();
		}
		return "";
	}

}

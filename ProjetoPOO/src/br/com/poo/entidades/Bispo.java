package br.com.poo.entidades;

public class Bispo extends Peça {

	public Bispo(String cor) {
		super("B", cor, true);
	}

	@Override
	public String desenho() {
		if (this.getCor().equals("preto"))
			return "\u001B[31m" + "B" + "\u001B[0m";
		else
			return "B";
	}

	@Override
	boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);

		return diferencaColuna == diferencaLinha;
	}

	@Override
	String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
		if (this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
			StringBuilder caminho = new StringBuilder();
			int linhaAtual = linhaO;
			int colunaAtual = colunaO;

			// Converte coluna de char para int para facilitar o cálculo
			int colunaAtualInt = colunaAtual - 'a';
			int colunaDestinoInt = colunaD - 'a';

			while (linhaAtual != linhaD || colunaAtualInt != colunaDestinoInt) {
				caminho.append(linhaAtual).append((char) (colunaAtualInt + 'a'));

				if (linhaAtual < linhaD)
					linhaAtual++;
				else
					linhaAtual--;

				if (colunaAtualInt < colunaDestinoInt)
					colunaAtualInt++;
				else
					colunaAtualInt--;

				colunaAtual = (char) (colunaAtualInt + 'a');
			}

			caminho.append(linhaD).append(colunaD);

			return caminho.toString();
		} else {
			return "";
		}
	}

}

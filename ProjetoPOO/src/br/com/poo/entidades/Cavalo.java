package br.com.poo.entidades;

public class Cavalo extends Peça {

	public Cavalo(String cor) {
		super("C", cor, true);
	}

	@Override
	public String desenho() {
		if (this.getCor().equals("preto"))
			return "\u001B[31m" + "C" + "\u001B[0m";
		else
			return "C";
	}

	@Override
	boolean movimentoValido(int linhaO, char colunaO, int linhaD, char colunaD) {
		int diferencaColuna = Math.abs(colunaO - colunaD);
		int diferencaLinha = Math.abs(linhaO - linhaD);
		return (diferencaColuna == 2 && diferencaLinha == 1) || (diferencaColuna == 1 && diferencaLinha == 2);
	}

	@Override
	String caminho(int linhaO, char colunaO, int linhaD, char colunaD) {
		if (this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
			StringBuilder caminho = new StringBuilder();
			int diferencaColuna = Math.abs(colunaO - colunaD);
			int diferencaLinha = Math.abs(linhaO - linhaD);
			if (diferencaColuna == 2 && diferencaLinha == 1) {
				if (colunaO < colunaD) {

					int colunaAtual = colunaO;
					while(colunaAtual <= colunaD) {
						caminho.append(linhaO).append((char) colunaAtual);
						colunaAtual++;
					}
					if(linhaD > linhaO) {
						caminho.append(linhaO+1).append((char)(colunaAtual-1));
					}else if(linhaD < linhaO) {
						caminho.append(linhaO-1).append((char)(colunaAtual-1));
					}
				}

				if (colunaO > colunaD) {
					int colunaAtual = colunaO;
					while(colunaAtual >= colunaD) {
						caminho.append(linhaO).append((char) colunaAtual);
						colunaAtual--;
					}
					if(linhaD > linhaO) {
						caminho.append(linhaO+1).append((char)(colunaAtual+1));
					}else if(linhaD < linhaO) {
						caminho.append(linhaO-1).append((char)(colunaAtual+1));
					}
				}
				
				return caminho.toString();
			}

			if (diferencaColuna == 1 && diferencaLinha == 2) {
				if (linhaO < linhaD) {
					int linhaAtual = linhaO;
					while(linhaAtual <= linhaD) {
						caminho.append(linhaAtual).append(colunaO);
						linhaAtual++;
					}
					if(colunaD > colunaO) {
						caminho.append(linhaO+2).append((char)(colunaO+1));
					}else if(colunaD < colunaO) {
						caminho.append(linhaO+2).append((char)(colunaO-1));
					}
				}

				if (linhaO > linhaD) {
					int linhaAtual = linhaO;
					while(linhaAtual >= linhaD) {
						caminho.append(linhaAtual).append(colunaO);
						linhaAtual--;
					}
					if(colunaD > colunaO) {
						caminho.append(linhaO-2).append((char)(colunaD));
					}else if(colunaD < colunaO) {
						caminho.append(linhaO-2).append((char)(colunaD));
					}
				}
				return caminho.toString();
			}

		} else {
			return "";
		}
		return "";
	}

}

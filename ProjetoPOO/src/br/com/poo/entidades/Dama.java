package br.com.poo.entidades;

public class Dama extends Peça {

    public Dama(String cor) {
        super("D", cor, true);
    }

    @Override
    public String desenho(){
        if (this.getCor().equals("preto"))
            return "\u001B[31m" + "D" + "\u001B[0m";
        else
            return "D"; 
    }
    //abstract String desenho();
    //abstract boolean movimentoValido(int colunaO, char linhaO, int colunaD, char linhaD);
    //abstract String caminho(int colunaO, char linhaO, int colunaD, char linhaD); 

	@Override
	boolean movimentoValido( int linhaO, char colunaO, int  linhaD, char colunaD) {
		 int diferencaColuna = Math.abs(colunaO - colunaD);
	        int diferencaLinha = Math.abs(linhaO - linhaD);
	        return (diferencaColuna == diferencaLinha) || (diferencaColuna == 0) || (diferencaLinha == 0);
	}

	@Override
	String caminho( int linhaO, char colunaO, int  linhaD, char colunaD) {
	    if(this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            StringBuilder caminho = new StringBuilder();
            int diferencaColuna = Math.abs(colunaO - colunaD);
			int diferencaLinha = Math.abs(linhaO - linhaD);
         
            
            if(diferencaColuna == diferencaLinha) {
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
            }else {
            	   if (colunaO < colunaD) {
                       for (int i = colunaO; i <= colunaD; i++) {
                           caminho.append(linhaO).append((char)i);
                       }
                   } 
                   
                   if(linhaO < linhaD) {
                   	
                   	  for (int i = linhaO; i <= linhaD; i++) {
       	                    caminho.append(i).append(colunaO);
       	                }
       	            }
            }
            
            return caminho.toString();
        } else {
            return "";
        }
    }
}

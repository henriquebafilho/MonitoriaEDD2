package ABB;

import ABB.ArvoreBinariaBusca;

public class Main {

	public static void main(String[] args) {

		// Criando �rvore inicialmente vazia
		ArvoreBinariaBusca<Integer> arv = new ArvoreBinariaBusca<Integer>();
		
		arv.insere(2);
		arv.insere(3);
		arv.insere(1);

		arv.mostra();
	}

}

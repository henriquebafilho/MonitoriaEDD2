package ABB;

import ABB.ArvoreBinariaBusca;

public class Main {

	public static void main(String[] args) {

		// Criando árvore inicialmente vazia
		ArvoreBinariaBusca<Integer> arv = new ArvoreBinariaBusca<Integer>();
		
		arv.insere(20);
		arv.insere(10);
		arv.insere(30);
		arv.insere(7);
		arv.insere(11);
		arv.insere(35);

		arv.mostra();
	}

}

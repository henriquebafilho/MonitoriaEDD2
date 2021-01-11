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
		arv.insere(12);
		arv.insere(35);
		arv.insere(11);
		
		arv.delete(10);
		
		arv.mostra();
	}

}

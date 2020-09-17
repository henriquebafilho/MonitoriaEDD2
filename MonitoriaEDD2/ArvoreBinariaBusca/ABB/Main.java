package ABB;

import ABB.ArvoreBinariaBusca;

public class Main {

	public static void main(String[] args) {

		// Criando árvore inicialmente vazia
		ArvoreBinariaBusca<Integer> arv = new ArvoreBinariaBusca<Integer>();
		
//		arv.insere(2);
//		arv.insere(3);
//		arv.insere(1);
		
		arv.insere(30);
		arv.insere(20);
		arv.insere(22);
		arv.insere(10);
		arv.insere(13);

		arv.mostra();
		
		arv.busca(19);
	}

}

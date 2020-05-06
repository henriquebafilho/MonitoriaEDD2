package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		
		arv.insere(30);
		arv.insere(10);
		arv.insere(35);
		arv.insere(20);
		arv.insere(11);
		arv.insere(7);
		arv.insere(25);
		
		arv.rotacaoDuplaDireita(arv.getRaiz());
		
		arv.mostra();

		// Mostra altura a partir da raiz
		System.out.println("\nAltura da árvore: " + arv.calculaAltura(arv.getRaiz()));
		System.out.println("Número mínimo de nós: " + arv.calculaNumeroMinimoNos(arv.getRaiz()));

	}

}

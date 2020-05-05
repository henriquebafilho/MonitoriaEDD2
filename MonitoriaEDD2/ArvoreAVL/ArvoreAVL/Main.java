package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		
		arv.insere(10);
		arv.insere(20);
		arv.insere(30);
		arv.insere(13);
		arv.insere(22);
		
		arv.rotacaoEsquerda(arv.getRaiz());
		
		arv.mostra();

		// Mostra altura a partir da raiz
		System.out.println("\nAltura da �rvore: " + arv.calculaAltura(arv.getRaiz()));
		System.out.println("N�mero m�nimo de n�s: " + arv.calculaNumeroMinimoNos(arv.getRaiz()));

	}

}

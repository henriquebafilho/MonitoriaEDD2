package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();

		arv.insere(8);
		arv.insere(4);
		arv.insere(12);
		arv.insere(2);
		arv.insere(6);
		arv.insere(10);
		arv.insere(14);
		arv.insere(1);
		arv.insere(3);
		arv.insere(5);
		arv.insere(7);
		arv.insere(9);
		arv.insere(11);
		arv.insere(13);
		
		arv.mostra();

		// Mostra altura a partir da raiz
		System.out.println("\nAltura da �rvore: " + arv.calculaAltura(arv.getRaiz()));
		System.out.println("N�mero m�nimo de n�s: " + arv.calculaNumeroMinimoNos(arv.getRaiz()));

	}

}

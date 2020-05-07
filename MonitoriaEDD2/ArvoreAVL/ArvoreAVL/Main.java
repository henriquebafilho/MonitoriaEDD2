package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		
		
		arv.insere(30);
		arv.insere(10);
		arv.insere(35);
		arv.insere(7);
		arv.insere(20);
		arv.insere(25);
		arv.insere(11);
		
		arv.mostra();

		System.out.println("\nChave da raiz: " + arv.getChaveRaiz());
		System.out.println("Altura da árvore: " + arv.calculaAltura(arv.getRaiz()));
		
		arv.balancear(arv.getRaiz());
	}

}

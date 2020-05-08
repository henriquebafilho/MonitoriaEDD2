package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		
		
		arv.insere(15);
		arv.insere(8);
		arv.insere(23);
		arv.insere(2);
		arv.insere(12);
		arv.insere(20);
		arv.insere(18);
		
		arv.mostra();
		
		System.out.println("\nChave da raiz: " + arv.getChaveRaiz());
		System.out.println("Altura da árvore: " + arv.calculaAltura(arv.getRaiz()));
		
		System.out.println("");
		
		arv.balancear(arv.getRaiz());
		
		arv.mostra();
	}

}

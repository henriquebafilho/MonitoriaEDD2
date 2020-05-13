package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();

		// Rotação direita

//		arv.insere(30);
//		arv.insere(20);
//		arv.insere(22);
//		arv.insere(10);
//		arv.insere(13);

//		arv.insere(27);
//		arv.insere(15);
//		arv.insere(49);
//		arv.insere(10);
//		arv.insere(8);
		
//		arv.insere(9);
//		arv.insere(8);

		// Rotação esquerda

//		arv.insere(10);
//		arv.insere(20);
//		arv.insere(30);
//		arv.insere(13);
//		arv.insere(22);

//		arv.insere(10);
//		arv.insere(8);
//		arv.insere(15);
//		arv.insere(27);
//		arv.insere(49);
		
//		arv.insere(8);
//		arv.insere(9);

		// Rotação Dupla Esquerda

//		arv.insere(10);
//		arv.insere(7);
//		arv.insere(30);
//		arv.insere(35);
//		arv.insere(20);
//		arv.insere(11);
//		arv.insere(25);

		// Rotação Dupla Direita

//		arv.insere(30);
//		arv.insere(10);
//		arv.insere(35);
//		arv.insere(7);
//		arv.insere(20);
//		arv.insere(11);
//		arv.insere(25);

		arv.mostra();

		System.out.println("\nChave da raiz: " + arv.getChaveRaiz());
		System.out.println("Altura da árvore: " + arv.calculaAltura(arv.getRaiz()));

		System.out.println("");

		// arv.balancear(arv.getRaiz());

		// arv.rotacaoDireita(arv.getRaiz());

		// arv.rotacaoEsquerda(arv.getRaiz());

		arv.mostra();
	}

}

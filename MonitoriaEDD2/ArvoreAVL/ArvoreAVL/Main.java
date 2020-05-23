package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();

		// �rvores Balanceadas

//		arv.insere(8);
//		arv.insere(9);

		// Rota��o direita

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

		// Rota��o esquerda

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

		// Rota��o Dupla Esquerda

//		arv.insere(10);
//		arv.insere(7);
//		arv.insere(30);
//		arv.insere(35);
//		arv.insere(20);
//		arv.insere(11);
//		arv.insere(25);

		// Rota��o Dupla Direita

//		arv.insere(30);
//		arv.insere(10);
//		arv.insere(35);
//		arv.insere(7);
//		arv.insere(20);
//		arv.insere(11);
//		arv.insere(25);

		// Desregulada aleat�ria
		
//		arv.insere(5);
//		arv.insere(6);
//		arv.insere(7);
//		arv.insere(8);
//		arv.insere(9);
//		arv.insere(10);
		
//		arv.insere(10);
//		arv.insere(9);
//		arv.insere(8);
//		arv.insere(7);
//		arv.insere(6);
//		arv.insere(5);

		System.out.println("Raiz: " + arv.getChaveRaiz());
		System.out.println("Altura da �rvore: " + arv.calculaAltura(arv.getRaiz()));

		System.out.println("");

		arv.balancear(arv.getRaiz());

		// arv.rotacaoDireita(arv.getRaiz());

		// arv.rotacaoDireita(arv.getRaizEsquerda(), arv.getRaiz());

		// arv.rotacaoEsquerda(arv.getRaizDireita(), arv.getRaiz());

		// arv.rotacaoEsquerda(arv.getRaiz());

		// System.out.println(arv.busca(27));
	}

}

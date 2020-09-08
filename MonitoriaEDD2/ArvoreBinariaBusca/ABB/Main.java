package ABB;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		
		// Criando uma árvore com o nó 5 como raiz
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		

		// Árvores Balanceadas

//		arv.insere(8);
//		arv.insere(9);

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

		// Rotação Dupla Esquerda

		arv.insere(10);
		arv.insere(7);
		arv.insere(30);
		arv.insere(35);
		arv.insere(20);
		arv.insere(11);
		arv.insere(25);

		// Rotação Dupla Direita

//		arv.insere(30);
//		arv.insere(10);
//		arv.insere(35);
//		arv.insere(7);
//		arv.insere(20);
//		arv.insere(11);
//		arv.insere(25);

		// Desregulada aleatória

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

		// arv.busca(7);

		arv.balancear();
	}

}

package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>();
		
		
		
		//Rota��o direita
		/*
		arv.insere(30);
		arv.insere(20);
		arv.insere(22);
		arv.insere(10);
		arv.insere(13);
		*/
		
		//Rota��o esquerda
		/*
		arv.insere(10);
		arv.insere(20);
		arv.insere(30);
		arv.insere(13);
		arv.insere(22);
		*/
		
		//Rota��o Dupla Esquerda
		arv.insere(10);
		arv.insere(7);
		arv.insere(30);
		arv.insere(35);
		arv.insere(20);
		arv.insere(11);
		arv.insere(25);
		
		//Rota��o Dupla Direita
		/*
		arv.insere(30);
		arv.insere(10);
		arv.insere(35);
		arv.insere(7);
		arv.insere(20);
		arv.insere(11);
		arv.insere(25);
		*/
		
		arv.mostra();
		
		System.out.println("\nChave da raiz: " + arv.getChaveRaiz());
		System.out.println("Altura da �rvore: " + arv.calculaAltura(arv.getRaiz()));
		
		System.out.println("");
		
		arv.balancear(arv.getRaiz());
		
		arv.mostra();
	}

}

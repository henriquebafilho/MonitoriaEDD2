package ArvoreAVL;

import ArvoreAVL.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		ArvoreAVL<Integer> arv = new ArvoreAVL<Integer>(2);
		
		arv.insere(1);
		arv.insere(3);
		
		arv.mostra();

	}

}

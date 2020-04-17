package ArvoreBinaria;

import ArvoreBinariaBusca.ArvBinBusca;

public class Main {
	public static void main(String[] args) {
		Arvbin<Integer> a1 = new Arvbin<Integer>(1), 
				a2 = new Arvbin<Integer>(2), 
				a3 = new Arvbin<Integer>(3, a1, a2),
				a4 = new Arvbin<Integer>(4), 
				a5 = new Arvbin<Integer>(5), 
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(7, a5, a6), 
				a8 = new Arvbin<Integer>(8), 
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10, a8, a9);

		
		a3.mostra();
	}
}

package GrafoGenerico;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do v�rtice
	public ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de v�rtices adjacentes

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o v�rtice que for inserido
	}

	public void mostraAdjacentes() {
		// Caso n�o tenha adjacentes
		if (adjacentes.size() == 0) {
			System.out.println("O v�rtice n�o possui v�rtices adjacentes");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.print(adjacentes.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}
}

package GrafoGenerico;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do vértice
	public ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de vértices adjacentes

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o vértice que for inserido
	}

	// Liga o vértice atual ao do parâmetro
	public void liga(Vertice v) {
		// Ligação recíproca
		this.adjacentes.add(v);
		v.adjacentes.add(this);
	}

	// Mostra todos os vértices adjacentes ao atual
	public void mostraAdjacentes() {
		// Caso não tenha adjacentes
		if (adjacentes.size() == 0) {
			System.out.println("O vértice não possui vértices adjacentes");
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

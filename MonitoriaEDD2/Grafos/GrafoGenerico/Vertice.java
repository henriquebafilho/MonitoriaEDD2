package GrafoGenerico;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do vértice
	public ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de vértices adjacentes

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o vértice que for inserido
	}

	// Retorna o grau do vértice
	public int getGrau() {
		return adjacentes.size();
	}

	// Liga o vértice atual ao do parâmetro
	public void liga(Vertice v) {
		// Caso os vértices possuam as mesmas chaves
		if (this.chave == v.chave) {
			System.out.println("Um vértice não pode se ligar a ele mesmo");
			return;
		}

		// Checa se os vértices já estão ligados
		for (int i = 0; i < adjacentes.size(); i++) {
			if (v.chave == adjacentes.get(i).chave) {
				System.out.println("Os vértices já estão ligados");
				return;
			}
		}

		// Ligação recíproca
		this.adjacentes.add(v);
		v.adjacentes.add(this);
	}

	// Checa se o vértice está no grafo
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < adjacentes.size(); i++) {
			if (v.chave == adjacentes.get(i).chave) {
				return true;
			}
		}
		return false;
	}

	// Mostra todos os vértices adjacentes ao atual
	public void mostraAdjacentes() {
		// Caso não tenha adjacentes
		if (adjacentes.size() == 0) {
			System.out.println(this.chave + " não possui vértices adjacentes");
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

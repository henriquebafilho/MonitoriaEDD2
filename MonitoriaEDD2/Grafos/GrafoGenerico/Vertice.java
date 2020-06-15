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

	public boolean atinge(Vertice v) {
		boolean atingiu = false;

		// Se v está nos adjacentes do atual ou é igual ao que chamou a função
		if (this.contemAdjacente(v) || this.chave == v.chave) {
			return true;
		}

		// Variável que armazenará os vértices checados
		ArrayList<Vertice> checados = new ArrayList<Vertice>();

		// adiciona o atual aos já checados
		checados.add(this);

		System.out.println(this.chave + ": ");
		this.mostraAdjacentes();

		for (int i = 0; i < this.adjacentes.size(); i++) {
			if (!checados.contains(adjacentes.get(i))) {
				checados.add(adjacentes.get(i));
				return atinge(adjacentes.get(i), v, checados);
			}
		}
		System.out.println();
		return atingiu;
	}

	private boolean atinge(Vertice atual, Vertice v, ArrayList<Vertice> checados) {
		boolean atingiu = false;

		System.out.print(atual.chave + ": ");
		atual.mostraAdjacentes();

		// Se o vértice atual contém v nos adjacentes, retorna verdadeiro
		if (atual.contemAdjacente(v)) {
			return true;
		}
		// se não, checa nos seus adjacentes
		for (int i = 0; i < atual.adjacentes.size(); i++) {
			if (!checados.contains(atual.adjacentes.get(i))) {
				checados.add(atual.adjacentes.get(i));
				atingiu = atinge(atual.adjacentes.get(i), v, checados);
			}
		}
		return atingiu;
	}

	// Checa se o vértice está no grafo
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.println("procurado: " + v.chave);
			System.out.println("atual: " + adjacentes.get(i).chave);
			if (adjacentes.get(i).chave == v.chave) {
				System.out.println("ACHOU");
				return true;
			}
			System.out.println();
		}
		return false;
	}

	// Mostra todos os vértices adjacentes ao atual
	public void mostraAdjacentes() {
		// Caso não tenha adjacentes
		if (this.adjacentes.size() == 0) {
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

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

	// Checa se o vértice que chamou a função atinge o do parâmetro
	public boolean atinge(Vertice v) {
		// Se v está nos adjacentes do atual ou é igual ao que chamou a função
		if (this.chave == v.chave || this.contemAdjacente(v)) {
			return true;
		}

		// Variável que armazenará os vértices checados
		ArrayList<Vertice> checados = new ArrayList<Vertice>();

		// adiciona o atual + seus adjacentes aos já checados
		checados.add(this);

		// Mostra os checados
		for (int i = 0; i < checados.size(); i++) {
			System.out.print(checados.get(i).chave + " ");
		}
		System.out.println();

		return atinge(this.adjacentes.get(0), v, checados);
	}

	private boolean atinge(Vertice atual, Vertice procurado, ArrayList<Vertice> checados) {
		boolean atingiu = false;

		atual.mostraAdjacentes();
		
		if (atual.contemAdjacente(procurado) || atual.chave == procurado.chave) {
			return true;
		}

		// adiciona o atual aos já checados
		checados.add(atual);

		// Mostra os checados
		for (int i = 0; i < checados.size(); i++) {
			System.out.print(checados.get(i).chave + " ");
		}
		System.out.println();
		 
		for (int i = 0; i < atual.adjacentes.size(); i++) {
			if (!checados.contains(atual.adjacentes.get(i))) {
				atingiu = atinge(atual.adjacentes.get(i), procurado, checados);
			}
		}
		System.out.println();
		return atingiu;
	}

	// Checa se o vértice está no grafo
	public boolean contemAdjacente(Vertice v) {
		System.out.println("------------");
		System.out.println(this.chave);
		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.println("atual: " + adjacentes.get(i).chave);
			System.out.println("procurado: " + v.chave);
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

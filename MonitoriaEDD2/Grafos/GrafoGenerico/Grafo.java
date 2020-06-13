// Declaração de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de vértices do grafo

	private class Vertice {
		private int chave; // Chave do vértice
		private ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de vértices adjacentes

		public Vertice(int chave) {
			this.chave = chave; // Atribuindo o vértice que for inserido
			this.adjacentes = null; // Conjunto de adjacentes inicialmente vazio
		}

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

//	// Mostrando os vértices por Lista de Adjacência
//	public void mostraLA() {
//		// Caso não tenha vértices no grafo
//		if(vertices.size() == 0) {
//			System.out.println("O grafo não possui vértices");
//			return;
//		}
//		
//		for(int i = 0; i < vertices.size(); i++) {
//			vertices.get(i).mostraAdjacentes();
//		}
//		
//	}

	// Mostra os vértices do grafo
	public void mostraVertices() {
		System.out.print("Vértices: ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();
	}

	// Insere vértice no grafo
	public void insere(int chave) {
		Vertice v = new Vertice(chave);

		vertices.add(v);
	}

}

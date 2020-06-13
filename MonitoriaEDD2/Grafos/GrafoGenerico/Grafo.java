// Declaração de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> vertices; // Conjunto de vértices do grafo

	private class Vertice {
		private int chave; // Chave do vértice
		private ArrayList<Vertice> adjacentes; // Conjunto de vértices adjacentes

		public Vertice(int chave) {
			this.chave = chave; // Atribuindo o vértice que for inserido
			this.adjacentes = null; // Conjunto de adjacentes inicialmente vazio
		}
	}

	// Grafo inicialmente vazio
	public Grafo() {
		vertices = null;
	}
	
	

}

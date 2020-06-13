// Declara��o de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> vertices; // Conjunto de v�rtices do grafo

	private class Vertice {
		private int chave; // Chave do v�rtice
		private ArrayList<Vertice> adjacentes; // Conjunto de v�rtices adjacentes

		public Vertice(int chave) {
			this.chave = chave; // Atribuindo o v�rtice que for inserido
			this.adjacentes = null; // Conjunto de adjacentes inicialmente vazio
		}
	}

	// Grafo inicialmente vazio
	public Grafo() {
		vertices = null;
	}
	
	

}

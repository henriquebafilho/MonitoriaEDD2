// Declara��o de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de v�rtices do grafo

	private class Vertice {
		private int chave; // Chave do v�rtice
		private ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de v�rtices adjacentes

		public Vertice(int chave) {
			this.chave = chave; // Atribuindo o v�rtice que for inserido
			this.adjacentes = null; // Conjunto de adjacentes inicialmente vazio
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

//	// Mostrando os v�rtices por Lista de Adjac�ncia
//	public void mostraLA() {
//		// Caso n�o tenha v�rtices no grafo
//		if(vertices.size() == 0) {
//			System.out.println("O grafo n�o possui v�rtices");
//			return;
//		}
//		
//		for(int i = 0; i < vertices.size(); i++) {
//			vertices.get(i).mostraAdjacentes();
//		}
//		
//	}

	// Mostra os v�rtices do grafo
	public void mostraVertices() {
		System.out.print("V�rtices: ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();
	}

	// Insere v�rtice no grafo
	public void insere(int chave) {
		Vertice v = new Vertice(chave);

		vertices.add(v);
	}

}

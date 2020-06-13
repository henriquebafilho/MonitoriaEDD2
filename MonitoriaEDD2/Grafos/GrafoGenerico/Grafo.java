// Declaração de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de vértices do grafo

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
	
	// Adiciona o vértice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

}

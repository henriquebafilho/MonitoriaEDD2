// Declaração de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de vértices do grafo

	// Mostrando os vértices por Lista de Adjacência
	public void mostraLA() {
		System.out.println("LISTA DE ADJACÊNCIA");
		// Caso não tenha vértices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo não possui vértices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraAdjacentes();
		}
		System.out.println();
	}

	// Mostrando os vértices por Matriz de Adjacência
	public void mostraMA() {
		System.out.println("MATRIZ DE ADJACÊNCIA");
		System.out.print("   ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + ": ");
			for (int j = 0; j < vertices.size(); j++) {
				// Boolean que controla se o vértice foi encontrado nos adjacentes do vértice i atual
				boolean encontrou = false;
				for (int k = 0; k < vertices.get(i).adjacentes.size(); k++) {
					// Se encontrou, printa 1 e vai para a próxima testagem
					if (vertices.get(j).chave == vertices.get(i).adjacentes.get(k).chave) {
						System.out.print("1 ");
						encontrou = true;
						break;
					}
				}
				if(encontrou == false) {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	// Mostra os vértices do grafo
	public void mostraVertices() {
		System.out.print("Vértices: ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();
		System.out.println();
	}

	// Adiciona o vértice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

}

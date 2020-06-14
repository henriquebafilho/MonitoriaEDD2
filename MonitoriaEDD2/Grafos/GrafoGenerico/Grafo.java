// Declara��o de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de v�rtices do grafo

	// Mostrando os v�rtices por Lista de Adjac�ncia
	public void mostraLA() {
		System.out.println("LISTA DE ADJAC�NCIA");
		// Caso n�o tenha v�rtices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo n�o possui v�rtices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraAdjacentes();
		}
		System.out.println();
	}

	// Mostrando os v�rtices por Matriz de Adjac�ncia
	public void mostraMA() {
		System.out.println("MATRIZ DE ADJAC�NCIA");
		System.out.print("   ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + ": ");
			for (int j = 0; j < vertices.size(); j++) {
				// Boolean que controla se o v�rtice foi encontrado nos adjacentes do v�rtice i atual
				boolean encontrou = false;
				for (int k = 0; k < vertices.get(i).adjacentes.size(); k++) {
					// Se encontrou, printa 1 e vai para a pr�xima testagem
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

	// Mostra os v�rtices do grafo
	public void mostraVertices() {
		System.out.print("V�rtices: ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();
		System.out.println();
	}

	// Adiciona o v�rtice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

}

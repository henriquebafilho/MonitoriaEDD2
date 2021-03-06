// Declara��o de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de v�rtices do grafo

	// Adiciona o v�rtice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

	// Checa se o grafo � regular (todos os v�rtices possuem o mesmo grau)
	public boolean regular() {
		int grau = 0;
		boolean regular = true;

		for (int i = 0; i < vertices.size(); i++) {
			// Na primeira passagem, armazena o valor do grau
			if (i == 0) {
				grau = vertices.get(i).getGrau();
			} else if (vertices.get(i).getGrau() != grau) {
				return false;
			}
		}
		return regular;
	}

	// Checa se o grafo � nulo (n�o possui arestas)
	public boolean nulo() {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getGrau() != 0) {
				return false;
			}
		}
		return true;
	}

	// Checa se o grafo � completo (regular de grau n-1, onde n = |v|)
	public boolean completo() {
		if (this.regular() && (vertices.get(0).getGrau() == vertices.size() - 1)) {
			return true;
		}
		return false;
	}

	// Checa se o grafo � conexo
	public boolean conexo() {
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (!vertices.get(i).alcanca(vertices.get(j))) {
					return false;
				}
			}
		}
		return true;
	}

	// Fun��o recursiva para inserir em 'percorridos' o v�rtice e seus adjacentes
	private void inserePercorridos(Vertice vertice, ArrayList<Vertice> percorridos) {

		if (!percorridos.contains(vertice)) {
			percorridos.add(vertice);
		}

		// Adiciona os adjacentes do atual (caso n�o estejam nos percorridos)
		for (int i = 0; i < vertice.adjacentes.size(); i++) {
			Vertice atual = vertice.adjacentes.get(i);

			if (!percorridos.contains(vertice.adjacentes.get(i))) {
				percorridos.add(atual);
				inserePercorridos(atual, percorridos);
			}
		}
	}

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
				// Boolean que controla se o v�rtice foi encontrado nos adjacentes do v�rtice i
				// atual
				boolean encontrou = false;
				for (int k = 0; k < vertices.get(i).adjacentes.size(); k++) {
					// Se encontrou, printa 1 e vai para a pr�xima testagem
					if (vertices.get(j).chave == vertices.get(i).adjacentes.get(k).chave) {
						System.out.print("1 ");
						encontrou = true;
						break;
					}
				}
				// Caso n�o tenha encontrado, printa 0
				if (encontrou == false) {
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
}

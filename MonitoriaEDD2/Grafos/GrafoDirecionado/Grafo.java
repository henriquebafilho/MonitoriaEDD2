package GrafoDirecionado;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de vértices do grafo

	// Adiciona o vértice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

	// Checa se o grafo é regular (todos os vértices possuem o mesmo grau)
	public boolean regular() {
		int grau = 0;
		boolean regular = true;

		for (int i = 0; i < vertices.size(); i++) {
			// Na primeira passagem, armazena o valor do grau
			if (i == 0) {
				grau = vertices.get(i).getGrauSaida();
			} else if (vertices.get(i).getGrauSaida() != grau) {
				return false;
			}
		}
		return regular;
	}

	// Checa se o grafo é nulo (não possui arestas)
	public boolean nulo() {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getGrauSaida() != 0) {
				return false;
			}
		}
		return true;
	}

	// Checa se o grafo é completo (regular de grau n-1, onde n = |v|)
	public boolean completo() {
		if (this.regular() && (vertices.get(0).getGrauSaida() == vertices.size() - 1)) {
			return true;
		}
		return false;
	}

	// Checa se o grafo é conexo (contém 1 vértice que alcance todos os outros)
	/*
	 * Utilizando o arraylist 'vertices', são adicionados à 'percorridos' todos os
	 * vértices e adjacentes encontrados a partir do primeiro elemento. Se o número
	 * de 'percorridos' for igual ao de 'vertices', significa que ele percorreu todo
	 * o grafo, ou seja, o grafo é conexo. Caso contrário, há pelo menos um vértice
	 * que não foi alcançado, logo o grafo não é conexo.
	 */
	public boolean conexo() {
		ArrayList<Vertice> percorridos = new ArrayList<Vertice>();
		Vertice v0 = vertices.get(0);

		// Percorre os vértices e seus adjacentes
		inserePercorridos(v0, percorridos);

		// Se o 'percorridos' não tem o mesmo tamanho que 'vertices', não é conexo
		if (percorridos.size() != vertices.size()) {
			return false;
		}

		/*
		 * Percorre o 'percorridos' e compara com 'vertices' do grafo. Se todos do
		 * 'percorridos' estiverem no 'vertices', o grafo é conexo
		 */
		for (int i = 0; i < percorridos.size(); i++) {
			boolean encontrou = false;
			for (int j = 0; j < vertices.size(); j++) {
				if (percorridos.get(i).chave == vertices.get(j).chave) {
					encontrou = true;
				}
			}
			// Se não encontrou, o grafo não é conexo
			if (encontrou = false) {
				return false;
			}
		}
		return true;
	}

	// Função recursiva para inserir em 'percorridos' o vértice e seus adjacentes
	private void inserePercorridos(Vertice vertice, ArrayList<Vertice> percorridos) {
		// Se o atual não está no 'percorridos', insere ele
		if (!percorridos.contains(vertice)) {
			percorridos.add(vertice);
		}

		// Adiciona os adjacentes do atual (caso não estejam nos percorridos)
		for (int i = 0; i < vertice.saida.size(); i++) {
			Vertice atual = vertice.saida.get(i);

			if (!percorridos.contains(vertice.saida.get(i))) {
				percorridos.add(atual);
				inserePercorridos(atual, percorridos);
			}
		}
	}

	// Mostrando os vértices de saída por Lista de Adjacência
	public void mostraLASaida() {
		System.out.println("LISTA DE ADJACÊNCIA (SAÍDA)");
		// Caso não tenha vértices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo não possui vértices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraSaida();
		}
		System.out.println();
	}

	// Mostrando os vértices de saída por Matriz de Adjacência
	public void mostraMASaida() {
		System.out.println("MATRIZ DE ADJACÊNCIA (SAÍDA)");
		System.out.print("   ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + ": ");
			for (int j = 0; j < vertices.size(); j++) {
				// Boolean que controla se o vértice foi encontrado nos adjacentes do vértice i
				// atual
				boolean encontrou = false;
				for (int k = 0; k < vertices.get(i).saida.size(); k++) {
					// Se encontrou, printa 1 e vai para a próxima testagem
					if (vertices.get(j).chave == vertices.get(i).saida.get(k).chave) {
						System.out.print("1 ");
						encontrou = true;
						break;
					}
				}
				// Caso não tenha encontrado, printa 0
				if (encontrou == false) {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	// Mostrando os vértices de entrada por Lista de Adjacência
	public void mostraLAEntrada() {
		System.out.println("LISTA DE ADJACÊNCIA (ENTRADA)");
		// Caso não tenha vértices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo não possui vértices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraEntrada();
		}
		System.out.println();
	}

	// Mostrando os vértices de entrada por Matriz de Adjacência
	public void mostraMAEntrada() {
		System.out.println("MATRIZ DE ADJACÊNCIA (ENTRADA)");
		System.out.print("   ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + ": ");
			for (int j = 0; j < vertices.size(); j++) {
				// Boolean que controla se o vértice foi encontrado nos adjacentes do vértice i
				// atual
				boolean encontrou = false;
				for (int k = 0; k < vertices.get(i).entrada.size(); k++) {
					// Se encontrou, printa 1 e vai para a próxima testagem
					if (vertices.get(j).chave == vertices.get(i).entrada.get(k).chave) {
						System.out.print("1 ");
						encontrou = true;
						break;
					}
				}
				// Caso não tenha encontrado, printa 0
				if (encontrou == false) {
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
}

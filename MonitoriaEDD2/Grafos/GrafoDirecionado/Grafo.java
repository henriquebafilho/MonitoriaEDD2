package GrafoDirecionado;

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
				grau = vertices.get(i).getGrauSaida();
			} else if (vertices.get(i).getGrauSaida() != grau) {
				return false;
			}
		}
		return regular;
	}

	// Checa se o grafo � nulo (n�o possui arestas)
	public boolean nulo() {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getGrauSaida() != 0) {
				return false;
			}
		}
		return true;
	}

	// Checa se o grafo � completo (regular de grau n-1, onde n = |v|)
	public boolean completo() {
		if (this.regular() && (vertices.get(0).getGrauSaida() == vertices.size() - 1)) {
			return true;
		}
		return false;
	}

	// Checa se o grafo � conexo (cont�m 1 v�rtice que alcance todos os outros)
	/*
	 * Utilizando o arraylist 'vertices', s�o adicionados � 'percorridos' todos os
	 * v�rtices e adjacentes encontrados a partir do primeiro elemento. Se o n�mero
	 * de 'percorridos' for igual ao de 'vertices', significa que ele percorreu todo
	 * o grafo, ou seja, o grafo � conexo. Caso contr�rio, h� pelo menos um v�rtice
	 * que n�o foi alcan�ado, logo o grafo n�o � conexo.
	 */
	public boolean conexo() {
		ArrayList<Vertice> percorridos = new ArrayList<Vertice>();
		Vertice v0 = vertices.get(0);

		// Percorre os v�rtices e seus adjacentes
		inserePercorridos(v0, percorridos);

		// Se o 'percorridos' n�o tem o mesmo tamanho que 'vertices', n�o � conexo
		if (percorridos.size() != vertices.size()) {
			return false;
		}

		/*
		 * Percorre o 'percorridos' e compara com 'vertices' do grafo. Se todos do
		 * 'percorridos' estiverem no 'vertices', o grafo � conexo
		 */
		for (int i = 0; i < percorridos.size(); i++) {
			boolean encontrou = false;
			for (int j = 0; j < vertices.size(); j++) {
				if (percorridos.get(i).chave == vertices.get(j).chave) {
					encontrou = true;
				}
			}
			// Se n�o encontrou, o grafo n�o � conexo
			if (encontrou = false) {
				return false;
			}
		}
		return true;
	}

	// Fun��o recursiva para inserir em 'percorridos' o v�rtice e seus adjacentes
	private void inserePercorridos(Vertice vertice, ArrayList<Vertice> percorridos) {
		// Se o atual n�o est� no 'percorridos', insere ele
		if (!percorridos.contains(vertice)) {
			percorridos.add(vertice);
		}

		// Adiciona os adjacentes do atual (caso n�o estejam nos percorridos)
		for (int i = 0; i < vertice.saida.size(); i++) {
			Vertice atual = vertice.saida.get(i);

			if (!percorridos.contains(vertice.saida.get(i))) {
				percorridos.add(atual);
				inserePercorridos(atual, percorridos);
			}
		}
	}

	// Mostrando os v�rtices de sa�da por Lista de Adjac�ncia
	public void mostraLASaida() {
		System.out.println("LISTA DE ADJAC�NCIA (SA�DA)");
		// Caso n�o tenha v�rtices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo n�o possui v�rtices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraSaida();
		}
		System.out.println();
	}

	// Mostrando os v�rtices de sa�da por Matriz de Adjac�ncia
	public void mostraMASaida() {
		System.out.println("MATRIZ DE ADJAC�NCIA (SA�DA)");
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
				for (int k = 0; k < vertices.get(i).saida.size(); k++) {
					// Se encontrou, printa 1 e vai para a pr�xima testagem
					if (vertices.get(j).chave == vertices.get(i).saida.get(k).chave) {
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

	// Mostrando os v�rtices de entrada por Lista de Adjac�ncia
	public void mostraLAEntrada() {
		System.out.println("LISTA DE ADJAC�NCIA (ENTRADA)");
		// Caso n�o tenha v�rtices no grafo
		if (vertices.size() == 0) {
			System.out.println("O grafo n�o possui v�rtices");
			return;
		}

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).mostraEntrada();
		}
		System.out.println();
	}

	// Mostrando os v�rtices de entrada por Matriz de Adjac�ncia
	public void mostraMAEntrada() {
		System.out.println("MATRIZ DE ADJAC�NCIA (ENTRADA)");
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
				for (int k = 0; k < vertices.get(i).entrada.size(); k++) {
					// Se encontrou, printa 1 e vai para a pr�xima testagem
					if (vertices.get(j).chave == vertices.get(i).entrada.get(k).chave) {
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

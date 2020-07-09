package GrafoGenerico;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do vértice
	public ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de vértices adjacentes

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o vértice que for inserido
	}

	// Retorna o grau do vértice
	public int getGrau() {
		return adjacentes.size();
	}

	// Liga o vértice atual ao do parâmetro
	public void liga(Vertice v) {
		// Caso os vértices possuam as mesmas chaves
		if (this.chave == v.chave) {
			System.out.println("Um vértice não pode se ligar a ele mesmo");
			return;
		}

		// Checa se os vértices já estão ligados
		for (int i = 0; i < adjacentes.size(); i++) {
			if (v.chave == adjacentes.get(i).chave) {
				System.out.println("Os vértices já estão ligados");
				return;
			}
		}

		// Ligação recíproca
		this.adjacentes.add(v);
		v.adjacentes.add(this);
	}

	// Checa se o vértice está no grafo
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < adjacentes.size(); i++) {
			if (adjacentes.get(i).chave == v.chave) {
				return true;
			}
		}
		return false;
	}

	// Mostra todos os vértices adjacentes ao atual
	public void mostraAdjacentes() {
		// Caso não tenha adjacentes
		if (this.adjacentes.size() == 0) {
			System.out.println(this.chave + " não possui vértices adjacentes");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.print(adjacentes.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}

	public boolean alcanca(Vertice v) {
		// Se o v está nos adjacentes do vértice que chamou a função ou é igual a ele
		if (this.contemAdjacente(v) || (this.chave == v.chave)) {
			return true;
		}

		// adiciona a 'alcancaveis' todos os nós que v pode atingir
		ArrayList<Vertice> alcancaveis = new ArrayList<Vertice>();
		insereAlcancaveis(this, alcancaveis);

		mostraArrayListVertices(alcancaveis);

		if (alcancaveis.contains(v)) {
			return true;
		}
		return false;
	}

	// Função recursiva para inserir em 'alcancaveis' o vértice e seus adjacentes
	private void insereAlcancaveis(Vertice vertice, ArrayList<Vertice> alcancaveis) {
		// Se o atual não está no 'alcacaveis', insere ele
		if (!alcancaveis.contains(vertice)) {
			alcancaveis.add(vertice);
		}

		// Adiciona os adjacentes do atual (caso não estejam nos percorridos)
		for (int i = 0; i < vertice.adjacentes.size(); i++) {
			Vertice atual = vertice.adjacentes.get(i);

			if (!alcancaveis.contains(atual)) {
				alcancaveis.add(atual);

				// Chama a função para fazer o mesmo procedimento com os adjacentes
				insereAlcancaveis(atual, alcancaveis);
			}
		}
	}

	public void mostraArrayListVertices(ArrayList<Vertice> arraylist) {
		System.out.print("[");
		for (int i = 0; i < arraylist.size(); i++) {
			Vertice atual = arraylist.get(i);
			System.out.print(atual.chave + " ");
		}
		System.out.print("]");
		System.out.println();
	}
}

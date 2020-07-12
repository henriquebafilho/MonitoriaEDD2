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

	// Checa se o vértice que chamou a função alcança o do parâmetro
	public boolean alcanca(Vertice v) {
		boolean alcanca = false;
		
		// Se o v está nos adjacentes do vértice que chamou a função ou é igual a ele
		if (this.contemAdjacente(v) || (this.chave == v.chave)) {
			return true;
		}

		// adiciona a 'alcancaveis' todos os nós que v pode atingir
		ArrayList<Vertice> alcancaveis = new ArrayList<Vertice>();

		// Adiciona os adjacentes do atual (caso não estejam nos percorridos)
		for (int i = 0; i < this.adjacentes.size(); i++) {
			Vertice atual = this.adjacentes.get(i);

			if (!alcancaveis.contains(atual)) {
				alcanca = procuraVertice(atual, v, alcancaveis);
			}
		}
		return alcanca;
	}

	// Função recursiva para inserir em 'alcancaveis' o vértice e seus adjacentes
	private boolean procuraVertice(Vertice vertice, Vertice procurado, ArrayList<Vertice> alcancaveis) {

		boolean alcanca = false;

		System.out.println("atual: " + vertice.chave + "/ procurado: " + procurado.chave);

		// Se o atual não está no 'alcacaveis', insere ele
		if (!alcancaveis.contains(vertice)) {
			alcancaveis.add(vertice);
		}

		if (vertice.contemAdjacente(procurado)) {
			alcanca = true;
			return alcanca;
		}

		return alcanca;
	}
}

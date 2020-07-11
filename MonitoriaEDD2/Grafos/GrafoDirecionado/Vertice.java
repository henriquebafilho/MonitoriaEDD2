package GrafoDirecionado;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do vértice

	public ArrayList<Vertice> entrada = new ArrayList<Vertice>(); // vértices que apontam para o atual
	public ArrayList<Vertice> saida = new ArrayList<Vertice>(); // vértices que são apontados pelo atual

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o vértice que for inserido
	}

	// Retorna o grau de entrada do vértice
	public int getGrauEntrada() {
		return entrada.size();
	}

	// Retorna o grau de saída do vértice
	public int getGrauSaida() {
		return saida.size();
	}

	// Liga o vértice atual ao do parâmetro
	public void aponta(Vertice v) {
		// Caso os vértices possuam as mesmas chaves
		if (this.chave == v.chave) {
			System.out.println("Um vértice não pode apontar para ele mesmo");
			return;
		}

		// Checa se os vértices já estão ligados
		for (int i = 0; i < saida.size(); i++) {
			if (v.chave == saida.get(i).chave) {
				System.out.println("O vértice" + this.chave + " já aponta para " + v.chave);
				return;
			}
		}

		// Ligação recíproca
		this.saida.add(v);
		v.entrada.add(this);
	}

	// Checa se o vértice atual aponta para o do parâmetro
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < saida.size(); i++) {
			if (saida.get(i).chave == v.chave) {
				return true;
			}
		}
		return false;
	}

	// Mostra todos os vértices que o atual aponta
	public void mostraSaida() {
		// Caso não tenha adjacentes
		if (this.saida.size() == 0) {
			System.out.println(this.chave + " não aponta para nenhum vértice");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < saida.size(); i++) {
			System.out.print(saida.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Mostra todos os vértices que apontam para o atual
	public void mostraEntrada() {
		// Caso não tenha adjacentes
		if (this.entrada.size() == 0) {
			System.out.println(this.chave + " não é apontado por nenhum vértice");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < entrada.size(); i++) {
			System.out.print(entrada.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Checa se o vértice que chamou a função alcança o do parâmetro
	public boolean alcanca(Vertice v) {
		// Se o v está nos adjacentes do vértice que chamou a função ou é igual a ele
		if (this.contemAdjacente(v) || (this.chave == v.chave)) {
			return true;
		}

		// adiciona a 'alcancaveis' todos os nós que v pode atingir
		ArrayList<Vertice> alcancaveis = new ArrayList<Vertice>();
		return procuraVertice(this, v, alcancaveis);
	}

	// Função recursiva para procurar o vértice v, adicionando em 'alcancaveis' os
	// percorridos
	private boolean procuraVertice(Vertice vertice, Vertice procurado, ArrayList<Vertice> alcancaveis) {
		// Se o atual não está no 'alcacaveis', insere ele
		if (!alcancaveis.contains(vertice)) {
			alcancaveis.add(vertice);
		}

		boolean alcanca = false;

		// Adiciona os de 'saida' do atual (caso não estejam nos percorridos)
		for (int i = 0; i < vertice.saida.size(); i++) {
			Vertice atual = vertice.saida.get(i);

			if (procurado.chave == atual.chave) {
				alcanca = true;
				return alcanca;
			}

			if (!alcancaveis.contains(atual)) {
				alcancaveis.add(atual);
				alcanca = procuraVertice(atual, procurado, alcancaveis);
			}
		}
		return alcanca;
	}
}

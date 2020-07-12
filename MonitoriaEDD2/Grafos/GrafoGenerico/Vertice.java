package GrafoGenerico;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do v�rtice
	public ArrayList<Vertice> adjacentes = new ArrayList<Vertice>(); // Conjunto de v�rtices adjacentes

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o v�rtice que for inserido
	}

	// Retorna o grau do v�rtice
	public int getGrau() {
		return adjacentes.size();
	}

	// Liga o v�rtice atual ao do par�metro
	public void liga(Vertice v) {
		// Caso os v�rtices possuam as mesmas chaves
		if (this.chave == v.chave) {
			System.out.println("Um v�rtice n�o pode se ligar a ele mesmo");
			return;
		}

		// Checa se os v�rtices j� est�o ligados
		for (int i = 0; i < adjacentes.size(); i++) {
			if (v.chave == adjacentes.get(i).chave) {
				System.out.println("Os v�rtices j� est�o ligados");
				return;
			}
		}

		// Liga��o rec�proca
		this.adjacentes.add(v);
		v.adjacentes.add(this);
	}

	// Checa se o v�rtice est� no grafo
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < adjacentes.size(); i++) {
			if (adjacentes.get(i).chave == v.chave) {
				return true;
			}
		}
		return false;
	}

	// Mostra todos os v�rtices adjacentes ao atual
	public void mostraAdjacentes() {
		// Caso n�o tenha adjacentes
		if (this.adjacentes.size() == 0) {
			System.out.println(this.chave + " n�o possui v�rtices adjacentes");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.print(adjacentes.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Checa se o v�rtice que chamou a fun��o alcan�a o do par�metro
	public boolean alcanca(Vertice v) {
		boolean alcanca = false;
		
		// Se o v est� nos adjacentes do v�rtice que chamou a fun��o ou � igual a ele
		if (this.contemAdjacente(v) || (this.chave == v.chave)) {
			return true;
		}

		// adiciona a 'alcancaveis' todos os n�s que v pode atingir
		ArrayList<Vertice> alcancaveis = new ArrayList<Vertice>();

		// Adiciona os adjacentes do atual (caso n�o estejam nos percorridos)
		for (int i = 0; i < this.adjacentes.size(); i++) {
			Vertice atual = this.adjacentes.get(i);

			if (!alcancaveis.contains(atual)) {
				alcanca = procuraVertice(atual, v, alcancaveis);
			}
		}
		return alcanca;
	}

	// Fun��o recursiva para inserir em 'alcancaveis' o v�rtice e seus adjacentes
	private boolean procuraVertice(Vertice vertice, Vertice procurado, ArrayList<Vertice> alcancaveis) {

		boolean alcanca = false;

		System.out.println("atual: " + vertice.chave + "/ procurado: " + procurado.chave);

		// Se o atual n�o est� no 'alcacaveis', insere ele
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

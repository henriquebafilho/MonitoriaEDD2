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

	public boolean alcanca(Vertice v) {
		// Se o v est� nos adjacentes do v�rtice que chamou a fun��o ou � igual a ele
		if (this.contemAdjacente(v) || (this.chave == v.chave)) {
			return true;
		}

		// adiciona a 'alcancaveis' todos os n�s que v pode atingir
		ArrayList<Vertice> alcancaveis = new ArrayList<Vertice>();
		insereAlcancaveis(this, alcancaveis);

		mostraArrayListVertices(alcancaveis);

		if (alcancaveis.contains(v)) {
			return true;
		}
		return false;
	}

	// Fun��o recursiva para inserir em 'alcancaveis' o v�rtice e seus adjacentes
	private void insereAlcancaveis(Vertice vertice, ArrayList<Vertice> alcancaveis) {
		// Se o atual n�o est� no 'alcacaveis', insere ele
		if (!alcancaveis.contains(vertice)) {
			alcancaveis.add(vertice);
		}

		// Adiciona os adjacentes do atual (caso n�o estejam nos percorridos)
		for (int i = 0; i < vertice.adjacentes.size(); i++) {
			Vertice atual = vertice.adjacentes.get(i);

			if (!alcancaveis.contains(atual)) {
				alcancaveis.add(atual);

				// Chama a fun��o para fazer o mesmo procedimento com os adjacentes
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

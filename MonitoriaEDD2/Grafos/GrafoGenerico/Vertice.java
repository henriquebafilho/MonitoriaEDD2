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

	public boolean atinge(Vertice v) {
		boolean atingiu = false;

		// Se v est� nos adjacentes do atual ou � igual ao que chamou a fun��o
		if (this.contemAdjacente(v) || this.chave == v.chave) {
			return true;
		}

		// Vari�vel que armazenar� os v�rtices checados
		ArrayList<Vertice> checados = new ArrayList<Vertice>();

		// adiciona o atual aos j� checados
		checados.add(this);

		System.out.println(this.chave + ": ");
		this.mostraAdjacentes();

		for (int i = 0; i < this.adjacentes.size(); i++) {
			if (!checados.contains(adjacentes.get(i))) {
				checados.add(adjacentes.get(i));
				return atinge(adjacentes.get(i), v, checados);
			}
		}
		System.out.println();
		return atingiu;
	}

	private boolean atinge(Vertice atual, Vertice v, ArrayList<Vertice> checados) {
		boolean atingiu = false;

		System.out.print(atual.chave + ": ");
		atual.mostraAdjacentes();

		// Se o v�rtice atual cont�m v nos adjacentes, retorna verdadeiro
		if (atual.contemAdjacente(v)) {
			return true;
		}
		// se n�o, checa nos seus adjacentes
		for (int i = 0; i < atual.adjacentes.size(); i++) {
			if (!checados.contains(atual.adjacentes.get(i))) {
				checados.add(atual.adjacentes.get(i));
				atingiu = atinge(atual.adjacentes.get(i), v, checados);
			}
		}
		return atingiu;
	}

	// Checa se o v�rtice est� no grafo
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.println("procurado: " + v.chave);
			System.out.println("atual: " + adjacentes.get(i).chave);
			if (adjacentes.get(i).chave == v.chave) {
				System.out.println("ACHOU");
				return true;
			}
			System.out.println();
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
}

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

	// Checa se o v�rtice que chamou a fun��o atinge o do par�metro
	public boolean atinge(Vertice v) {
		// Se v est� nos adjacentes do atual ou � igual ao que chamou a fun��o
		if (this.chave == v.chave || this.contemAdjacente(v)) {
			return true;
		}

		// Vari�vel que armazenar� os v�rtices checados
		ArrayList<Vertice> checados = new ArrayList<Vertice>();

		// adiciona o atual + seus adjacentes aos j� checados
		checados.add(this);

		// Mostra os checados
		for (int i = 0; i < checados.size(); i++) {
			System.out.print(checados.get(i).chave + " ");
		}
		System.out.println();

		return atinge(this.adjacentes.get(0), v, checados);
	}

	private boolean atinge(Vertice atual, Vertice procurado, ArrayList<Vertice> checados) {
		boolean atingiu = false;

		atual.mostraAdjacentes();
		
		if (atual.contemAdjacente(procurado) || atual.chave == procurado.chave) {
			return true;
		}

		// adiciona o atual aos j� checados
		checados.add(atual);

		// Mostra os checados
		for (int i = 0; i < checados.size(); i++) {
			System.out.print(checados.get(i).chave + " ");
		}
		System.out.println();
		 
		for (int i = 0; i < atual.adjacentes.size(); i++) {
			if (!checados.contains(atual.adjacentes.get(i))) {
				atingiu = atinge(atual.adjacentes.get(i), procurado, checados);
			}
		}
		System.out.println();
		return atingiu;
	}

	// Checa se o v�rtice est� no grafo
	public boolean contemAdjacente(Vertice v) {
		System.out.println("------------");
		System.out.println(this.chave);
		for (int i = 0; i < adjacentes.size(); i++) {
			System.out.println("atual: " + adjacentes.get(i).chave);
			System.out.println("procurado: " + v.chave);
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

package GrafoDirecionado;

import java.util.ArrayList;

public class Vertice {
	public int chave; // Chave do v�rtice

	public ArrayList<Vertice> entrada = new ArrayList<Vertice>(); // v�rtices que apontam para o atual
	public ArrayList<Vertice> saida = new ArrayList<Vertice>(); // v�rtices que s�o apontados pelo atual

	public Vertice(int chave) {
		this.chave = chave; // Atribuindo o v�rtice que for inserido
	}

	// Retorna o grau de entrada do v�rtice
	public int getGrauEntrada() {
		return entrada.size();
	}

	// Retorna o grau de sa�da do v�rtice
	public int getGrauSaida() {
		return saida.size();
	}

	// Liga o v�rtice atual ao do par�metro
	public void aponta(Vertice v) {
		// Caso os v�rtices possuam as mesmas chaves
		if (this.chave == v.chave) {
			System.out.println("Um v�rtice n�o pode apontar para ele mesmo");
			return;
		}

		// Checa se os v�rtices j� est�o ligados
		for (int i = 0; i < saida.size(); i++) {
			if (v.chave == saida.get(i).chave) {
				System.out.println("O v�rtice" + this.chave + " j� aponta para " + v.chave);
				return;
			}
		}

		// Liga��o rec�proca
		this.saida.add(v);
		v.entrada.add(this);
	}

	// Checa se o v�rtice atual aponta para o do par�metro
	public boolean contemAdjacente(Vertice v) {
		for (int i = 0; i < saida.size(); i++) {
			if (saida.get(i).chave == v.chave) {
				return true;
			}
		}
		return false;
	}

	// Mostra todos os v�rtices que o atual aponta
	public void mostraSaida() {
		// Caso n�o tenha adjacentes
		if (this.saida.size() == 0) {
			System.out.println(this.chave + " n�o aponta para nenhum v�rtice");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < saida.size(); i++) {
			System.out.print(saida.get(i).chave);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Mostra todos os v�rtices que apontam para o atual
	public void mostraEntrada() {
		// Caso n�o tenha adjacentes
		if (this.entrada.size() == 0) {
			System.out.println(this.chave + " n�o � apontado por nenhum v�rtice");
			return;
		}

		System.out.print(chave + ": ");

		for (int i = 0; i < entrada.size(); i++) {
			System.out.print(entrada.get(i).chave);
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

		if (alcancaveis.contains(v)) {
			return true;
		}
		return false;
	}

	// Fun��o recursiva para inserir em 'alcancaveis' o v�rtice e seus de 'saida'
	private void insereAlcancaveis(Vertice vertice, ArrayList<Vertice> alcancaveis) {
		// Se o atual n�o est� no 'alcacaveis', insere ele
		if (!alcancaveis.contains(vertice)) {
			alcancaveis.add(vertice);
		}

		// Adiciona os de 'saida' do atual (caso n�o estejam nos percorridos)
		for (int i = 0; i < vertice.saida.size(); i++) {
			Vertice atual = vertice.saida.get(i);

			if (!alcancaveis.contains(atual)) {
				alcancaveis.add(atual);
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

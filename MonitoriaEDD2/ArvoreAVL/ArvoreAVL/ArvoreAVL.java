/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura 
(presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<Chave extends Comparable<Chave>> {

	private No raiz; //raiz da árvore

	public class No {
		private Chave chave; // Chave usada nas comparações.
		private No esq, dir; // Referências para subárvores esquerda e direita.

		public No(Chave chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}

		public No(Chave chave, No esq, No dir)
		{
			this.chave = chave;
			this.esq = esq;
			this.dir = dir;
		}
	}

	// Arvore vazia
	public ArvoreAVL() {
		raiz = null;
	}

	/* Criar árvore com apenas um nó
	public ArvoreAVL(T raiz) {
		this.raiz = raiz;
		esq = null;
		dir = null;
	}

	// Criar árvore com nós a esquerda e a direita
	public ArvoreAVL(T raiz, ArvoreAVL arvEsq, ArvoreAVL arvDir) {
		this.raiz = raiz;
		this.esq = arvEsq;
		this.dir = arvDir;
	}*/

	// Checa se a árvore é vazia
	public boolean vazia() {
		return (raiz == null);
	}

	// Checa se é folha
	public boolean folha(No no) {
		if (no.esq == null && no.dir == null) {
			return true;
		}
		return false;
	}

	// Calcula altura da árvore
	public int calculaAltura(No no) {
		if (no.esq == null && no.dir == null)
			return 0;

		int altEsq = 0, altDir = 0;

		if (no.esq != null)
			altEsq = this.calculaAltura(no.esq);

		if (no.dir != null)
			altEsq = this.calculaAltura(no.dir);

		return 1 + Math.max(altEsq, altDir);
	}
	

	// Mostra árvore a partir do nó
	public void mostra(No raiz) {

		System.out.print("(" + raiz);

		if (raiz.esq != null) {
			mostra(raiz.esq);
		}
		if (raiz.dir != null) {
			mostra(raiz.dir);
		}

		System.out.print(")");
	}

	// TODO - Insere nó na árvore
	public void insere(No no) {

		// Caso o inicial seja nulo
		if (no == null) {
			throw new IllegalArgumentException("A chave fornecida é null!");
		}

	}

	// TODO balanceamento

}

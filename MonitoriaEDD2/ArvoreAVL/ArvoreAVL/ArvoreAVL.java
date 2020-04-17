/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura (presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<T extends Comparable<T>> {

	// Todo nó de uma árvore AVL é uma árvore, contendo uma chave raiz com um valor,
	// outra árvore a esquerda e outra a direita, que podem ser nulas ou não
	private T raiz;
	private ArvoreAVL esq, dir;

	/*
	 * public class No { private T raiz; private No esq, dir;
	 * 
	 * public No(T raiz) { this.raiz = raiz; this.esq = null; this.dir = null; }
	 * 
	 * public No(T raiz, No esq, No dir) { this.raiz = raiz; this.esq = esq;
	 * this.dir = dir; } }
	 */

	// Arvore vazia
	public ArvoreAVL() {
		raiz = null;
	}

	// Criar árvore com apenas um nó
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
	}

	// Checa se a árvore é vazia
	public boolean vazia() {
		return (raiz == null);
	}

	// Calcula altura da árvore
	public int calculaAltura() {
		if ((esq == null) && (dir == null))
			return 0;

		int altEsq = 0, altDir = 0;

		if (esq != null)
			altEsq = esq.calculaAltura();

		if (dir != null)
			altDir = dir.calculaAltura();

		return 1 + Math.max(altEsq, altDir);
	}

	// TODO - Insere nó na árvore
	public void insere(ArvoreAVL no) {

		if (no == null) {
			throw new IllegalArgumentException("A chave fornecida é null!");
		}

	}

	// TODO balanceamento

	// TODO mostrar
	public void mostra() {
		
		System.out.print("(" + this.raiz);

		if (esq != null) {
			esq.mostra();
		}
		if (dir != null) {
			dir.mostra();
		}

		System.out.print(")");
	}
}

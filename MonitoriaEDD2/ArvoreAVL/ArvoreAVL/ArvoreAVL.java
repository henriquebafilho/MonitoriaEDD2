/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura 
(presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<Chave extends Comparable<Chave>> {

	private No raiz; // raiz da árvore

	private class No {
		private Chave chave; // Chave usada nas comparações.
		private No esq, dir; // Referências para subárvores esquerda e direita.

		public No(Chave chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}
	}

	// Cria árvore vazia
	public ArvoreAVL() {
		raiz = null;
	}

	// Cria árvore com apenas um nó
	public ArvoreAVL(Chave raiz) {
		No noRaiz = new No(raiz);
		this.raiz = noRaiz;
	}

	// Retorna raiz da árvore
	public No getRaiz() {
		return this.raiz;
	}

	// Retorna a chave da raiz
	public Chave getChaveRaiz() {
		if (getRaiz() == null) {
			System.out.println("A raiz é nula");
			return null;
		}
		return this.raiz.chave;
	}

	// Checa se a árvore é vazia
	public boolean vazia() {
		return (raiz == null);
	}

	// Checa se é folha
	public boolean folha(No no) {
		if (no == null) {
			return false;
		} else if (no.esq == null && no.dir == null) {
			return true;
		}
		return false;
	}

	// Mostra árvore a partir da raiz
	public void mostra() {
		mostra(raiz);
	}

	private void mostra(No no) {

		if (no == null) {
			System.out.println("A árvore é nula");
			return;
		}

		System.out.print("(" + no.chave);

		if (no.esq != null) {
			mostra(no.esq);
		} else if (!folha(no)) {
			System.out.print("( )");
		}

		if (no.dir != null) {
			mostra(no.dir);
		} else if (!folha(no)) {
			System.out.print("( )");
		}
		System.out.print(")");
	}

	// Insere nó na árvore
	public void insere(Chave chave) {
		No no = new No(chave);

		// Caso o inicial seja nulo
		if (no.chave == null) {
			throw new IllegalArgumentException("A chave fornecida é null!");
		}

		raiz = insere(raiz, chave);

	}

	private No insere(No no, Chave chave) {
		// Caso base: encontrou a posição de inserção
		if (no == null) {
			return new No(chave);
		}

		// se a chave inserida for menor que a atual, vai para esquerda
		if (chave.compareTo(no.chave) < 0) {
			no.esq = insere(no.esq, chave);
		}
		// se a chave inserida for maior que a atual, vai para direita
		else if (chave.compareTo(no.chave) > 0) {
			no.dir = insere(no.dir, chave);
		}
		// Caso tenha encontrado nó de mesma chave
		else {
			no.chave = chave;
		}

		return no;
	}

	// Calcula altura da árvore
	public int calculaAltura(No no) {

		if (folha(no) || no == null) {
			return -1;
		}

		int altEsq = 0, altDir = 0;

		if (no.esq != null) {
			altEsq = this.calculaAltura(no.esq);
		}
		if (no.dir != null) {
			altDir = this.calculaAltura(no.dir);
		}
		return 1 + Math.max(altEsq, altDir);
	}

	// Calcula número mínimo de nós que a árvore deve ter para ser AVL
	public int calculaNumeroMinimoNos(No no) {

		int altura = calculaAltura(no);

		if (altura == 0) {
			return 0;
		} else if (altura == 1) {
			return 1;
		}
		return 1 + (altura - 1) + (altura - 2);
	}

	// Retorna fator de equilíbrio do nó
	public int getFatorEquilibrio(No no) {

		int esq = calculaAltura(no.esq);
		int dir = calculaAltura(no.dir);

		// Fator de equilíbrio = tamanho da árvore esquerda - direita
		if (no != null && !folha(no)) {
			return esq - dir;
		}

		return 0;
	}

	// Balanceando a árvore
	public void balancear(No no) {
		// q = fator de equilíbrio
		int q = getFatorEquilibrio(no);

		if (no == null) {
			System.out.println("Não foi possível realizar o balanceamento pois o nó inserido é nulo!");
			return;
		}

		System.out.println("O fator de equilíbrio de " + no.chave + " é " + q);

		// se q > 1
		if (q < -1) {
			// se a subárvore direita possui q < 0
			if (getFatorEquilibrio(no.dir) > 0) {
				System.out.println("Rotação dupla esquerda");
				rotacaoDuplaEsquerda(no);
			} else {
				System.out.println("Rotação esquerda");
				rotacaoEsquerda(no);
			}
		} // se q < -1
		else if (q > 1) {
			// se as subárvore direita possui q>0
			if (getFatorEquilibrio(no.dir) < 0) {
				System.out.println("Rotação dupla direita");
				rotacaoDuplaDireita(no);
			} else {
				System.out.println("Rotação direita");
				rotacaoDireita(no);
			}
		}

		if (no.esq != null) {
			balancear(no.esq);
		}

		if (no.dir != null) {
			balancear(no.dir);
		}
		
	}

	// ROTAÇÕES
	public void rotacaoDireita(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(raiz.chave);

		raiz = raiz.esq;
		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}

	public void rotacaoEsquerda(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(raiz.chave);

		raiz = raiz.dir;
		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}

	public void rotacaoDuplaDireita(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(raiz.chave);
		// Armazena a esquerda da raiz antes da rotação
		No raizEsq = new No(raiz.esq.chave);

		raizEsq.esq = raiz.esq.esq;
		raizFirst.dir = raiz.dir;

		raiz = raiz.esq.dir;
		raizEsq.dir = raiz.esq;
		raiz.esq = raizEsq;
		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}

	public void rotacaoDuplaEsquerda(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(raiz.chave);
		// Armazena a esquerda da raiz antes da rotação
		No raizDir = new No(raiz.dir.chave);

		raizDir.dir = raiz.dir.dir;
		raizFirst.esq = raiz.esq;

		raiz = raiz.dir.esq;
		raizDir.esq = raiz.dir;
		raiz.dir = raizDir;
		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}
}
package ABB;

public class ArvoreBinariaBusca<Chave extends Comparable<Chave>> {
	private No raiz; // raiz da �rvore

	private class No {
		private Chave chave;
		private No esq, dir;

		public No(Chave chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}
	}

	// Cria �rvore com a raiz inicialmente nula
	public ArvoreBinariaBusca() {
		raiz = null;
	}

	// Cria �rvore com apenas um n�, que ser� raiz
	public ArvoreBinariaBusca(Chave raiz) {
		No noRaiz = new No(raiz);
		this.raiz = noRaiz;
	}

	// Insere n� na �rvore, depois balancea a �rvore
	public void insere(Chave chave) {
		No no = new No(chave);

		// Caso o n� tenha chave nula
		if (no.chave == null) {
			throw new IllegalArgumentException("A chave fornecida � null!");
		}
		raiz = insere(raiz, chave);
	}

	private No insere(No no, Chave chave) {
		// Caso base: encontrou a posi��o de inser��o
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
		// Caso tenha encontrado n� de mesma chave, sobreescreve
		else {
			no.chave = chave;
		}
		return no;
	}

	// Retorna raiz da �rvore
	public No getRaiz() {
		return this.raiz;
	}

	// Retorna a chave da raiz
	public Chave getRaizChave() {
		if (this.raiz == null) {
			System.out.println("A raiz � nula");
			return null;
		}
		return this.raiz.chave;
	}

	// Checa se a �rvore � vazia
	public boolean vazia() {
		return (raiz == null);
	}

	// Checa se � folha
	public boolean folha(No no) {
		if (no == null) {
			return false;
		} else if (no.esq == null && no.dir == null) {
			return true;
		}
		return false;
	}

	// Mostra �rvore a partir da raiz
	public void mostra() {
		mostra(raiz);
		System.out.println();
	}

	private void mostra(No no) {
		if (no == null) {
			System.out.println("A �rvore � nula");
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

	// Procura a chave inserida no m�todo e retorna o n�
	public No busca(Chave chave) {
		if (chave == null) {
			System.out.println("A chave � nula");
			return null;
		}

		No procura = busca(raiz, chave);

		if (procura != null) {
			System.out.println("O n� " + procura.chave + " est� na �rvore");
		} else {
			System.out.println("O n� inserido n�o est� na �rvore");
		}
		return procura;
	}

	public No busca(No no, Chave chave) {
		No inserido = new No(null);

		if (no == null) {
			System.out.println("O n� inserido � nulo");
			return null;
		}

		// Calcula se a chave prcurada � maior, menor ou igual � atual
		int comparador = chave.compareTo(no.chave);

		// Se for menor, busca na esquerda
		if (comparador < 0) {
			inserido = busca(no.esq, chave);
		}
		// Se for maior, busca na direita
		else if (comparador > 0) {
			inserido = busca(no.dir, chave);
		}
		// Encontrou a chave
		else {
			inserido = no;
			return inserido;
		}
		return inserido;
	}

	// Calcula altura do n�
	public int calculaAltura(No no) {
		int altEsq = 0, altDir = 0;

		if (no == null) {
			return -1;
		}

		if (folha(no)) {
			return 0;
		}

		if (no.esq != null) {
			altEsq = this.calculaAltura(no.esq);
		}
		if (no.dir != null) {
			altDir = this.calculaAltura(no.dir);
		}
		return 1 + Math.max(altEsq, altDir);
	}

	// Pega a menor chave da �rvore
	public Chave min() {
		if (vazia()) {
			System.out.println("A �rvore est� vazia");
			return null;
		}
		return min(raiz).chave;
	}

	private No min(No atual) {
		if (atual.esq == null) {
			return atual;
		} else {
			return min(atual.esq);
		}
	}

	// Deleta o menor n� da �rvore
	public void deleteMin() {
		if (vazia()) {
			System.out.println("A �rvore est� vazia");
			return;
		}
		raiz = deleteMin(raiz);
	}

	private No deleteMin(No atual) {
		// Caso n�o tenha filho � esquerda, o n� atual possui a menor chave
		if (atual.esq == null) {
			// Se o atual.dir n�o for nulo, o pai do menor passa a apontar para ele
			return atual.dir;
		}
		atual.esq = deleteMin(atual.esq);

		return atual;
	}

	// Deletar um n� e checa se a �rvore est� balanceada,
	public boolean delete(Chave chave) {
		raiz = delete(raiz, chave);

		if (raiz != null) {
			return true;
		} else {
			return false;
		}
	}

	private No delete(No atual, Chave chave) {
		if (atual == null) {
			System.out.println("O n� inserido � nulo");
			return null;
		}

		// Compara a chave atual com a que deve ser deletada
		int comparador = chave.compareTo(atual.chave);

		// Se a atual for menor, checa o filho � esquerda
		if (comparador < 0) {
			atual.esq = delete(atual.esq, chave);
		}
		// Se a atual for maior, checa o filho � direita
		else if (comparador > 0) {
			atual.dir = delete(atual.dir, chave);
		} else {
			if (atual.dir == null) {
				return atual.esq;
			}
			if (atual.esq == null) {
				return atual.dir;
			}

			No aux = atual;

			// Pega o menor da sub�rvore direita (mais � esquerda)
			atual = min(aux.dir);

			// Remove o menor n� da sub-�rvore direita
			atual.dir = deleteMin(aux.dir);

			// A sub�rvore esquerda se mant�m a mesma
			atual.esq = aux.esq;
		}
		return atual;
	}
}
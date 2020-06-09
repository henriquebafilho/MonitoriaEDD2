package ArvoreAVL;

public class ArvoreAVL<Chave extends Comparable<Chave>> {
	private No raiz; // raiz da árvore

	private class No {
		private Chave chave; // Chave usada nas comparações
		private No esq, dir, paiDesregulado; // Referências para subárvores esquerda e direita
		// O nó paiDesregulado só será usado quando o nó for desregulado e não estiver na raiz

		public No(Chave chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
			this.paiDesregulado = null;
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
		if (this.raiz == null) {
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
		System.out.println();
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

	// Conta quantos nós tem na árvore
	public int contaNos(No no) {
		if (no == null) {
			return 0;
		}

		if ((raiz.esq == null) && (raiz.dir == null)) {
			return 1;
		}

		int nosEsq = 0, nosDir = 0;

		if (no.esq != null) {
			nosEsq = contaNos(no.esq);
		}
		if (no.dir != null) {
			nosDir = contaNos(no.dir);
		}
		return 1 + nosEsq + nosDir;
	}

	// Procura a chave inserida no método e retorna o nó
	public No busca(Chave chave) {
		if (chave == null) {
			System.out.println("A chave é nula");
			return null;
		}

		No procura = busca(raiz, chave);

		if (procura != null) {
			System.out.println("O nó " + procura.chave + " está na árvore");
		} else {
			System.out.println("O nó inserido não está na árvore");
		}
		return procura;
	}

	public No busca(No no, Chave chave) {
		No inserido = new No(null);

		if (no == null) {
			System.out.println("O nó inserido é nulo");
			return null;
		}

		// Calcula se a chave prcurada é maior, menor ou igual à atual
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

	// Pega a menor chave da árvore
	public Chave min() {
		if (vazia()) {
			System.out.println("A árvore está vazia");
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

	// Deletar um nó
	public boolean delete(Chave chave) {
		raiz = delete(raiz, chave);

		if (raiz != null) {
			// Depois de deletar, checa se a árvore está balanceada
			balancear(raiz);
			return true;
		} else {
			return false;
		}
	}

	private No delete(No atual, Chave chave) {
		if (atual == null) {
			System.out.println("O nó inserido é nulo");
			return null;
		}

		// Compara a chave atual com a que deve ser deletada
		int comparador = chave.compareTo(atual.chave);

		// Se a atual for menor, checa o filho à esquerda
		if (comparador < 0) {
			atual.esq = delete(atual.esq, chave);
		}
		// Se a atual for maior, checa o filho à direita
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

			// Pega o menor da subárvore direita (mais à esquerda)
			atual = min(aux.dir);

			// Remove o menor
			atual.dir = deleteMin(aux.dir);

			// A subárvore esquerda se mantém a mesma
			atual.esq = aux.esq;
		}
		return atual;
	}

	// Deleta o menor nó da árvore
	public void deleteMin() {
		if (vazia()) {
			System.out.println("A árvore está vazia");
			return;
		}
		raiz = deleteMin(raiz);

		// Depois de deletar, checa se a árvore está balanceada
		balancear(raiz);
	}

	private No deleteMin(No atual) {
		// Caso não tenha filho à esquerda, o nó atual possui a menor chave
		if (atual.esq == null) {
			// Se o atual.dir não for nulo, o pai do menor passa a apontar para ele
			return atual.dir;
		}
		atual.esq = deleteMin(atual.esq);

		return atual;
	}

	// Calcula altura da árvore
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

	// Checa se o nó está regulado
	public boolean regulado(No no) {
		if (getFatorEquilibrio(no) < -1 || getFatorEquilibrio(no) > 1) {
			return false;
		}
		return true;
	}

//	  PASSOS PARA REALIZAR O BALANCEAMENTO
//	  1 - procurar nó desregulado na árvore
//	  2 - (caso tenha) calcular qual rotação deve ser feita, através da posição do nó na árvore
//	  3 - executar a rotação

	// Balanceando a árvore a partir da raiz
	public void balancear() {
		balancear(raiz);
	}

	private void balancear(No raiz) {
		mostra();
		// Procurar nó desregulado na árvore e seu pai a partir da raiz
		No desregulado = obterDesregulado(raiz);

		if (desregulado != null) {
			// Armazena o pai do nó desregulado
			No paiDesregulado = desregulado.paiDesregulado;

			// Escolhe a rotação a ser feita a partir do nó desregulado e seu pai
			escolheRotacao(desregulado, paiDesregulado, getFatorEquilibrio(desregulado));
		} else {
			System.out.println("A árvore está balanceada!");
			return;
		}

		mostra();
		System.out.println();

		// Depois de toda rotação, checa se há outro balanceamento a fazer
		balancear(this.raiz);
	}

	// 1 - Procurando nó desregulado
	private No obterDesregulado(No no) {
		No desregulado = obterDesregulado(no, null);

		if (desregulado != null) {
			System.out.println("O desregulado é o: " + desregulado.chave);
			if (desregulado.paiDesregulado != null) {
				System.out.println("O pai do desregulado é: " + desregulado.paiDesregulado.chave);
			} else {
				System.out.println("O pai do " + desregulado.chave + " é nulo");
			}
		}
		return desregulado;
	}

	private No obterDesregulado(No atual, No desregulado) {
		// q = fator de equilíbrio
		int q = getFatorEquilibrio(atual);

		if (atual == null) {
			System.out.println("Não foi possível realizar o balanceamento pois o nó inserido é nulo!");
			return null;
		}

		System.out.println("O fator de equilíbrio de " + atual.chave + " é " + q);

		if (!regulado(atual)) {
			// Se já tem um nó desregulado
			if (desregulado != null) {
				// Se o nó for desregulado e seu q for menor que o do desregulado atual,
				// atualiza o desregulado
				if (Math.abs(q) < Math.abs(getFatorEquilibrio(desregulado))) {
					desregulado = atual;
				}
			}
			// Caso seja o primeiro nó desregulado, desregulado aponta para ele
			else {
				desregulado = atual;
			}
			System.out.println(desregulado.chave);
		}

		if (atual.esq != null) {
			// Se o próximo não está regulado, o atual se torna pai dele
			if (!regulado(atual.esq)) {
				atual.esq.paiDesregulado = atual;
			}
			desregulado = obterDesregulado(atual.esq, desregulado);
		}

		if (atual.dir != null) {
			// Se o próximo não está regulado, o atual se torna pai dele
			if (!regulado(atual.dir)) {
				atual.dir.paiDesregulado = atual;
			}
			desregulado = obterDesregulado(atual.dir, desregulado);
		}
		return desregulado;
	}

	// 2 - Calcula qual rotação deve ser feita através da posição do nó na árvore
	private void escolheRotacao(No no, No pai, int q) {
		if (q < -1) {
			// se a subárvore direita possui q > 0
			if (getFatorEquilibrio(no.dir) > 0) {
				System.out.println("Rotação dupla esquerda");
				rotacaoDuplaEsquerda(no, pai);
			} else {
				System.out.println("Rotação esquerda");
				rotacaoEsquerda(no, pai);
			}
		} else if (q > 1) {
			// se a subárvore direita possui q < 0
			if (getFatorEquilibrio(no.esq) < 0) {
				System.out.println("Rotação dupla direita");
				rotacaoDuplaDireita(no, pai);
			} else {
				System.out.println("Rotação direita");
				rotacaoDireita(no, pai);
			}
		}
	}

	// 3 - ROTAÇÕES
	public void rotacaoDireita(No desregulado, No pai) {
		// Armazena a nova raiz da árvore
		No novaRaiz = desregulado.esq;

		// Armazena a primeira raiz antes da rotação
		No raizFirst = desregulado;

		// Se o desregulado estiver na raiz
		if (desregulado.chave == raiz.chave) {
			raiz = desregulado.esq;
		}

		if (novaRaiz.dir == null) {
			novaRaiz.dir = raizFirst;
			raizFirst.esq = null;
		} else {
			raizFirst.esq = novaRaiz.dir;
			novaRaiz.dir = raizFirst;
		}

		// Caso o pai seja maior que o filho, aponta seu esquerdo para a nova raiz
		if (pai != null) {
			if (pai.chave.compareTo(desregulado.chave) > 0) {
				pai.esq = novaRaiz;
			} else {
				pai.dir = novaRaiz;
			}
		}
	}

	public void rotacaoEsquerda(No desregulado, No pai) {
		// Armazena a nova raiz da árvore
		No novaRaiz = desregulado.dir;

		// Armazena a primeira raiz antes da rotação
		No raizFirst = desregulado;

		// Se o desregulado estiver na raiz
		if (desregulado.chave == raiz.chave) {
			raiz = desregulado.dir;
		}

		if (novaRaiz.esq == null) {
			novaRaiz.esq = raizFirst;
			raizFirst.dir = null;
		} else {
			raizFirst.dir = novaRaiz.esq;
			novaRaiz.esq = raizFirst;
		}

		// Caso o pai seja maior que o filho, aponta seu esquerdo para a nova raiz
		if (pai != null) {
			if (pai.chave.compareTo(desregulado.chave) > 0) {
				pai.esq = novaRaiz;
			} else {
				pai.dir = novaRaiz;
			}
		}
	}

	// RDD = RE no filho esquerdo do desregulado + RD no desregulado
	public void rotacaoDuplaDireita(No no, No pai) {
		rotacaoEsquerda(no.esq, no);
		rotacaoDireita(no, pai);
	}

	// RDE = RD no filho direito do desregulado + RE no desregulado
	public void rotacaoDuplaEsquerda(No no, No pai) {
		rotacaoDireita(no.dir, no);
		rotacaoEsquerda(no, pai);
	}
}
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

	public No getRaizEsquerda() {
		return raiz.esq;
	}

	public No getRaizDireita() {
		return raiz.dir;
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

		if ((raiz.esq == null) && (raiz.dir == null))
			return 1;

		int nosEsq = 0, nosDir = 0;

		if (no.esq != null)
			nosEsq = contaNos(no.esq);

		if (no.dir != null)
			nosDir = contaNos(no.dir);

		return 1 + nosEsq + nosDir;
	}

	// Procura a chave inserida no método
	public boolean busca(Chave chave) {

		if (chave == null) {
			System.out.println("A chave é nula");
			return false;
		}

		boolean pertence = busca(raiz, chave);

		return pertence;
	}

	public boolean busca(No no, Chave chave) {

		boolean inserido = false;

		if (no == null) {
			System.out.println("O nó inserido é nulo");
			return false;
		}

		// Calcula se a chave prcurada é maior, menor ou igual à atual
		int contador = chave.compareTo(no.chave);

		// Se for menor, busca na esquerda
		if (contador < 0) {
			return busca(no.esq, chave);
		}
		// Se for maior, busca na direita
		else if (contador > 0) {
			return busca(no.dir, chave);
		}
		// Encontrou a chave
		else {
			if (contador == 0) {
				inserido = true;
			}
			return inserido;
		}
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

	// Balanceando a árvore
	public void balancear(No raiz) {
		No desregulado = obterDesregulado(raiz);

		// Se não tem nó desregulado, a árvore está balanceada
		if (desregulado.chave == null) {
			System.out.println("A árvore está balanceada!");
			return;
		} else {
			No paiDesregulado = obterPaiDesregulado(desregulado);
			
			escolheRotacao(desregulado, paiDesregulado, getFatorEquilibrio(desregulado));
		}

		mostra();
		
		// Depois de toda rotação, checa se há outra rotação a fazer
		balancear(this.raiz);
	}

	private No obterDesregulado(No no) {

		No desregulado = obterDesregulado(no, null);

		if(desregulado.chave != null) {
			System.out.println("O desregulado é o: " + desregulado.chave);
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

		// Armazena o último nó desregulado
		if (q > 1 || q < -1) {
			desregulado = atual;
		}

		if (folha(atual) && desregulado.chave != null) {
			return desregulado;
		}

		if (atual.esq != null) {
			obterDesregulado(atual.esq, desregulado);
		}

		if (atual.dir != null) {
			obterDesregulado(atual.dir, desregulado);
		}

		return desregulado;
	}

	private No obterPaiDesregulado(No desregulado) {

		No paiDesregulado = obterPaiDesregulado(raiz, desregulado);

		System.out.println("O pai do " + desregulado.chave + " é " + paiDesregulado.chave);

		return paiDesregulado;

	}

	private No obterPaiDesregulado(No atual, No desregulado) {
		// Armazena pai do nó desregulado
		No paiDesregulado = new No(null);

		if (atual == null) {
			System.out.println("O nó é nulo!");
			return null;
		}

		if (atual.esq != null) {
			// Se o filho esquerdo for o nó desregulado, retorna o pai
			if (atual.esq.chave == desregulado.chave) {
				paiDesregulado = atual;
				return paiDesregulado;
			}
			obterPaiDesregulado(atual.esq, desregulado);
		}

		// Se o nó desregulado estiver à direita, armazena o pai
		if (atual.dir != null) {
			// Se o filho direito for o nó desregulado, retorna o pai
			if (atual.dir.chave == desregulado.chave) {
				paiDesregulado = atual;
				return paiDesregulado;
			}
			obterPaiDesregulado(atual.dir, desregulado);
		}

		return paiDesregulado;
	}

	private void escolheRotacao(No no, No pai, int q) {

		System.out.println("O NÓ DESREGULADO É: " + no.chave);
		System.out.println("O PAI DO NÓ DESREGULADO É: " + pai.chave);

		if (q < -1) {
			// se a subárvore direita possui q < 0
			if (getFatorEquilibrio(no.dir) > 0) {
				System.out.println("Rotação dupla esquerda");
				rotacaoDuplaEsquerda(no);
			} else {
				System.out.print("Rotação esquerda");
				if (pai.chave != null) {
					System.out.println(" com pai");
					rotacaoEsquerda(no, pai);
				} else {
					System.out.println(" sem pai");
					rotacaoEsquerda(no);
				}

			}
		} else if (q > 1) {
			// se as subárvore direita possui q>0
			if (getFatorEquilibrio(no.esq) < 0) {
				System.out.println("Rotação dupla direita");
				rotacaoDuplaDireita(no);
			} else {
				System.out.println("Rotação direita");
				if (pai.chave != null) {
					rotacaoDireita(no, pai);
				} else {
					rotacaoDireita(no);
				}
			}
		}
	}

	// ROTAÇÕES
	// Caso o nó desregulado esteja na raiz
	public void rotacaoDireita(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(null);
		// Armazena a nova raiz da árvore rotacionada
		No novaRaiz = new No(null);

		raizFirst = raiz;

		// Atualiza a raiz
		raiz = raiz.esq;
		novaRaiz = raiz;

		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}

	// Caso o nó desregulado não esteja na raiz
	public void rotacaoDireita(No desregulado, No paiDesregulado) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(desregulado.chave);
		// Armazena a nova raiz da árvore
		No novaRaiz = new No(null);

		novaRaiz = desregulado.esq;
		novaRaiz.dir = raizFirst;
		raizFirst.esq = null;

		// Caso o pai seja maior que o filho, aponta seu esquerdo para a nova raiz
		if (paiDesregulado.chave.compareTo(desregulado.chave) > 0) {
			paiDesregulado.esq = novaRaiz;
		} else {
			paiDesregulado.dir = novaRaiz;
		}
	}

	// Se o nó for igual a raiz
	public void rotacaoEsquerda(No no) {
		// Armazena a primeira raiz antes da rotação
		No raizFirst = new No(null);
		// Armazena a nova raiz da árvore rotacionada
		No novaRaiz = new No(null);

		raizFirst = raiz;

		// Atualiza a raiz
		raiz = raiz.dir;
		novaRaiz = raiz;

		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}

	public void rotacaoEsquerda(No desregulado, No paiDesregulado) {
		// Armazena a primeira raiz da árvore antes da rotação
		No raizFirst = new No(desregulado.chave);
		// Armazena a nova raiz da árvore
		No novaRaiz = new No(null);

		novaRaiz = desregulado.dir;
		novaRaiz.esq = raizFirst;
		raizFirst.dir = null;

		// Caso o pai seja maior que o filho, aponta seu esquerdo para a nova raiz
		if (paiDesregulado.chave.compareTo(desregulado.chave) > 0) {
			paiDesregulado.esq = novaRaiz;
		} else {
			paiDesregulado.dir = novaRaiz;
		}
	}

	// Caso o nó esteja na raiz
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
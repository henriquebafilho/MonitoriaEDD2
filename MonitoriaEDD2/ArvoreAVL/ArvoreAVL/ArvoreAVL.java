/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura 
(presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3� edi��o" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<Chave extends Comparable<Chave>> {

	private No raiz; // raiz da �rvore

	private class No {
		private Chave chave; // Chave usada nas compara��es.
		private No esq, dir; // Refer�ncias para sub�rvores esquerda e direita.

		public No(Chave chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}
	}

	// Cria �rvore vazia
	public ArvoreAVL() {
		raiz = null;
	}

	// Cria �rvore com apenas um n�
	public ArvoreAVL(Chave raiz) {
		No noRaiz = new No(raiz);
		this.raiz = noRaiz;
	}

	// Retorna raiz da �rvore
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

	// Conta quantos n�s tem na �rvore
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

	// Insere n� na �rvore
	public void insere(Chave chave) {
		No no = new No(chave);

		// Caso o inicial seja nulo
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
		// Caso tenha encontrado n� de mesma chave
		else {
			no.chave = chave;
		}

		return no;
	}

	// Calcula altura da �rvore
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

	// Calcula n�mero m�nimo de n�s que a �rvore deve ter para ser AVL
	public int calculaNumeroMinimoNos(No no) {

		int altura = calculaAltura(no);

		if (altura == 0) {
			return 0;
		} else if (altura == 1) {
			return 1;
		}
		return 1 + (altura - 1) + (altura - 2);
	}

	// Retorna fator de equil�brio do n�
	public int getFatorEquilibrio(No no) {

		int esq = calculaAltura(no.esq);
		int dir = calculaAltura(no.dir);

		// Fator de equil�brio = tamanho da �rvore esquerda - direita
		if (no != null && !folha(no)) {
			return esq - dir;
		}

		return 0;
	}

	// Balanceando a �rvore
	public void balancear(No no) {
		No desregulado = obterDesregulado(no);
		System.out.println("--------");
		No paiDesregulado = obterPaiDesregulado(no);

		// Se j� percorreu a �rvore inteira (contador == qtdNos)
		if (desregulado.chave == null) {
			System.out.println("A �rvore est� balanceada!");
			return;
		} else {
			escolheRotacao(desregulado, paiDesregulado, getFatorEquilibrio(desregulado));
		}

		// Depois de toda rota��o, checa se h� outra rota��o a fazer
		// balancear(raiz);
	}

	private No obterDesregulado(No no) {
		// q = fator de equil�brio
		int q = getFatorEquilibrio(no);
		// Armazena o n� desregulado e seu pai
		No desregulado = new No(null);

		if (no == null) {
			System.out.println("N�o foi poss�vel realizar o balanceamento pois o n� inserido � nulo!");
			return null;
		}

		System.out.println("O fator de equil�brio de " + no.chave + " � " + q);

		// Armazena o �ltimo n� desregulado
		if (q > 1 || q < -1) {
			desregulado = no;
		}

		if (no.esq != null) {
			desregulado = obterDesregulado(no.esq);
		}

		if (no.dir != null) {
			desregulado = obterDesregulado(no.dir);
		}

		return desregulado;
	}

	private No obterPaiDesregulado(No no) {
		// Armazena pai do n� desregulado
		No paiDesregulado = new No(null);

		if (no == null) {
			System.out.println("O n� � nulo!");
			return null;
		}

		if (no.esq != null) {
			// Se o n� desregulado estiver � esquerda, armazena o pai
			if (getFatorEquilibrio(no.esq) > 1 || getFatorEquilibrio(no.esq) < -1) {
				paiDesregulado = no;
			}
			obterPaiDesregulado(no.esq);
		}

		// Se o n� desregulado estiver � direita, armazena o pai
		if (no.dir != null) {
			if (getFatorEquilibrio(no.dir) > 1 || getFatorEquilibrio(no.dir) < -1) {
				paiDesregulado = no;
			}
			obterPaiDesregulado(no.dir);
		}

		return paiDesregulado;
	}

	private void escolheRotacao(No no, No pai, int q) {

		System.out.println("O N� DESREGULADO �: " + no.chave);
		System.out.println("O PAI DO N� DESREGULADO �: " + pai.chave);

		if (q < -1) {
			// se a sub�rvore direita possui q < 0
			if (getFatorEquilibrio(no.dir) > 0) {
				System.out.println("Rota��o dupla esquerda");
				rotacaoDuplaEsquerda(no);
			} else {
				System.out.println("Rota��o esquerda");
				if (pai.chave != null) {
					rotacaoEsquerda(no, pai);
				} else {
					rotacaoEsquerda(no);
				}

			}
		} else if (q > 1) {
			// se as sub�rvore direita possui q>0
			if (getFatorEquilibrio(no.esq) < 0) {
				System.out.println("Rota��o dupla direita");
				rotacaoDuplaDireita(no);
			} else {
				System.out.println("Rota��o direita");
				if (pai.chave != null) {
					rotacaoDireita(no, pai);
				} else {
					rotacaoDireita(no);
				}
			}
		}
	}

	// ROTA��ES
	// Caso o n� desregulado esteja na raiz
	public void rotacaoDireita(No no) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(null);
		// Armazena a nova raiz da �rvore rotacionada
		No novaRaiz = new No(null);

		raizFirst = raiz;

		// Atualiza a raiz
		raiz = raiz.esq;
		novaRaiz = raiz;

		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}

	// Caso o n� desregulado n�o esteja na raiz
	public void rotacaoDireita(No desregulado, No paiDesregulado) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(desregulado.chave);
		// Armazena a nova raiz da �rvore
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

	// Se o n� for igual a raiz
	public void rotacaoEsquerda(No no) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(null);
		// Armazena a nova raiz da �rvore rotacionada
		No novaRaiz = new No(null);

		raizFirst = raiz;

		// Atualiza a raiz
		raiz = raiz.dir;
		novaRaiz = raiz;

		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}

	public void rotacaoEsquerda(No desregulado, No paiDesregulado) {
		// Armazena a primeira raiz da �rvore antes da rota��o
		No raizFirst = new No(desregulado.chave);
		// Armazena a nova raiz da �rvore
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

	// Caso o n� esteja na raiz
	public void rotacaoDuplaDireita(No no) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);
		// Armazena a esquerda da raiz antes da rota��o
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
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);
		// Armazena a esquerda da raiz antes da rota��o
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
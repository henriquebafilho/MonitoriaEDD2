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

		public No(Chave chave, No esq, No dir) {
			this.chave = chave;
			this.esq = esq;
			this.dir = dir;
		}
	}

	// Arvore vazia
	public ArvoreAVL() {
		raiz = null;
	}

	// �rvore com apenas um n�
	public ArvoreAVL(Chave raiz) {
		No noRaiz = new No(raiz);
		this.raiz = noRaiz;
	}

	/*
	 * Criar �rvore com apenas um n� public ArvoreAVL(T raiz) { this.raiz = raiz;
	 * esq = null; dir = null; } // Criar �rvore com n�s a esquerda e a direita
	 * public ArvoreAVL(T raiz, ArvoreAVL arvEsq, ArvoreAVL arvDir) { this.raiz =
	 * raiz; this.esq = arvEsq; this.dir = arvDir; }
	 */

	public No getRaiz() {
		return this.raiz;
	}

	// Checa se a �rvore � vazia
	public boolean vazia() {
		return (raiz == null);
	}

	// Checa se � folha
	public boolean folha(No no) {
		if (no.esq == null && no.dir == null) {
			return true;
		}
		return false;
	}

	// Calcula altura da �rvore
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

	// Mostra �rvore a partir do n�
	public void mostra() {
		mostra(raiz);
	}

	private void mostra(No no) {

		System.out.print("(" + no.chave);
		
		if (no.esq != null) {
			mostra(no.esq);
		} else if (!folha(no)) {
			System.out.print("( )");
		}
		
		if (no.dir != null) {
			mostra(no.dir);
		}else if (!folha(no)) {
			System.out.print("( )");
		}
		System.out.print(")");
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
		if (no == null)
			return new No(chave);

		// se a chave inserida for menor que a atual
		if (chave.compareTo(no.chave) < 0) { // Vai para esquerda
			no.esq = insere(no.esq, chave);
		}
		// se a chave inserida for maior que a atual
		else if (chave.compareTo(no.chave) > 0) { // Vai para direita
			no.dir = insere(no.dir, chave);
		}
		// Caso tenha encontrado n� de mesma chave
		else {
			no.chave = chave;
		}

		return no;
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
	
	//ROTA��ES
	public void rotacaoDireita(No no) {
		//Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);
		
		raiz = raiz.esq;
		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}
	
	public void rotacaoEsquerda(No no) {
		//Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);
		
		raiz = raiz.dir;
		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}
	
	public void rotacaoDuplaDireita(No no) {
		//Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);
		//Armazena a esquerda da raiz antes da rota��o
		No raizEsq = new No(raiz.esq.chave);
		raizEsq.esq = raiz.esq.esq;
		raizFirst.dir = raiz.dir;
		
		raiz = raiz.esq.dir;
		raizEsq.dir = raiz.esq;
		raiz.esq = raizEsq;
		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;		
		
	}

}
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

		if (folha(no) || no == null) {
			return 0;
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
		if (no != null) {
			return (1 + calculaAltura(no.dir) - (1 + calculaAltura(no.esq)));
		}
		return 0;
	}

	// Balanceando a �rvore
	public void balancear(No no) {
		// fator equilibrio = q
		int fatorEquilibrio = getFatorEquilibrio(raiz);

		if (no == null) {
			System.out.println("N�o foi poss�vel realizar o balanceamento pois o n� inserido � nulo!");
			return;
		}

		// Se -1 <= q <= 1
		if (fatorEquilibrio >= -1 && fatorEquilibrio <= 1) {
			System.out.println("A �rvore � balanceada!");
		}

		// se q > 1
		if (fatorEquilibrio > 1) {
			// se a sub�rvore direita possui q < 0
			if (getFatorEquilibrio(no.dir) < 0) {
				System.out.println("Fazer rota��o dupla � esquerda");
			} else {
				System.out.println("Fazer rota��o esquerda");
			}
		}
		// se q < 1
		else {
			// se a sub�rvore direita possui q > 0
			if (getFatorEquilibrio(no.dir) > 0) {
				System.out.println("Fazer rota��o dupla � direita");
			} else {
				System.out.println("Fazer rota��o direita");
			}
		}

	}

	// ROTA��ES
	public void rotacaoDireita(No no) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);

		raiz = raiz.esq;
		raizFirst.esq = raiz.dir;
		raiz.dir = raizFirst;
	}

	public void rotacaoEsquerda(No no) {
		// Armazena a primeira raiz antes da rota��o
		No raizFirst = new No(raiz.chave);

		raiz = raiz.dir;
		raizFirst.dir = raiz.esq;
		raiz.esq = raizFirst;
	}

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
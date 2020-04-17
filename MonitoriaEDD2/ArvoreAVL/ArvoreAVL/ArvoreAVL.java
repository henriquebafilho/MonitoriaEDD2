/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura (presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<T extends Comparable<T>> {

	//Todo nó de uma árvore AVL é uma árvore, contendo uma chave, outra árvore a esquerda e outra a direita
	private T chave; 
	private ArvoreAVL esq, dir; 
	
	/*public class No {
		private T chave; 
		private No esq, dir; 

		public No(T chave) {
			this.chave = chave;
			this.esq = null;
			this.dir = null;
		}

		public No(T chave, No esq, No dir) {
			this.chave = chave;
			this.esq = esq;
			this.dir = dir;
		}
	}*/
	
	//Arvore vazia
	public ArvoreAVL() {
		chave = null;
	}
	
	//Criar árvore com apenas um nó
	public ArvoreAVL(T chave) {
		this.chave = chave;
		esq = null;
		dir = null;
	}
	
	//Criar árvore com nós a esquerda e a direita
	public ArvoreAVL(T chave, ArvoreAVL arvEsq, ArvoreAVL arvDir) {
		this.chave = chave;
		this.esq = arvEsq;
		this.dir = arvDir;
	}
	
	//Checa se a árvore é vazia
	public boolean vazia() {
		return (chave == null);
	}
	
	//Calcula altura da árvore
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
	
	//TODO - Insere nó na árvore
	public void insere(ArvoreAVL no) {
		
		if(no == null) {
			throw new IllegalArgumentException("A chave fornecida é null!");
		}
		
	}
	
	//TODO balanceamento
	

}

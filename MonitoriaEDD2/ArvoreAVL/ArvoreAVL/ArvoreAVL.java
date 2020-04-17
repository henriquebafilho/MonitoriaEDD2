/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura (presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3� edi��o" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<T extends Comparable<T>> {

	//Todo n� de uma �rvore AVL � uma �rvore, contendo uma chave, outra �rvore a esquerda e outra a direita
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
	
	//Criar �rvore com apenas um n�
	public ArvoreAVL(T chave) {
		this.chave = chave;
		esq = null;
		dir = null;
	}
	
	//Criar �rvore com n�s a esquerda e a direita
	public ArvoreAVL(T chave, ArvoreAVL arvEsq, ArvoreAVL arvDir) {
		this.chave = chave;
		this.esq = arvEsq;
		this.dir = arvDir;
	}
	
	//Checa se a �rvore � vazia
	public boolean vazia() {
		return (chave == null);
	}
	
	//Calcula altura da �rvore
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
	
	//TODO - Insere n� na �rvore
	public void insere(ArvoreAVL no) {
		
		if(no == null) {
			throw new IllegalArgumentException("A chave fornecida � null!");
		}
		
	}
	
	//TODO balanceamento
	

}

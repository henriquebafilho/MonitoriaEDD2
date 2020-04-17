/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura (presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

public class ArvoreAVL<T extends Comparable<T>> {

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

	public ArvoreAVL(T chave) {
		this.chave = chave;
		esq = null;
		dir = null;
	}

	public ArvoreAVL(T chave, ArvoreAVL arvEsq, ArvoreAVL arvDir) {
		this.chave = chave;
		this.esq = arvEsq;
		this.dir = arvDir;
	}

	public boolean vazia() {
		return (chave == null);
	}

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

	public void insereNo(ArvoreAVL no) {

		
		
	}
}

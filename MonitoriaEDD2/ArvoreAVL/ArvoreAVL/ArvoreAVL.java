/*Feito por Henrique Filho, baseado no material de Estrutura de Dados 1 do professor Pedro Nuno Moura (presente no package "ArvoreBinaria" e "ArvoreBinariaBusca") 
 * e no livro "Estrutura de Dados e Seus Algoritmos - 3ª edição" de Jayme Luiz Szwarcfiter e Lilian Markenzon*/
package ArvoreAVL;

import ArvoreBinaria.Arvbin;

public class ArvoreAVL<T extends Comparable<T>> {

	private T valor;
	private Arvbin<T> esq, dir;

	public ArvoreAVL(T raiz) {
		this.valor = raiz;
		esq = null;
		dir = null;
	}
	
	public ArvoreAVL(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir) {
		this.valor = valor;
		esq = arvEsq;
		dir = arvDir;
	}
	
	public ArvoreAVL()
	{
		valor = null;
	}
	
	public boolean vazia()
	{
		return (valor == null);
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


}

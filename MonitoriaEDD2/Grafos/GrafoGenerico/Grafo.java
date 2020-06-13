// Declara��o de grafos utilizando ArrayList
package GrafoGenerico;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>(); // Conjunto de v�rtices do grafo

//	// Mostrando os v�rtices por Lista de Adjac�ncia
//	public void mostraLA() {
//		// Caso n�o tenha v�rtices no grafo
//		if(vertices.size() == 0) {
//			System.out.println("O grafo n�o possui v�rtices");
//			return;
//		}
//		
//		for(int i = 0; i < vertices.size(); i++) {
//			vertices.get(i).mostraAdjacentes();
//		}
//		
//	}

	// Mostra os v�rtices do grafo
	public void mostraVertices() {
		System.out.print("V�rtices: ");

		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).chave + " ");
		}
		System.out.println();
	}
	
	// Adiciona o v�rtice no grafo
	public void adicionaVertice(Vertice v) {
		vertices.add(v);
	}

}

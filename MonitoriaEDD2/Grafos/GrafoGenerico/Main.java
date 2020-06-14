package GrafoGenerico;

import java.util.ArrayList;

import GrafoGenerico.Grafo;

public class Main {

	public static void main(String[] args) {
		// Criando grafo
		Grafo g = new Grafo();

		// Criando vértices
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);

		// Adicionando vértices no grafo
		g.adicionaVertice(v1);
		g.adicionaVertice(v2);
		g.adicionaVertice(v3);
		g.adicionaVertice(v4);

		// Ligando vértices
		v1.liga(v2);
		v1.liga(v3);
		v2.liga(v4);

		g.mostraVertices();
		g.mostraLA();
		g.mostraMA();

		System.out.println("\nO grafo é nulo? " + g.nulo());
		System.out.println("O grafo é regular? " + g.regular());
		System.out.println("O grafo é completo? " + g.completo());
	}

}

package GrafoGenerico;

import java.util.ArrayList;

import GrafoGenerico.Grafo;

public class Main {

	public static void main(String[] args) {
		// Criando grafo
		Grafo g = new Grafo();

//		// Criando v�rtices
//		Vertice v1 = new Vertice(1);
//		Vertice v2 = new Vertice(2);
//		Vertice v3 = new Vertice(3);
//		Vertice v4 = new Vertice(4);
//
//		// Adicionando v�rtices no grafo
//		g.adicionaVertice(v1);
//		g.adicionaVertice(v2);
//		g.adicionaVertice(v3);
//		g.adicionaVertice(v4);
//
//		// Ligando v�rtices
//		v1.liga(v2);
//		v1.liga(v3);
//		v2.liga(v4);

//-------------------------------------------------------------------------

		// Criando v�rtices
		Vertice v0 = new Vertice(0);
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);
		Vertice v5 = new Vertice(5);
		Vertice v6 = new Vertice(6);
		Vertice v7 = new Vertice(7);
		Vertice v8 = new Vertice(8);
		Vertice v9 = new Vertice(9);
		Vertice v10 = new Vertice(10);
		Vertice v11 = new Vertice(11);

		// Adicionando v�rtices no grafo
		g.adicionaVertice(v0);
		g.adicionaVertice(v1);
		g.adicionaVertice(v2);
		g.adicionaVertice(v3);
		g.adicionaVertice(v4);
		g.adicionaVertice(v5);
		g.adicionaVertice(v6);
		g.adicionaVertice(v7);
		g.adicionaVertice(v8);
		g.adicionaVertice(v9);
		g.adicionaVertice(v10);
		g.adicionaVertice(v11);

		// Ligando v�rtices
		v0.liga(v1);
		v0.liga(v4);
		v4.liga(v8);
		v4.liga(v5);
		v8.liga(v9);
		v1.liga(v5);
		v5.liga(v9);
		v3.liga(v7);
		v1.liga(v2);
		v5.liga(v6);
		v9.liga(v10);
		v2.liga(v6);
		v6.liga(v10);
		v2.liga(v3);
		v6.liga(v7);
		v10.liga(v11);
		v7.liga(v11);

		g.mostraVertices();
		g.mostraLA();
		g.mostraMA();

		System.out.println("\nO grafo � nulo? " + g.nulo());
		System.out.println("O grafo � regular? " + g.regular());
		System.out.println("O grafo � completo? " + g.completo());
		System.out.println("O grafo � conexo? " + g.conexo());
	}

}

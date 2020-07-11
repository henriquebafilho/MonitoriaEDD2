package GrafoDirecionado;

import java.util.ArrayList;

import GrafoDirecionado.Grafo;

public class Main {

	public static void main(String[] args) {
		// Criando grafo
		Grafo g = new Grafo();

//		// Criando vértices
//		Vertice v1 = new Vertice(1);
//		Vertice v2 = new Vertice(2);
//		Vertice v3 = new Vertice(3);
//
//		// Adicionando vértices no grafo
//		g.adicionaVertice(v1);
//		g.adicionaVertice(v2);
//		g.adicionaVertice(v3);
//
//		// Ligando vértices
//		v1.aponta(v2);
//		v2.aponta(v3);
//		v3.aponta(v1);

//-------------------------------------------------------------------------

		// Criando vértices
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

		// Adicionando vértices no grafo
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

		// Ligando vértices
		v0.aponta(v1);
		v0.aponta(v4);
		v4.aponta(v8);
		v4.aponta(v5);
		v8.aponta(v9);
		v1.aponta(v5);
		v5.aponta(v9);
		v3.aponta(v7);
		v1.aponta(v2);
		v5.aponta(v6);
		v9.aponta(v10);
		v2.aponta(v6);
		v6.aponta(v10);
		v2.aponta(v3);
		v6.aponta(v7);
		v10.aponta(v11);
		v7.aponta(v11);

		g.mostraVertices();
		g.mostraLASaida();
		g.mostraMASaida();
		System.out.println();
		g.mostraLAEntrada();
		g.mostraMAEntrada();

		System.out.println("\nO grafo é nulo? " + g.nulo());
		System.out.println("O grafo é regular? " + g.regular());
		System.out.println("O grafo é completo? " + g.completo());
		System.out.println("O grafo é conexo? " + g.conexo());
		System.out.println(v5.alcanca(v8));
	}

}

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
		
		// Adicionando vértices no grafo
		g.adicionaVertice(v1);
		g.adicionaVertice(v2);
		g.adicionaVertice(v3);
		
		// Ligando vértices
		v1.liga(v2);
		v3.liga(v2);
		v1.liga(v3);
		
		g.mostraVertices();
		g.mostraLA();
		g.mostraMA();
	}
	
}

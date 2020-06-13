package GrafoGenerico;

import java.util.ArrayList;

import GrafoGenerico.Grafo;

public class Main {
	
	public static void main(String[] args) {
		Grafo g = new Grafo();
		
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		
		g.adicionaVertice(v1);
		g.adicionaVertice(v2);
		g.adicionaVertice(v3);
		
		v1.liga(v2);
		v3.liga(v2);
		v1.liga(v3);
		
		g.mostraVertices();
		g.mostraLA();
	}
	
}

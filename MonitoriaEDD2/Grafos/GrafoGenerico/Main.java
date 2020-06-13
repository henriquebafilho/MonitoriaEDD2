package GrafoGenerico;

import java.util.ArrayList;

import GrafoGenerico.Grafo;

public class Main {
	
	public static void main(String[] args) {
		Grafo g = new Grafo();
		
		g.insere(1);
		g.insere(2);
		g.insere(3);
		
		g.mostraVertices();
	}
	
}

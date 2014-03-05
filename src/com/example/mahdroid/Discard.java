package com.example.mahdroid;

import java.util.Stack;


public class Discard {

	private Stack<Tile> pile;
	private int size;
	
	public Discard() {
		this.pile = new Stack<Tile>();
		this.size = 0;
	}
	
	public void add(Tile tile){
		this.pile.push(tile);
		this.size++;
	}

	public Tile remove(Tile tile){
		this.size--;
		return pile.pop();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size; i++) {
			sb.append(this.pile.get(i) + "\n");
		}
		return sb.toString();
		
	}
}

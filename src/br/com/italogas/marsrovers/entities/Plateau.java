package br.com.italogas.marsrovers.entities;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	
	private int width;
	private int height;
	private List<Rover> rovers; 
	public Plateau() {
		this.rovers = new ArrayList<Rover>();
	}
	public Plateau(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.rovers = new ArrayList<Rover>();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	public List<Rover> getRovers() {
		return rovers;
	}

}

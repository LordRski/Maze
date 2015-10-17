/**
 * This file is part of Maze.
 *
 * Maze is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Maze is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.				 
 * 
 * You should have received a copy of the GNU General Public License
 * along with Maze.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Edouard CATTEZ <edouard.cattez@sfr.fr> (La 7 Production)
 */
package fr.ecattez.maze.entity;

import java.awt.Color;

/**
 * Représente une case de coordonnées (x,y), x et y étant des entiers.
 */
public class Cell extends Coordinates implements Cloneable {
	
	private int value;
	private boolean visited;
	private transient int weight;
	private Color color;
	
	public Cell(int x, int y, int value) {
		super(x, y);
		this.value = value;
		this.visited = false;
		this.weight = 0;
		this.color = Color.LIGHT_GRAY;
	}

	public Cell(int x, int y) {
		this(x, y, 0);
	}
	
	/**
	 * Additionne des cases avec un couple (x,y)
	 * 
	 * @param	x
	 * 			la coordonnée x à ajouter
	 * @param	y
	 * 			la coordonnée y à ajouter
	 * 
	 * @return la case équivalente à la somme de la case courante et du couple (x,y)
	 */
	public Cell add(int x, int y) {
		return new Cell(this.x + x, this.y + y);
	}
	
	/**
	 * Additionne deux cases entre-elles
	 * 
	 * @param	c
	 * 			la case à ajouter
	 * 
	 * @return la case équivalente à la somme des deux cases
	 */
	public Cell add(Cell c) {
		return new Cell(this.x + c.x, this.y + c.y);
	}
	
	/**
	 * Additionne une case et un point cardinal
	 * 
	 * @param	d
	 * 			le point cardinal à ajouter
	 * 
	 * @return la case équivalente à la somme de la case et des coordonnées du point cardinal
	 */
	public Cell add(Direction d) {
		return new Cell(this.x + d.getX(), this.y + d.getY());
	}
	
	/**
	 * La valeur de la case
	 * 
	 * @return la valeur de la case
	 */
	public int val() {
		return this.value;
	}
	
	/**
	 * Saisi la valeur de la case
	 * 
	 * @param	value
	 * 			la nouvelle valeur de la case
	 * 
	 * @return la valeur de la case
	 */
	public int val(int value) {
		return this.value = value;
	}
	
	/**
	 * Le 'poids' de la case.
	 * 
	 * Plus une case est lourde, plus elle est loin de la case de départ.
	 * La case d'arrivée d'un labyrinthe est donc la case la plus lourde que l'on puisse trouver.
	 * 
	 * @return le poids de la case
	 */
	public int weight() {
		return this.weight;
	}
	
	/**
	 * Saisi le poids de la case.
	 * 
	 * @param	weight
	 * 			le nouveau poids de la case
	 * 
	 * @return le poids de la case
	 */
	public int weight(int weight) {
		return this.weight = weight;
	}
	
	/**
	 * Incrémente le poids de la case
	 * 
	 * @return le poids de la case
	 */
	public int incWeight() {
		return this.weight++;
	}
	
	/**
	 * La couleur de la case
	 * 
	 * @return la couleur de la case
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Saisi la couleur de la case
	 * 
	 * @param	color
	 * 			la couleur de la case
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Test s'il y a un mur dans la direction voulue à partir de la case courante
	 * 
	 * @param	d
	 * 			la direction à tester
	 * 
	 * @return vrai s'il existe un mur à partir de la case courante, dans la direction voulue
	 */
	public boolean hasWall(Direction d) {
		return (value & d.exponent()) == 0;
	}
	
	/**
	 * Test si la case a été visitée par un path finder
	 * 
	 * @return vrai si la case a été visitée
	 */
	public boolean isVisited() {
		return this.visited;
	}
	
	/**
	 * Visite la case
	 */
	public void visit() {
		if (!visited) {
			this.visited = true;
			this.color = Color.RED;
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof Cell) {
			Cell other = (Cell) o;
			return x == other.x && y == other.y && value == other.value;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Cell[x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	@Override
	public Cell clone() {
		return new Cell(x, y, value);
	}

}

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

/**
 * Représente une case de coordonnées (x,y), x et y étant des entiers.
 */
public class Cell extends Coordinates implements Cloneable {
	
	private int value;
	private boolean visited;
	
	public Cell(int x, int y, int value) {
		super(x, y);
		this.value = value;
		this.visited = false;
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
	 */
	public int val(int value) {
		return this.value = value;
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

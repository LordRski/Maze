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
package fr.lordrski.maze.util;

/**
 * Représente une case de coordonnées (x,y), x et y étant des entiers.
 */
public class Cell extends Coordinates {
	
	private int value;

	public Cell(int x, int y) {
		super(x, y);
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
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o) && (o instanceof Cell && value == ((Cell)o).value);
	}
	
	@Override
	public String toString() {
		return "Cell[x=" + x + ", y=" + y + "]";
	}

}

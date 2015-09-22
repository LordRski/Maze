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
package fr.lordrski.maze.entity;

import java.util.Observable;

/**
 * Représentation de coordonnées dans un repère 2D.
 */
public class Coordinates extends Observable implements Cloneable {
	
	protected final int x;
	protected final int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * La coordonnée x
	 * 
	 * @return la coordonnée x
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * La coordonnée y
	 * 
	 * @return la coordonnée y
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Additionne des coordonnées avec un couple (x,y)
	 * 
	 * @param	x
	 * 			la coordonnée x à ajouter
	 * @param	y
	 * 			la coordonnée y à ajouter
	 * 
	 * @return les coordonnées équivalentes à la somme des coordonnées courantes et du couple (x,y)
	 */
	public Coordinates add(int x, int y) {
		return new Coordinates(this.x + x, this.y + y);
	}
	
	/**
	 * Additionne deux couples de coordonnées
	 * 
	 * @param	coord
	 * 			les coordonnées à ajouter
	 * 
	 * @return les coordonnées équivalentes à la somme des deux couples de coordonnées
	 */
	public Coordinates add(Coordinates coord) {
		return add(coord.x, coord.y);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof Coordinates) {
			Coordinates other = (Coordinates) o;
			return x == other.x && y == other.y;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int tmp = y + ((x+1)/2);
		return x + (tmp * tmp);
	}
	
	@Override
	public String toString() {
		return "Coordinates[x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public Coordinates clone() {
		return new Coordinates(x, y);
	}

}

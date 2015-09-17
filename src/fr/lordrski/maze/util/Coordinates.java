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
 * Représentation de coordonnées dans un repère 2D.
 */
public class Coordinates {
	
	protected final double x;
	protected final double y;
	
	public Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * La coordonnée x
	 * 
	 * @return la coordonnée x
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * La coordonnée y
	 * 
	 * @return la coordonnée y
	 */
	public double getY() {
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
	public Coordinates add(double x, double y) {
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
		return o == this || (o instanceof Coordinates && x == ((Coordinates)o).x && y == ((Coordinates)o).y);
	}
	
	@Override
	public int hashCode() {
		return (((int)x) << 4 + ((int)y) << 2);
	}
	
	@Override
	public String toString() {
		return "Coordinates[x=" + x + ", y=" + y + "]";
	}

}

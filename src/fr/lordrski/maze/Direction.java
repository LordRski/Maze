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
package fr.lordrski.maze;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Représente les points cardinaux d'un repère.
 */
public enum Direction {
	
	NORTH(0, -1) { @Override public Direction opposite() { return SOUTH; } },
	EAST(1, 0) { @Override public Direction opposite() { return WEST; } },
	SOUTH(0, 1) { @Override public Direction opposite() { return NORTH; } },
	WEST(-1, 0) { @Override public Direction opposite() { return EAST; } };
	
	/**
	 * Mélange les points cardinaux
	 * 
	 * @return les points cardinaux mélangés
	 */
	public static Direction[] shuffles() {
		List<Direction> directions = Arrays.asList(Direction.values());
		Collections.shuffle(directions);
		return (Direction[]) directions.toArray();
	}
	
	private final Coordinates coord;
	
	private Direction(int x, int y) {
		this.coord = new Coordinates(x, y);
	}
	
	/**
	 * {@see fr.lordrski.maze.util.Coordinates#getX()}
	 */
	public int getX() {
		return coord.x;
	}
	
	/**
	 * {@see fr.lordrski.maze.util.Coordinates#getY()}
	 */
	public int getY() {
		return coord.y;
	}
	
	/**
	 * Retourne le point cardinal sous forme de coordonnées
	 * 
	 * @return le point cardinal sous forme de coordonnées
	 */
	public Coordinates toCoordinates() {
		return coord;
	}
	
	/**
	 * Retourne un point cardinal sous forme de puissance de 2
	 * 
	 * 0 : NORTH
	 * 2 : EAST
	 * 4 : SOUTH
	 * 8 : WEST
	 * 
	 * @return un point cardinal sous forme de puissance de 2
	 */
	public int exponent() {
		return 1 << ordinal();
	}
	
	@Override
	public String toString() {
		return "Direction[x=" + getX() + ", y=" + getY() + "]";
	}
	
	/**
	 * Retourne la direction opposée à la direction courante
	 * 
	 * @return la direction opposée à la direction courante
	 */
	public abstract Direction opposite();

}

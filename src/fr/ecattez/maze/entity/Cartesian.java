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
 * Implémentation des coordonnées cartésiennes.
 */
public class Cartesian implements Coordinates {
	
	private double x;
	private double y;
	
	public Cartesian(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public Coordinates add(Coordinates c) {
		return new Cartesian(x + c.getX(), y + c.getY());
	}

	@Override
	public boolean isCloseTo(Coordinates c) {
		int rx = (int) Math.abs(x - c.getX());
		int ry = (int) Math.abs(y - c.getY());
		return (rx == 0 || rx == 1) && (ry == 0 || ry == 1);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		Coordinates c = (Coordinates) o;
		return c != null && x == c.getX() && y == c.getY();
	}
	
	@Override
	public Cartesian clone() {
		return new Cartesian(x, y);
	}
	
	@Override
	public String toString() {
		return "Cartesian[x:" + x + ", y:" + y + "]";
	}

}

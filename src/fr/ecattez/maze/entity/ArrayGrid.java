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
 * Implémentation d'une grille de cellules.
 */
public class ArrayGrid extends Grid {
	
	private Cell[][] cells;

	public ArrayGrid(int width, int height) {
		super(width, height);
		cells = new Cell[height][width];
		
		for (int y=0; y < height; y++) {
			for (int x=0; x < width; x++) {
				set(new Cell(), new Cartesian(x, y));
			}
		}
	}

	@Override
	public void set(Cell c, Coordinates coord) {
		cells[(int) coord.getY()][(int) coord.getX()] = c;
		c.addObserver(this);
	}

	@Override
	public Cell get(Coordinates coord) {
		return cells[(int) coord.getY()][(int) coord.getX()];
	}

}

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
package fr.lordrski.maze.algorithm.builder;

import fr.lordrski.maze.Maze;
import fr.lordrski.maze.util.Cell;

/**
 * Algorithme du Recursive Backtracker pour créer un labyrinthe.
 */
public class RecursiveMazeBuilder implements MazeBuilder {

	@Override
	public Maze build(int width, int height, int xstart, int ystart) {
		if (xstart < 0 || xstart >= width) {
			throw new IndexOutOfBoundsException("Coordinate xstart not in maze");
		}
		if (ystart < 0 || ystart >= height) {
			throw new IndexOutOfBoundsException("Coordinate ystart not in maze");
		}
		
		Maze maze = new Maze(width, height);
		
		throw new UnsupportedOperationException();
	}

	@Override
	public void carve(Maze maze, Cell cell) {
		
	}

}

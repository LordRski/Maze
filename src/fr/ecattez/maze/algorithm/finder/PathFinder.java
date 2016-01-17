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
package fr.ecattez.maze.algorithm.finder;

import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Grid;

/**
 * Permet de trouver un chemin entre deux cellules dans une grille.
 */
public abstract class PathFinder implements Runnable {
	
	protected Grid grid;
	protected Coordinates start;
	protected Coordinates end;
	
	private boolean success;
	
	public PathFinder(Grid grid, Coordinates start, Coordinates end) {
		this.grid = grid;
		this.start = start;
		this.end = end;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public Coordinates getStart() {
		return start;
	}
	
	public Coordinates getEnd() {
		return end;
	}
	
	public boolean hasSucceeded() {
		return success;
	}
	
	public void success() {
		success = true;
	}

}

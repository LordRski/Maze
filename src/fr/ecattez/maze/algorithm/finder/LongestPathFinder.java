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

import java.util.ArrayDeque;
import java.util.Queue;

import fr.ecattez.maze.entity.Cardinal;
import fr.ecattez.maze.entity.Cartesian;
import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Grid;


/**
 * Algorithme pour trouver le chemin le plus long entre deux cellules d'une grille.
 */
public class LongestPathFinder extends PathFinder {
	
	public LongestPathFinder(Grid grid, Coordinates start) {
		super(grid, start, new Cartesian(start.getX(), start.getY()));
	}

	@Override
	public void run() {
		if (!grid.contains(start)) {
			throw new IllegalArgumentException("Can not find path with illegal start point: " + start);
		}
		Queue<Coordinates> queue = new ArrayDeque<>();
		Coordinates current;
		Coordinates next;
		queue.offer(start);
		while (!queue.isEmpty()) {
			current = queue.remove();
			for (Cardinal direction : Cardinal.values()) {
				next = current.add(direction);
				if (grid.contains(next) && !grid.isWalled(current, direction) && grid.isAvailable(next)) {
					grid.setMass(next, grid.getMass(current) + 1);
					if (grid.getMass(next) > grid.getMass(end)) {
						end = next;
					}
					grid.use(next);
					queue.offer(next);
				}
			}
		}
		success();
		grid.restoreAll();
	}

}

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

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Direction;
import fr.ecattez.maze.entity.Maze;

/**
 * Algorithme de path finding avec une file.
 */
public class QueuePathFinder implements PathFinder {

	@Override
	public boolean findPath(Maze maze, Cell start, Cell end) {
		
		if (!maze.canContain(start)) {
			throw new IllegalArgumentException("Can not find path with illegal start point: " + start);
		}
		if (!maze.canContain(end)) {
			throw new IllegalArgumentException("Can not find path with illegal end point: " + end);
		}
		
		Queue<Cell> q = new ArrayDeque<Cell>();
		Cell c;
		Cell n;
		
		q.offer(start);
		
		while (!q.isEmpty()) {
			c = q.remove();
			
			if (c.equals(end)) {
				return true;
			}

			for (Direction d : Direction.values()) {
				n = c.add(d);
				if (maze.canContain(n)) {
					n = maze.get(n);
					if (!maze.hasWall(c, d) && !n.isVisited()) {
						n.visit();
						q.offer(n);
					}
				}
			}
		}
		return false;
	}

}
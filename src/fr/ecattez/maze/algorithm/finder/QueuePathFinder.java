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
import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Grid;

/**
 * Implémentation de l'algorithme de Path Finding avec une fFile.
 */
public class QueuePathFinder extends PathFinder {

	public QueuePathFinder(Grid grid, Coordinates start, Coordinates end) {
		super(grid, start, end);
	}

	@Override
	public void run() {
		if (!grid.contains(start)) {
			throw new IllegalArgumentException("Can not find path with illegal start point: " + start);
		}
		if (!grid.contains(end)) {
			throw new IllegalArgumentException("Can not find path with illegal end point: " + end);
		}
		Queue<Coordinates> q = new ArrayDeque<>();
		Coordinates current;
		Coordinates next;
		q.offer(start);
		while (!q.isEmpty()) {
			current = q.remove();
			if (current.equals(end)) {
				success();
				break;
			}
			for (Cardinal direction : Cardinal.values()) {
				next = current.add(direction);
				if (grid.contains(next) && !grid.isWalled(current, direction) && grid.isAvailable(next)) {
					grid.use(next);
					q.offer(next);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		grid.restoreAll();
	}

}

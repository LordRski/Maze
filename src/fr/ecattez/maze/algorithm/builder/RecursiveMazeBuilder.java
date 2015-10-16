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
package fr.ecattez.maze.algorithm.builder;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Direction;
import fr.ecattez.maze.entity.Maze;

/**
 * Algorithme du Recursive Backtracker pour créer un labyrinthe.
 */
public class RecursiveMazeBuilder extends MazeBuilder {

	@Override
	protected Maze create(int width, int height, int xstart, int ystart) {
		if (xstart < 0 || xstart >= width) {
			throw new IndexOutOfBoundsException("Coordinate xstart not in maze");
		}
		if (ystart < 0 || ystart >= height) {
			throw new IndexOutOfBoundsException("Coordinate ystart not in maze");
		}
		
		Maze maze = new Maze(width, height);
		carve(maze, maze.get(xstart, ystart));

		Cell entrance = maze.randomAccess();
		Cell exit = defineExit(maze, entrance);
		maze.setEntrance(entrance);
		maze.setExit(exit);
		
		return maze;
	}

	@Override
	public void carve(Maze m, Cell c) {
		Direction[] directions = Direction.shuffles();
		Cell n;
		for (Direction d : directions) {
			n = c.add(d);
			if (m.canContain(n)) {
				n = m.get(n);
				if (n.val() == 0) {
					c.val(c.val() | d.exponent());
					n.val(n.val() | d.opposite().exponent());
					carve(m, n);
				}
			}
		}
	}

	@Override
	public Cell defineExit(Maze maze, Cell entrance) {
		Queue<Cell> queue = new ArrayDeque<Cell>();
		Map<Cell, Integer> map = new HashMap<Cell, Integer>();
		Cell exit = entrance.clone();
		Cell[] cells = maze.getCells();
		Cell c;
		Cell n;
		int val;
		
		for (Cell cell : cells) {
			map.put(cell, 0);
		}
		
		queue.offer(entrance);
		
		while (!queue.isEmpty()) {
			c = queue.remove();
			for (Direction d : Direction.values()) {
				n = c.add(d);
				if (!maze.hasWall(c, d) && maze.canContain(n)) {
					n = maze.get(n);
					if (map.get(n) == 0) {
						val = map.get(c) + 1;
						map.put(n, val);
						if (val > map.get(exit)) {
							exit = n;
						}
						queue.offer(n);
					}
				}
			}		
		}
		return exit;
	}

}

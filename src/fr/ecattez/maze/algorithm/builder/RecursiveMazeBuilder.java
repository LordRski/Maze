/**
 * This file is part of Grid.
 *
 * Grid is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Grid is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.				 
 * 
 * You should have received a copy of the GNU General Public License
 * along with Grid.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Edouard CATTEZ <edouard.cattez@sfr.fr> (La 7 Production)
 */
package fr.ecattez.maze.algorithm.builder;

import fr.ecattez.maze.algorithm.finder.LongestPathFinder;
import fr.ecattez.maze.algorithm.finder.PathFinder;
import fr.ecattez.maze.entity.Cardinal;
import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Maze;

/**
 * Algorithme du Recursive Backtracker pour créer un labyrinthe.
 */
public class RecursiveMazeBuilder extends MazeBuilder {

	@Override
	protected Maze create(int width, int height, Coordinates start) {
		Maze maze = new Maze(width, height);
		carve(maze, start);
		
		PathFinder finder = new LongestPathFinder(maze, start);
		finder.run();
		
		maze.setEntrance(start);
		maze.setExit(finder.getEnd());
		return maze;
	}

	@Override
	public void carve(Maze maze, Coordinates coord) {
		Coordinates next;
		for (Cardinal direction : Cardinal.shuffles()) {
			next = coord.add(direction);
			if (maze.contains(next) && maze.getValue(next) == 0) {
				maze.wallUp(coord, direction);
				maze.wallUp(next, direction.opposite());
				carve(maze, next);
			}
		}
	}

}

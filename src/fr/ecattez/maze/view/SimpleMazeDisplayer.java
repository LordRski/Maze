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
package fr.ecattez.maze.view;

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Direction;
import fr.ecattez.maze.entity.Maze;

/**
 * @author Edouard
 *
 */
public class SimpleMazeDisplayer implements Displayer {

	@Override
	public String display(Maze maze) {
		String result = " ";
		int y = 0;
		
		for (int x = 0; x < (maze.getWidth() * 2 - 1); x++) {
			result += "_";
		}
		result += "\n|";
		
		Cell[] cells = maze.getCells();
		for (Cell c : cells) {
			if (c.getY() != y) {
				y = c.getY();
				result += "\n|";
			}
			result += c.hasWall(Direction.SOUTH) ? "_" : " ";
			if (c.hasWall(Direction.EAST)) {
				result += "|";
			}
			else {
				result += ((c.val() | maze.get(c.getX() + 1, c.getY()).val()) & Direction.SOUTH.exponent()) == 0 ? "_" : " ";
			}
		}		
		return result;
	}

}

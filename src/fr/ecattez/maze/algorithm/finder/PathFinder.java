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

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Maze;

/**
 * Permet de trouver un chemin dans un labyrinthe.
 */
public interface PathFinder {
	
	/**
	 * Test s'il existe un chemin entre la case de départ et la case d'arrivée
	 * 
	 * @param	maze
	 * 			le labyrinthe dans lequel tester l'algorithme de path finding
	 * @param	start
	 * 			la case de départ dans le labyrinthe
	 * @param	end
	 * 			la case d'arrivée dans le labyrinthe
	 * 
	 * @return vrai s'il existe un chemin entre la case de départ et la case d'arrivée
	 */
	public boolean findPath(Maze maze, Cell start, Cell end);

}

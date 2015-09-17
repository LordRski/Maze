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
 * Permet de fabriquer des labyrinthes.
 */
public interface MazeBuilder {
	
	/**
	 * Construit un labyrinthe
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * @param	xstart
	 * 			la coordonnée x de départ (x >= 0 & x < width)
	 * @param	ystart
	 * 			la coordonnée y de départ (y >= 0 & y < height)
	 * 
	 * @return un nouveau labyrinthe
	 */
	public Maze build(int width, int height, int xstart, int ystart);
	
	/**
	 * Ouvre un passage dans un labyrinthe à partir d'une case contenu dans celui-ci
	 * 
	 * @param	maze
	 * 			le labyrinthe dans lequel on crée un passage
	 * @param	coord
	 * 			la case à partir de laquelle on crée un passage
	 */
	public void carve(Maze maze, Cell cell);

}

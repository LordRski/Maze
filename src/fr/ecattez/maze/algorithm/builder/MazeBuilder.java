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

import fr.ecattez.maze.entity.Cell;
import fr.ecattez.maze.entity.Maze;

/**
 * Permet de fabriquer des labyrinthes.
 */
public abstract class MazeBuilder {
	
	/**
	 * Construit un labyrinthe
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * 
	 * @return un nouveau labyrinthe
	 */
	public Maze build(int width, int height) {
		return build(width, height, (int) (Math.random() * width), (int) (Math.random() * height));
	}
	
	/**
	 * Construit un labyrinthe
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * @param	xstart
	 * 			la coordonnée x de départ pour la construction du labyrinthe (normalement: x >= 0 & x < width)
	 * @param	ystart
	 * 			la coordonnée y de départ pour la construction du labyrinthe (normalement: y >= 0 & y < height)
	 * 
	 * @return un nouveau labyrinthe
	 */
	public Maze build(int width, int height, int xstart, int ystart) {
		if (width < 0 || width > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect width=" + width);
		}
		if (height < 0 || height > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect height=" + height);
		}
		if (xstart < 0 || xstart >= width) {
			throw new IndexOutOfBoundsException("Coordinate xstart=" + xstart + " not in maze");
		}
		if (ystart < 0 || ystart >= height) {
			throw new IndexOutOfBoundsException("Coordinate ystart=" + ystart + " not in maze");
		}
		return create(width, height, xstart, ystart);
	}
	
	/**
	 * Construit un labyrinthe (interne au package)
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * @param	xstart
	 * 			la coordonnée x de départ pour la construction du labyrinthe (normalement: x >= 0 & x < width)
	 * @param	ystart
	 * 			la coordonnée y de départ pour la construction du labyrinthe (normalement: y >= 0 & y < height)
	 * 
	 * @return un nouveau labyrinthe
	 */
	protected abstract Maze create(int width, int height, int xstart, int ystart);
	
	/**
	 * Ouvre un passage dans un labyrinthe à partir d'une case contenu dans celui-ci
	 * 
	 * @param	m
	 * 			le labyrinthe dans lequel on crée un passage
	 * @param	c
	 * 			la case à partir de laquelle on crée un passage
	 */
	public abstract void carve(Maze m, Cell c);
	
	/**
	 * Définit la sortie du labyrinthe à partir de la case de départ
	 * 
	 * @param	entrance
	 * 			la case de départ du labyrinthe
	 * 
	 * @return la case de sortie du labyrinthe
	 */
	public abstract Cell defineExit(Maze maze, Cell entrance);

}

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

import fr.lordrski.maze.Cell;
import fr.lordrski.maze.Maze;

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
		return build(width, height, width * (int) Math.random(), height * (int) Math.random());
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
	public abstract Maze build(int width, int height, int xstart, int ystart);
	
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

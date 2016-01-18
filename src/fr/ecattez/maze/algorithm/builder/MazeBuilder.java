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

import fr.ecattez.maze.entity.Cartesian;
import fr.ecattez.maze.entity.Coordinates;
import fr.ecattez.maze.entity.Maze;

/**
 * Constructeur de labyrinthe.
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
	 * @return	un nouveau labyrinthe
	 */
	public Maze build(int width, int height) {
		return build(width, height, new Cartesian((int) (Math.random() * width), (int) (Math.random() * height)));
	}
	
	/**
	 * Construit un labyrinthe
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * @param	start
	 * 			les coordonnées de départ pour la construction du labyrinthe
	 * 
	 * @return	un nouveau labyrinthe
	 */
	public Maze build(int width, int height, final Coordinates start) {
		if (width < 0 || width > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect width=" + width);
		}
		if (height < 0 || height > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect height=" + height);
		}
		double xstart = start.getX();
		double ystart = start.getY();
		if (xstart < 0 || xstart >= width) {
			throw new IndexOutOfBoundsException("Coordinate xstart=" + xstart + " not in maze");
		}
		if (ystart < 0 || ystart >= height) {
			throw new IndexOutOfBoundsException("Coordinate ystart=" + ystart + " not in maze");
		}
		return create(width, height, start);
	}
	
	/**
	 * Construit un labyrinthe (interne au package)
	 * 
	 * @param	width
	 * 			la longueur du labyrinthe
	 * @param	height
	 * 			la hauteur du labyrinthe
	 * @param	start
	 * 			les coordonnées de départ pour la construction du labyrinthe
	 * 
	 * @return	un nouveau labyrinthe
	 */
	protected abstract Maze create(int width, int height, final Coordinates start);
	
	/**
	 * Ouvre un passage dans un labyrinthe à partir d'une case contenu dans celui-ci
	 * 
	 * @param	maze
	 * 			le labyrinthe dans lequel on crée un passage
	 * @param	coord
	 * 			les coordonnées à partir des quels on crée un passage
	 */
	public abstract void carve(Maze maze, final Coordinates coord);

}

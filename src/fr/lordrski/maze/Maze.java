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
package fr.lordrski.maze;

import fr.lordrski.maze.util.Cell;

/**
 * Représentation d'un labyrinthe dans un repère 2D.
 */
public class Maze {
	
	public static final int WIDTH = 40;
	public static final int HEIGHT = 20;
	
	private final int width;
	private final int height;
	private Cell[] cell;
	private Cell entrance;
	private Cell exit;
	
	public Maze(int width, int height) {
		if (width < 0 || width > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect width");
		}
		if (height < 0 || height > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Can not build a maze with incorrect height");
		}
		
		this.width = width;
		this.height = height;
		this.cell = new Cell[width * height];
	}
	
	public Maze() {
		this(WIDTH, HEIGHT);
	}

	/**
	 * Retourne la largueur du labyrinthe
	 * 
	 * @return la largueur du labyrinthe
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Retourne la hauteur du labyrinthe
	 * 
	 * @return la hauteur du labyrinthe
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Retourne la case de départ du labyrinthe
	 * 
	 * @return la case de départ du labyrinthe
	 */
	public Cell getEntrance() {
		return this.entrance;
	}
	
	/**
	 * Saisi la case de départ du labyrinthe
	 * 
	 * @param	entrance
	 * 			la case de départ du labyrinthe
	 */
	public void setEntrance(Cell entrance) {
		if (!canContain(entrance)) {
			throw new IllegalArgumentException("Entrance " + entrance + " not in maze");
		}
		this.entrance = entrance;
	}
	
	/**
	 * Retourne la case d'arrivée du labyrinthe
	 * 
	 * @return la case d'arrivée du labyrinthe
	 */
	public Cell getExit() {
		return this.exit;
	}
	
	/**
	 * Saisi la case d'arrivée du labyrinthe
	 * 
	 * @param	exit
	 * 			la case d'arrivée du labyrinthe
	 */
	public void setExit(Cell exit) {
		if (!canContain(exit)) {
			throw new IllegalArgumentException("Exit " + exit + " not in maze");
		}
		this.exit = exit;
	}
	
	/**
	 * Test si une case peut exister dans un labyrinthe
	 * 
	 * @param	c
	 * 			la case à tester
	 * 
	 * @return vrai si la case peut exister dans un labyrinthe
	 */
	public boolean canContain(Cell c) {
		double x = c.getX();
		double y = c.getY();
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
	/**
	 * Test si une case existe dans un labyrinthe
	 * 
	 * @param	c
	 * 			la case à tester
	 * 
	 * @return vrai si la case est contenue dans un labyrinthe
	 */
	public boolean contains(Cell c) {
		return canContain(c) && cell[(int) (c.getY() * width + c.getX())].equals(c);
	}
}

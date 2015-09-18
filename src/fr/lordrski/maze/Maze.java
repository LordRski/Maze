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

/**
 * Représentation d'un labyrinthe dans un repère 2D.
 */
public class Maze implements Cloneable {
	
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
		
		int size = width * height;
		int x = 0;
		int y = 0;
		for (int i=0; i < size; i++) {
			cell[i] = new Cell(x++, y);
			if (x == width) {
				x = 0;
				y++;
			}
		}
	}
	
	public Maze() {
		this(WIDTH, HEIGHT);
	}
	
	/**
	 * Retourne la taille du labyrinthe (longueur * hauteur)
	 * 
	 * @return la taille du labyrinthe
	 */
	public int size() {
		return width * height;
	}

	/**
	 * Retourne la largueur du labyrinthe
	 * 
	 * @return la largueur du labyrinthe
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Retourne la hauteur du labyrinthe
	 * 
	 * @return la hauteur du labyrinthe
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Retourne toutes les cases du labyrinthe
	 * 
	 * @return les cases du labyrinthe
	 */
	public Cell[] getCells() {
		return cell;
	}
	
	/**
	 * Retourne la case de départ du labyrinthe
	 * 
	 * @return la case de départ du labyrinthe
	 */
	public Cell getEntrance() {
		return entrance;
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
	 * Test si une case est l'entrée du labyrinthe
	 * 
	 * @param	cell
	 * 			la case à tester
	 * 
	 * @return vrai si la case est l'entrée du labyrinthe
	 */
	public boolean isEntrance(Cell cell) {
		return entrance.equals(cell);
	}
	
	/**
	 * Retourne la case d'arrivée du labyrinthe
	 * 
	 * @return la case d'arrivée du labyrinthe
	 */
	public Cell getExit() {
		return exit;
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
	 * Test si une case est la sortie du labyrinthe
	 * 
	 * @param	cell
	 * 			la case à tester
	 * 
	 * @return vrai si la case est la sortie du labyrinthe
	 */
	public boolean isExit(Cell cell) {
		return exit.equals(cell);
	}
	
	/**
	 * Récupère la case de coordonnées (x,y) dans le labyrinthe
	 * 
	 * @param	x
	 * 			la coordonnée x
	 * @param	y
	 * 			la coordonnée y
	 * 
	 * @return la case de coordonnées (x,y) dans le labyrinthe
	 */
	public Cell get(int x, int y) {
		if (canContain(x, y)) {
			return cell[y * width + x];
		}
		throw new IndexOutOfBoundsException("Cell[x=" + x + ", y=" + y + "] does not exist in this maze");
	}
	
	/**
	 * Récupère la véritable case de coordonnées (c.x, c.y) dans le labyrinthe
	 * 
	 * @param	c
	 * 			les coordonnées de référence pour retrouver la vraie case dans le labyrinthe
	 * 
	 * @return la case de coordonnées (c.x, c.y) dans le labyrinthe
	 */
	public Cell get(Coordinates c) {
		return get(c.getX(), c.getY());
	}
	
	/**
	 * Retourne une case aléatoire du labyrinthe
	 * 
	 * @return une case aléatoire du labyrinthe
	 */
	public Cell randomAccess() {
		return cell[cell.length * (int) Math.random()];
	}
	
	/**
	 * Test si un couple (x,y) peut exister dans un labyrinthe
	 * 
	 * @param	x
	 * 			la coordonnée x à tester
	 * @param	y
	 * 			la coordonnée y à tester
	 * 
	 * @return vrai si les coordonnées peuvent exister dans un labyrinthe
	 */
	public boolean canContain(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
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
		return c != null && canContain(c.getX(), c.getY());
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
		return canContain(c) && cell[(c.getY() * width + c.getX())].equals(c);
	}
	
	/**
	 * Test s'il y a un mur dans la direction voulue à partir d'une case du labyrinthe
	 * 
	 * @param	c
	 * 			la case à tester
	 * @param	d
	 * 			la direction à tester
	 * 
	 * @return vrai s'il existe un mur à partir de la case du labyrinthe, dans la direction voulue
	 */
	public boolean hasWall(Cell c, Direction d) {
		return c.hasWall(d);
	}
	
	@Override
	public String toString() {
		String result = " ";
		int y = 0;
		
		for (int x = 0; x < (width * 2 - 1); x++) {
			result += "_";
		}
		result += "\n|";
		
		for (Cell c : cell) {
			if (c.getY() != y) {
				y = c.getY();
				result += "\n|";
			}
			result += c.hasWall(Direction.SOUTH) ? "_" : " ";
			if (c.hasWall(Direction.EAST)) {
				result += "|";
			}
			else {
				result += ((c.val() | get(c.getX() + 1, c.getY()).val()) & Direction.SOUTH.exponent()) == 0 ? "_" : " ";
			}
		}		
		return result;
	}
	
	@Override
	public Maze clone() {
		Maze other = new Maze(width, height);
		if (cell != null) {
			other.cell = cell.clone();
		}
		if (entrance != null) {
			other.entrance = entrance.clone();
		}
		if (exit != null) {
			other.exit = entrance.clone();
		}
		return other;
	}
	
}

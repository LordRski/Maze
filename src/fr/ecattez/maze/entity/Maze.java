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
package fr.ecattez.maze.entity;

/**
 * Implémentation d'un labyrinthe.
 */
public class Maze extends ArrayGrid {

	private Coordinates entrance;
	private Coordinates exit;
	
	public Maze(int width, int height) {
		super(width, height);
	}
	
	/**
	 * @return	les coordonnées de la cellule de départ du labyrinthe
	 */
	public Coordinates getEntrance() {
		return entrance;
	}
	
	/**
	 * Définit les coordonnées de la cellule de départ du labyrinthe
	 * 
	 * @param	entrance
	 * 			les coordonnées de la cellule de départ du labyrinthe
	 */
	public void setEntrance(Coordinates entrance) {
		this.entrance = entrance;
	}
	
	/**
	 * @return	les coordonnées de la cellule d'arrivée du labyrinthe
	 */
	public Coordinates getExit() {
		return exit;
	}
	
	/**
	 * Définit les coordonnées de la cellule d'arrivée du labyrinthe
	 * 
	 * @param	exit
	 * 			les coordonnées de la cellule d'arrivée
	 */
	public void setExit(Coordinates exit) {
		this.exit = exit;
	}

}

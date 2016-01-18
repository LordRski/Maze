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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Définit une grille de cellules.
 */
public abstract class Grid extends Observable implements Observer {
	
	private int width;
	private int height;
	
	private Deque<Coordinates> deck;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.deck = new ArrayDeque<>();
	}
	
	/**
	 * Position une cellule dans la grille
	 * 
	 * @param	c
	 * 			la cellule à placer
	 * @param	coord
	 * 			les coordonnées de la cellule
	 */
	public abstract void set(Cell c, Coordinates coord);
	
	/**
	 * Récupère la cellule à une position dans la grille
	 * 
	 * @param	coord
	 * 			
	 * les coordonnées de la cellule
	 * 
	 * @return	une instance de Cell
	 */
	public abstract Cell get(Coordinates coord);
	
	/**
	 * @return	la largeur de la grille
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return	la hauteur de la grille
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Vérifie si des coordonnées sont contenues dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées à vérifier
	 * 
	 * @return	<true> si les coordonnées sont contenus dans la grille, <false> sinon
	 */
	public boolean contains(Coordinates coord) {
		double x = coord.getX();
		double y = coord.getY();
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
	/**
	 * Vérifie si une cellule est murée dans la direction voulue
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * @param	direction
	 * 			le point cardinal qui définit la direction
	 * 
	 * @return	<true> si la cellule est murée, <false> sinon
	 */
	public boolean isWalled(Coordinates coord, Cardinal direction) {
		return get(coord).isWalled(direction);
	}
	
	/**
	 * Crée un mur dans une cellule de la grille dans la direction voulue
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * @param	direction
	 * 			le point cardinal qui définit la direction
	 */
	public void wallUp(Coordinates coord, Cardinal direction) {
		get(coord).wallUp(direction);
	}
	
	/**
	 * Vérifie si une cellule est disponible
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * 
	 * @return	<true> si la cellule est disponible, <false> sinon
	 */
	public boolean isAvailable(Coordinates coord) {
		return get(coord).isAvailable();
	}
	
	/**
	 * Utilise une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 */
	public void use(Coordinates coord) {
		if (get(coord).use()) {
			deck.push(coord);
		}
	}
	
	/**
	 * Rend disponible une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 */
	public void restore(Coordinates coord) {
		if (get(coord).restore()) {
			deck.remove(coord);
		}
	}
	
	/**
	 * Rend disponible toutes les cellules utilisées dans la grille
	 */
	public void restoreAll() {
		while (!deck.isEmpty()) {
			get(deck.pop()).restore();
		}
	}
	
	/**
	 * Récupère la valeur d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * 
	 * @return	la valeur de la cellule
	 */
	public int getValue(Coordinates coord) {
		return get(coord).getValue();
	}
	
	/**
	 * Saisie la valeur d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * @param	value
	 * 			la valeur de la cellule
	 */
	public void setValue(Coordinates coord, int mass) {
		get(coord).setValue(mass);
	}
	
	/**
	 * Incrémente la valeur d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 */
	public void incValue(Coordinates coord) {
		get(coord).incValue();
	}
	
	/**
	 * Récupère la masse d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * 
	 * @return	la masse de la cellule
	 */
	public int getMass(Coordinates coord) {
		return get(coord).getMass();
	}
	
	/**
	 * Saisie la masse d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 * @param	mass
	 * 			la masse de la cellule
	 */
	public void setMass(Coordinates coord, int mass) {
		get(coord).setMass(mass);
	}
	
	/**
	 * Incrémente la masse d'une cellule dans la grille
	 * 
	 * @param	coord
	 * 			les coordonnées de la cellule
	 */
	public void incMass(Coordinates coord) {
		get(coord).incMass();
	}
	
	/**
	 * Récupère la liste des cellules disponibles, adjacentes à la cellule passée en paramètre
	 * 
	 * @param	c
	 * 			les coordonnées pour lesquelles il faut trouver les voisins disponibles
	 * 
	 * @return	la liste des coordonées voisines disponibles
	 */
	public List<Coordinates> getAvailableAdjacentCells(Coordinates c) {
		List<Coordinates> coords = new ArrayList<>();
		Coordinates tmp;
		for (Cardinal direction : Cardinal.values()) {
			tmp = c.add(direction);
			if (contains(tmp) && !isWalled(c, direction) && isAvailable(tmp)) {
				coords.add(tmp);
			}
		}
		return coords;
	}
	
	/**
	 * @return	un couple de coordonnées aléatoire, contenu dans la grille
	 */
	public Coordinates getRandomPosition() {
		int x = (int) (Math.random() * width);
		int y = (int) (Math.random() * height);
		return new Cartesian(x, y);
	}
	
	
	/* La grille change quand les cellules changent */
	@Override
	public void update(Observable obs, Object o) {
		setChanged();
		notifyObservers(obs);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Coordinates current;
		Cell cell = new Cell();
		
		builder.append(" ");
		for (int x = 0; x < width * 2 - 1; x++) {
			builder.append("_");
		}
		builder.append("\n");
		for (int y=0; y < height; y++) {
			builder.append("|");
			for (int x=0; x < width; x++) {
				current = new Cartesian(x,y);
				if (this.isWalled(current, Cardinal.SOUTH)) {
					builder.append("_");
				}
				else {
					builder.append(" ");
				}
				if (this.isWalled(current, Cardinal.EAST)) {
					builder.append("|");
				}
				else {
					cell.setMass(this.getMass(current) | this.getMass(new Cartesian(current.getX() + 1, current.getY())));
					if (cell.isWalled(Cardinal.SOUTH)) {
						builder.append("_");
					}
					else {
						builder.append(" ");
					}
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	

}

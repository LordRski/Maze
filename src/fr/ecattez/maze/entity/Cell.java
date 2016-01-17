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

import java.util.Observable;

/**
 * Implémentation d'un système de cellules.
 * 
 * La vérification des murs se fait avec un ET logique entre la valeur de la cellule et la valeur de la direction à prendre (point cardinal).
 */
public class Cell extends Observable implements Scalable, Mass, Cloneable {
	
	private boolean available = true;
	private transient int mass;
	private int value;
	
	public Cell() {}
	
	/* Met à jour la cellule */
	private void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Utilise la cellule
	 * 
	 * @return	<true> si la cellule n'était pas déjà utilisée, <false> sinon
	 */
	public boolean use() {
		if (available) {
			available = false;
			update();
			return true;
		}
		return false;
	}
	
	/**
	 * Rend disponible la cellule
	 * 
	 * @return	<true> si la cellule n'était pas déjà disponible, <false> sinon
	 */
	public boolean restore() {
		if (!available) {
			available = true;
			update();
			return true;
		}
		return false;
	}
	
	/**
	 * @return	<true> si la cellule est disponible, <false> sinon
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Vérifie si la cellule est murée dans la direction voulue
	 * 
	 * @param	direction
	 * 			le point cardinal qui définit la direction
	 * 
	 * @return	<true> si la cellule est murée, <false> sinon
	 */
	public boolean isWalled(Cardinal direction) {
		return (value & direction.getValue()) == 0;
	}
	
	/**
	 * Crée un mur dans la direction voulue
	 * 
	 * @param	direction
	 * 			le point cardinal qui définit la direction
	 */
	public void wallUp(Cardinal direction) {
		value |= direction.getValue();
	}
	
	@Override
	public int getValue() {
		return value;
	}
	
	/**
	 * Modifie la valeur de la cellule
	 * 
	 * @param	value
	 * 			la nouvelle valeur de la cellule
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Incrémente la valeur de la cellule
	 */
	public void incValue() {
		this.value++;
	}
	
	@Override
	public int getMass() {
		return mass;
	}
	
	/**
	 * Modifie la masse de la cellule
	 * 
	 * @param	mass
	 * 			la nouvelle masse de la cellule
	 */
	public void setMass(int mass) {
		this.mass = mass;
	}
	
	/**
	 * Incrémente la masse de la cellule
	 */
	public void incMass() {
		this.mass++;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		Cell c = (Cell) o;
		return this.mass == c.mass;
	}
	
	/**
	 * Clone la cellule (la nouvelle cellule est disponible)
	 */
	public Cell clone() {
		Cell c = new Cell();
		c.mass = mass;
		return c;
	}

}

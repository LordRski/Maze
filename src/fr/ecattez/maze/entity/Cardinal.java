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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Représentation des points cardinaux.
 */
public enum Cardinal implements Coordinates, Scalable {
	
	NORTH(0, -1) {
		@Override
		public Cardinal opposite() {
			return SOUTH;
		}
	},
	EAST(1, 0) {
		@Override
		public Cardinal opposite() {
			return WEST;
		}
	},
	SOUTH(0, 1) {
		@Override
		public Cardinal opposite() {
			return NORTH;
		}
	},
	WEST(-1, 0) {
		@Override
		public Cardinal opposite() {
			return EAST;
		}
	};
	
	private int x;
	private int y;
	
	private Cardinal(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public Coordinates add(Coordinates c) {
		throw new UnsupportedOperationException("You can not add coordinates to cardinal points");
	}
	
	@Override
	public boolean isCloseTo(Coordinates c) {
		throw new UnsupportedOperationException("Cardinal points are close to no coordinates");
	}
	
	@Override
	public int getValue() {
		return 1 << ordinal();
	}
	
	/**
	 * @return	le point cardinal opposé au point cardinal courant
	 */
	public abstract Cardinal opposite();
	
	/**
	 * @return	les points cardinaux mélangés
	 */
	public static Cardinal[] shuffles() {
		List<Cardinal> cardinals = Arrays.asList(values());
		Collections.shuffle(cardinals);
		return (Cardinal[]) cardinals.toArray();
	}

}

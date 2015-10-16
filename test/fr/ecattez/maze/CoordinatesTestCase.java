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
package fr.ecattez.maze;

import org.junit.Test;

import junit.framework.TestCase;

import fr.ecattez.maze.entity.Coordinates;

public class CoordinatesTestCase extends TestCase {

	@Test
	public void test_A_coordEquals() {
		Coordinates c1 = new Coordinates(0, 1);
		Coordinates c2 = new Coordinates(0, 1);
		Coordinates c3 = new Coordinates(1, 0);
		
		assertEquals(c1, c2);
		assertEquals(c2, c1);
		assertNotSame(c1, c3);
		assertNotSame(c2, c3);
	}
	
	@Test
	public void test_B_coordHashCode() {
		Coordinates c1 = new Coordinates(0, 1);
		Coordinates c2 = new Coordinates(0, 1);
		Coordinates c3 = new Coordinates(1, 0);
		
		assertEquals(c1.hashCode(), c2.hashCode());
		assertEquals(c2.hashCode(), c1.hashCode());
		assertNotSame(c1.hashCode(), c3.hashCode());
	}

}

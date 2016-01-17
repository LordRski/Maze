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

import junit.framework.TestCase;

import org.junit.Test;

import fr.ecattez.maze.entity.Cardinal;
import fr.ecattez.maze.entity.Cartesian;

public class CardinalTestCase extends TestCase {
	
	@Test
	public void test_A_Cardinals() {
		assertEquals(Cardinal.NORTH.getX(), 0.0);
		assertEquals(Cardinal.NORTH.getY(), -1.0);
		assertEquals(Cardinal.EAST.getX(), 1.0);
		assertEquals(Cardinal.EAST.getY(), 0.0);
		assertEquals(Cardinal.SOUTH.getX(), 0.0);
		assertEquals(Cardinal.SOUTH.getY(), 1.0);
		assertEquals(Cardinal.WEST.getX(), -1.0);
		assertEquals(Cardinal.WEST.getY(), 0.0);
		
		assertEquals(new Cartesian(0,-1), Cardinal.NORTH);
		assertEquals(new Cartesian(1,0), Cardinal.EAST);
		assertEquals(new Cartesian(0,1), Cardinal.SOUTH);
		assertEquals(new Cartesian(-1,0), Cardinal.WEST);
	}
	
	@Test
	public void test_B_exponent() {
		assertEquals(Cardinal.NORTH.getValue(), 1);
		assertEquals(Cardinal.EAST.getValue(), 2);
		assertEquals(Cardinal.SOUTH.getValue(), 4);
		assertEquals(Cardinal.WEST.getValue(), 8);
	}

}

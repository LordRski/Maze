package fr.lordrski.maze;
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
import org.junit.Test;

import junit.framework.TestCase;

public class DirectionTestCase extends TestCase {
	
	@Test
	public void test_A_directions() {
		assertEquals(Direction.NORTH.getX(), 0);
		assertEquals(Direction.NORTH.getY(), -1);
		assertEquals(Direction.EAST.getX(), 1);
		assertEquals(Direction.EAST.getY(), 0);
		assertEquals(Direction.SOUTH.getX(), 0);
		assertEquals(Direction.SOUTH.getY(), 1);
		assertEquals(Direction.WEST.getX(), -1);
		assertEquals(Direction.WEST.getY(), 0);
		
		assertEquals(Direction.NORTH.toCoordinates(), new Coordinates(0,-1));
		assertEquals(Direction.EAST.toCoordinates(), new Coordinates(1,0));
		assertEquals(Direction.SOUTH.toCoordinates(), new Coordinates(0,1));
		assertEquals(Direction.WEST.toCoordinates(), new Coordinates(-1,0));
	}
	
	@Test
	public void test_B_exponent() {
		assertEquals(Direction.NORTH.exponent(), 1);
		assertEquals(Direction.EAST.exponent(), 2);
		assertEquals(Direction.SOUTH.exponent(), 4);
		assertEquals(Direction.WEST.exponent(), 8);
	}

}

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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.lordrski.maze.algorithm.builder.MazeBuilder;
import fr.lordrski.maze.algorithm.builder.RecursiveMazeBuilder;
import fr.lordrski.maze.algorithm.finder.PathFinder;
import fr.lordrski.maze.algorithm.finder.QueuePathFinder;

public class PathFinderTestCase {

	@Test
	public void test_a_findPath() {
		MazeBuilder builder = new RecursiveMazeBuilder();
		
		// Limite: 160*158 = 25 280 cases
		int width = 20;
		int height = 20;
		Maze maze = builder.build(width, height);
		
		PathFinder finder = new QueuePathFinder();
		boolean result;
		
		// Une vraie entrée et une vraie sortie
		result = finder.findPath(maze, maze.getEntrance(), maze.getExit());
		assertTrue(result);
		
		// Une vraie entrée et une fausse sortie
		result = false;
		try {
			result = finder.findPath(maze, maze.getEntrance(), new Cell(-1,-1));
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(!result);
		
		// Une fausse entrée et une vraie sortie
		result = false;
		try {
			result = finder.findPath(maze, new Cell(-1,-1), maze.getExit());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(!result);
		
		// Une fausse entrée et une fausse sortie
		result = false;
		try {
			result = finder.findPath(maze, new Cell(-2, -2), new Cell(-1,-1));
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(!result);
		
		System.out.println(maze);
	}

}
